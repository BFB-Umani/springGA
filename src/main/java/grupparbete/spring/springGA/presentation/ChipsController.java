package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.service.ChipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chips")
public class ChipsController {

    private ChipsService chipsService;
    @Autowired
    public ChipsController (ChipsService chipsService){
        this.chipsService = chipsService;
    }
    @GetMapping
    public List<ChipsEntity> getAllChips(){
        return chipsService.getAllChips();
    }
    @GetMapping("/{id}")
    public Optional<ChipsEntity> getAChips(long id){
        return chipsService.getAChips(id);
    }


    @PostMapping("/book/add")
    public ChipsEntity addAChips(@RequestBody ChipsEntity chipsEntity){

        chipsService.addChips(chipsEntity);

        return chipsEntity;

    }


}
