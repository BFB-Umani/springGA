package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.persistance.ChipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChipsService {

    private ChipsRepository chipsRepository;
    private CustomerService customerService;

    @Autowired
    public ChipsService(ChipsRepository chipsRepository, CustomerService customerService) {
        this.chipsRepository = chipsRepository;
        this.customerService = customerService;
    }

    public List<ChipsEntity> getAllChips() {
        List<ChipsEntity> chipsEntityList = chipsRepository.findAll();

        if(customerService.getCurrentCustomerEntity().isPremiumCustomer()){
            for (int i = 0; i <chipsEntityList.size() ; i++) {
                long discountPrice = (long) (chipsEntityList.get(i).getPrice()*0.9);
                chipsEntityList.get(i).setPrice(discountPrice);
            }
        }
        return chipsEntityList;
    }

    public Optional<ChipsEntity> getAChips(long id) {
        Optional<ChipsEntity> chipsEntity = chipsRepository.findById(id);
        if(customerService.getCurrentCustomerEntity().isPremiumCustomer()){
            if(chipsEntity.isPresent()){
                long discountPrice = (long) (chipsEntity.get().getPrice()*0.9);
                chipsEntity.get().setPrice(discountPrice);
            }
        }
        return chipsEntity;
    }

    public void addChips(ChipsEntity chipsEntity) {
        chipsRepository.save(chipsEntity);
    }

//    public List<Chips> search(String searchString) {
//        TypedQuery<Chips> q = em.createQuery("select c from Chips c inner join Brand as b on b.id = c.brand.id " +
//                "where lower(b.brandName) like :name or lower(c.name) like :name", Chips.class);
//        q.setParameter("name", "%" + toLower(searchString) + "%");
//        return q.getResultList();
//    }

    public List<ChipsEntity> search(String searchWord) {
        List<ChipsEntity> resultList1 = chipsRepository.findByBrandContainingIgnoreCase(searchWord);
        List<ChipsEntity> resultList2 = chipsRepository.findByNameContainingIgnoreCase(searchWord);
        resultList1.addAll(resultList2);
        return resultList1;
    }

    public void changePriceToDiscountPriceForPremiumCustomer(){
        if(customerService.getCurrentCustomerEntity().isPremiumCustomer()){
            for (int i = 0; i <getAllChips().size() ; i++) {
                long discountPrice = (long) (getAllChips().get(i).getPrice()*0.9);
                getAllChips().get(i).setPrice(discountPrice);
            }
        }

    }
}
