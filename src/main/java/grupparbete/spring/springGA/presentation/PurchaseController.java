package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.Domain.PurchaseEntity;
import grupparbete.spring.springGA.service.CartService;
import grupparbete.spring.springGA.service.CustomerService;
import grupparbete.spring.springGA.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {

    private PurchaseService purchaseService;
    private CustomerService customerService;
    private CartService cartService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, CustomerService customerService, CartService cartService) {
        this.purchaseService = purchaseService;
        this.customerService = customerService;
        this.cartService = cartService;
    }

    public List<PurchaseEntity> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/reciept")
    public String makePurchase(Model theModel) {
        String page = "";
        if (customerService.isCustomerLoggedIn()) {
            purchaseService.addProduct(cartService.getCartList(), customerService.getCurrentCustomerEntity());
            theModel.addAttribute("cartlist", cartService.getCartList());

            theModel.addAttribute("totalsum", cartService.getTotalSum());
            theModel.addAttribute("totalAmountOfItems", cartService.getTotalAmountOfItems());
            cartService.emptyCart();

            if (customerService.upgradeCustomerToPremium()) {
                theModel.addAttribute("upgradeToPremium", "Congratulations! You are our premium customer now! You will get 10% discount for all purchases in the future.");
            }else{
                theModel.addAttribute("upgradeToPremium", "");
            }
            page = "recieptPage";
        } else {
            page = "error";
        }

        return page;
    }


}
