package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.Domain.PurchaseEntity;
import grupparbete.spring.springGA.persistance.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

//    public Optional<PurchaseEntity> getAPurchase(long id){
//        return purchaseRepository.findById(id);
//    }

    public List<PurchaseEntity> getPurchasesByCustomerID(long id){
        return purchaseRepository.findByCustomerEntityId(id);
    }

    public List<ChipsEntity> getChipsByPurchaseID(long id){
        PurchaseEntity purchaseEntity = purchaseRepository.findPurchaseById(id);
        return new ArrayList<>(purchaseEntity.getEntries().keySet());
    }

    public CustomerEntity getCustomerByPurchaseID(long id) {
        PurchaseEntity purchaseEntity = purchaseRepository.findPurchaseById(id);
        return purchaseEntity.getCustomerEntity();
    }

   /*
    public void addProduct(ChipsEntity product) {
        if (entries.containsKey(product)) {
            entries.put(product, entries.get(product) + 1);
        } else {
            entries.put(product, (long) 1);
        }
    }

    public void removeProduct(Chips product) {
        if (entries.containsKey(product)) {
            entries.put(product, entries.get(product) - 1);
            if (entries.get(product) < 1) {
                entries.remove(product);
            }
        }
    } */
}
