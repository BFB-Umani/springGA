package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.PurchaseEntity;
import grupparbete.spring.springGA.persistance.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    public List<PurchaseEntity> getAllPurchases(){
        return  purchaseRepository.findAll();
    }

    public Optional<PurchaseEntity> getAPurchase(long id){
        return purchaseRepository.findById(id);
    }

}
