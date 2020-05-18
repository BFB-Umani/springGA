package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    CartService cartService;

    @Autowired
    public CheckoutController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String checkOut(Model theModel){

        theModel.addAttribute("cartlist", cartService.getCartList());
        theModel.addAttribute("totalsum", cartService.getTotalSum());
        theModel.addAttribute("totalAmountOfItems", cartService.getTotalAmountOfItems());
        return "checkoutPage";
    }
    @GetMapping("/reciept")
    public String goToShowOrder(){
        return "recieptPage";
    }
}
