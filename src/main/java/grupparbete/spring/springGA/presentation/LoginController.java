package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.request.UserLoginRequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login(Model theModel){
        UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel();
        theModel.addAttribute("userlogin",userLoginRequestModel);
        return "login";
    }
}
