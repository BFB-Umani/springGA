package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.Domain.PurchaseEntity;
import grupparbete.spring.springGA.service.AdminService;
import grupparbete.spring.springGA.service.ChipsService;
import grupparbete.spring.springGA.service.CustomerService;
import grupparbete.spring.springGA.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/adminPage")
public class AdminController {

    CustomerService customerService;
    AdminService adminService;
    PurchaseService purchaseService;
    ChipsService chipsService;

    @Autowired
    public AdminController(CustomerService customerService, AdminService adminService, PurchaseService purchaseService, ChipsService chipsService) {
        this.customerService = customerService;
        this.adminService = adminService;
        this.purchaseService = purchaseService;
        this.chipsService = chipsService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model){
        List<CustomerEntity> customerEntityList = customerService.getAllCustomers();
        model.addAttribute("customers", customerEntityList);

        return "adminPage";
    }

//    @GetMapping("/purchases")
//    public String goToPurchases(CustomerEntity customerEntity){
//
//        return "purchases";
//    }

    @GetMapping("/purchaseInfo/{id}")
    public String goToPurchaseInfo(@PathVariable long id, Model model){
        CustomerEntity customerEntity = purchaseService.getCustomerByPurchaseID(id);
        List<ChipsEntity> chipsEntityList = getChipsByPurchaseID(id);
        model.addAttribute("customer", customerEntity);
        model.addAttribute("chips", chipsEntityList);
        return "purchaseInfo";
    }

    @GetMapping("/purchases/{id}")
        public String goToCorneliaPurchase(@PathVariable long id, Model model){
        List<PurchaseEntity> purchaseEntityList = getPurchasesByCustomerID(id);
        CustomerEntity customerEntity = customerService.getCustomerById(id);
        model.addAttribute("purchases", purchaseEntityList);
        model.addAttribute("chosencustomer",customerEntity);
        return "purchases";
    }

    public List<ChipsEntity> getChipsByPurchaseID(long id) {
        return purchaseService.getChipsByPurchaseID(id);
    }

    public List<PurchaseEntity> getPurchasesByCustomerID(long id){
        return purchaseService.getPurchasesByCustomerID(id);
    }
}
