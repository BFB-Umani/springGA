package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.request.UserDetailsRequestModel;
import grupparbete.spring.springGA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("customers")
public class CustomerController {

    private CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public String getAllCustomers(Model theModel) {
        theModel.addAttribute("theCustomers", customerService.getAllCustomers());
        return "showCustomers";
    }

    @GetMapping("/{id}")
    public String getACustomer(Model theModel, @PathVariable long id) {
        List<CustomerEntity> customersList = new ArrayList<>();
        if (customerService.getACustomer(id).isPresent()) { // check if Optional<> is null
            customersList.add(customerService.getACustomer(id).get()); // get() -- if not null, get customerEntity object
        } else {
            return "errorMessage";
        }
        theModel.addAttribute("theCustomers", customersList);

        return "showCustomers";
    }

    @GetMapping
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        return "helloworld";

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

}
