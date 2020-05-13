package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.Domain.PurchaseEntity;
import grupparbete.spring.springGA.service.AdminService;
import grupparbete.spring.springGA.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/adminPage")
public class Admin2Controller {

    CustomerService customerService;
    AdminService adminService;

    public Admin2Controller(CustomerService customerService, AdminService adminService) {
        this.customerService = customerService;
        this.adminService = adminService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model){
        List<CustomerEntity> customerEntityList = customerService.getAllCustomers();
        model.addAttribute("customers", customerEntityList);
        String test = "test:)";
        model.addAttribute("testString", test);

        return "adminPage";
    }

    @GetMapping("/purchases")
    public String goToPurchases(){
        return "purchases";
    }
}
