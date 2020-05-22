package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.request.UserLoginRequestModel;
import grupparbete.spring.springGA.service.CartService;
import grupparbete.spring.springGA.service.ChipsService;
import grupparbete.spring.springGA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("chips")
public class ChipsController {

    private ChipsService chipsService;
    private CartService cartService;
    private CustomerService customerService;

    @Autowired
    public ChipsController(ChipsService chipsService, CartService cartService, CustomerService customerService) {
        this.chipsService = chipsService;
        this.cartService = cartService;
        this.customerService = customerService;
    }


    @GetMapping
    public List<ChipsEntity> getAllChips() {
        return chipsService.getAllChips();
    }

    @GetMapping("/list")
    public String login(Model theModel) {
        String page = "";
        if (customerService.isCustomerLoggedIn()) {
            theModel.addAttribute("allChips", getAllChips());
            theModel.addAttribute("cartlist", cartService.getCartList());
            theModel.addAttribute("totalsum", cartService.getTotalSum());
            theModel.addAttribute("discountSum",cartService.getDiscountSum());
            theModel.addAttribute("totalAmountOfItems", cartService.getTotalAmountOfItems());
            page = "customerPage";
        } else {
            page = "error";
        }

        return page;
    }

    @GetMapping("/{id}")
    public Optional<ChipsEntity> getAChips(long id) {
        return chipsService.getAChips(id);
    }


    @PostMapping("/book/add")
    public ChipsEntity addAChips(@RequestBody ChipsEntity chipsEntity) {

        chipsService.addChips(chipsEntity);

        return chipsEntity;

    }

    @GetMapping("/list/chips/search")
    public String searchForChips(@RequestParam(value = "search", required = false) String searchWord, Model model) {
        String page = "";
        if (customerService.isCustomerLoggedIn()) {
            List<ChipsEntity> chipsEntities = chipsService.search(searchWord);
            model.addAttribute("search", chipsEntities);
            model.addAttribute("searchWord", searchWord);
            model.addAttribute("cartlist", cartService.getCartList());
            model.addAttribute("totalsum", cartService.getTotalSum());
            model.addAttribute("totalAmountOfItems", cartService.getTotalAmountOfItems());
            cartService.setSearchWord(searchWord);
            page = "search";
        } else {
            page = "listError";
        }
        return page;
    }


}
