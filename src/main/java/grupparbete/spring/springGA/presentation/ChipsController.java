package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.request.UserLoginRequestModel;
import grupparbete.spring.springGA.service.ChipsService;
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

    @Autowired
    public ChipsController(ChipsService chipsService) {
        this.chipsService = chipsService;
    }

    @GetMapping
    public List<ChipsEntity> getAllChips() {
        return chipsService.getAllChips();
    }

    @GetMapping("/list")
    public String login(Model theModel){
        theModel.addAttribute("allChips",getAllChips());
        return "customerPage";
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

    @GetMapping("/search/{searchWord}")
    public List<ChipsEntity> searchForChips(@PathVariable String searchWord) {
        return chipsService.search(searchWord);
    }

}
