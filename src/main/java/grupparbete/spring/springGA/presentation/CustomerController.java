package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.persistance.CustomerRepository;
import grupparbete.spring.springGA.request.UserDetailsRequestModel;
import grupparbete.spring.springGA.request.UserLoginRequestModel;
import grupparbete.spring.springGA.service.CartService;
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
@RequestMapping("customers")
public class CustomerController {

    private CustomerService customerService;
    private CartService cartService;

    @Autowired
    public CustomerController(CustomerService customerService, CartService cartService) {
        this.customerService = customerService;
        this.cartService = cartService;
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @GetMapping
    public String goToCustomersPage() {
        String page = "";
        if (customerService.isCustomerLoggedIn()) {
            page = "customerPage";
        } else {
            page = "loginError";
        }
return page;
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
    public String saveACustomer(@ModelAttribute("customer") CustomerEntity customerEntity) {
        customerService.save(customerEntity);
        return "redirect:/login";

    }

    @GetMapping("/logout")
    public String logOut() {
        customerService.setCurrentCustomerEntity(null);
        cartService.emptyCart();
        return "redirect:/login";
    }

}
