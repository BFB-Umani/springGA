package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.persistance.CustomerRepository;
import grupparbete.spring.springGA.request.UserDetailsRequestModel;
import grupparbete.spring.springGA.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
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
