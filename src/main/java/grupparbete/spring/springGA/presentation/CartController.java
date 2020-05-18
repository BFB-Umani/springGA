package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, Model model) {
        Optional<ChipsEntity> chipsEntity = cartService.findChipsEntity(id);
        if (chipsEntity.isPresent()) {
            cartService.addToCart(chipsEntity.get());

        }
        return "redirect:/chips/list/";
    }

    @GetMapping("searchadd/{id}")
    public String addToCartFromSearch(@PathVariable Long id, Model model) {
        Optional<ChipsEntity> chipsEntity = cartService.findChipsEntity(id);
        String searchWordForURL = cartService.getSearchWord();
        if (chipsEntity.isPresent()) {
            cartService.addToCart(chipsEntity.get());
        }
        return "redirect:/chips/list/chips/search?search=" + searchWordForURL ;
    }


}
