package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.request.UserDetailsRequestModel;
import grupparbete.spring.springGA.request.UserLoginRequestModel;
import grupparbete.spring.springGA.service.AdminService;
import grupparbete.spring.springGA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {


    private CustomerService customerService;
    private AdminService adminService;


    @Autowired
    public UserController(CustomerService customerService, AdminService adminService) {
        this.customerService = customerService;
        this.adminService = adminService;
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public Optional<CustomerEntity> getACustomer(long id) {
        return customerService.getACustomer(id);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public String createCustomer(@RequestBody UserDetailsRequestModel userDetails) {
        String returnValue;
        returnValue = customerService.createUser(userDetails);
        return returnValue;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequestModel userLoginRequestModel) {
        if (customerService.loadUserByUsername(userLoginRequestModel) != "fail") {
            return "customerlogin";
        } else if (adminService.loadUserByUsername(userLoginRequestModel) != "fail") {
            return "adminlogin";
        } else {
            return "errorlogin";
        }
    }

}

