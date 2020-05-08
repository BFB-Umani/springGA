package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.PurchaseEntity;
import grupparbete.spring.springGA.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("purchases")
public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    public List<PurchaseEntity> getAllPurchases(){
        return purchaseService.getAllPurchases();
    }

    public Optional<PurchaseEntity> getAPurchase(long id){
        return purchaseService.getAPurchase(id);
    }
}
