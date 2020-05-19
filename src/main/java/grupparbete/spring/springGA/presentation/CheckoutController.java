package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.service.CartService;
import grupparbete.spring.springGA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private CartService cartService;
    private CustomerService customerService;

    @Autowired
    public CheckoutController(CartService cartService, CustomerService customerService) {
        this.cartService = cartService;
        this.customerService = customerService;
    }

    @GetMapping
    public String checkOut(Model theModel) {
        String page = "";
        if (customerService.isCustomerLoggedIn()) {
                theModel.addAttribute("cartlist", cartService.getCartList());
                theModel.addAttribute("totalsum", cartService.getTotalSum());
                theModel.addAttribute("totalAmountOfItems", cartService.getTotalAmountOfItems());
                page = "checkoutPage";
        } else {
            page = "error";
        }
        return page;
    }
}
