package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.Domain.PurchaseEntity;
import grupparbete.spring.springGA.persistance.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        List<ChipsEntity> chipsList = new ArrayList<>(purchaseEntity.getEntries().keySet());
        for (int i = 0; i < chipsList.size() ; i++) {
            chipsList.get(i).setQuantity(purchaseEntity.getEntries().get(chipsList.get(i)));
        }
        return chipsList;
    }

    public CustomerEntity getCustomerByPurchaseID(long id) {
        PurchaseEntity purchaseEntity = purchaseRepository.findPurchaseById(id);
        return purchaseEntity.getCustomerEntity();
    }


    public void addProduct(List<ChipsEntity> products, CustomerEntity currentCustomer) {
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setCustomerEntity(currentCustomer);
        long sum = 0;
        for (ChipsEntity product : products) {
            if (product.getQuantity() > 1) {
                purchaseEntity.getEntries().put(product, product.getQuantity());
            } else {
                purchaseEntity.getEntries().put(product, (long) 1);
            }
            sum += product.getPrice() * product.getQuantity();
        }
        purchaseEntity.setPurchasePrice(sum);
        Date date = new Date();
        purchaseEntity.setDateOfPurchase(date);
        purchaseRepository.save(purchaseEntity);

    }


}
