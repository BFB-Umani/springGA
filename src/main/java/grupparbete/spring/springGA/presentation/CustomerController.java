package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.persistance.CustomerRepository;
import grupparbete.spring.springGA.request.UserDetailsRequestModel;
import grupparbete.spring.springGA.request.UserLoginRequestModel;
import grupparbete.spring.springGA.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    public List<CustomerEntity> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    public Optional<CustomerEntity> getACustomer(long id){
        return customerService.getACustomer(id);
    }

    @GetMapping
    public String goToCustomersPage(){
        return "customerPage";
    }


    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public String createUser(@RequestBody UserDetailsRequestModel userDetails) {
        String returnValue;
        returnValue = customerService.createUser(userDetails);
        return returnValue;
    }

    @PostMapping("/save")
    public String saveACustomer(@ModelAttribute("customer") CustomerEntity customerEntity){
        customerService.save(customerEntity);
        return "redirect:/login";

    }
    @GetMapping("/logout")
    public String logOut(){
        customerService.setCurrentCustomerEntity(null);
        //empty shoppingcart
        return "redirect:/login";
    }

}
