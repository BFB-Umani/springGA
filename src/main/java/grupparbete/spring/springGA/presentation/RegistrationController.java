package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @GetMapping
    public String addANewCustomer(Model theModel){
        CustomerEntity customerEntity = new CustomerEntity();
        theModel.addAttribute("customer",customerEntity);
        return "registrationPage";
    }
}
