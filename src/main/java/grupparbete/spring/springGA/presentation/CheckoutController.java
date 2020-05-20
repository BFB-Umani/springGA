package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.service.CartService;
import grupparbete.spring.springGA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("checkout")
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
            page = "loginError";
        }
        return page;
    }

    @GetMapping("/checkoutAdd/{id}")
    public String addToCheckout(@PathVariable long id, Model model) {
        Optional<ChipsEntity> chipsEntity = cartService.findChipsEntity(id);
        if (chipsEntity.isPresent()) {
            cartService.addToCart(chipsEntity.get());

        }
        return "redirect:/checkout";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCheckout(@PathVariable long id, Model model) {
        Optional<ChipsEntity> chipsEntity = cartService.findChipsEntity(id);
        if (chipsEntity.isPresent()) {
            cartService.removeFromCart(chipsEntity.get());

        }
        return "redirect:/checkout";
    }
}
