package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.persistance.ChipsRepository;
import grupparbete.spring.springGA.persistance.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private ChipsRepository chipsRepository;
    private CustomerService customerService;
    private List<ChipsEntity> cartList = new ArrayList<>();
    private long totalSum = 0;
    private int totalAmountOfItems = 0;
    private String searchWord;

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public CartService(ChipsRepository chipsRepository,CustomerService customerService) {
        this.chipsRepository = chipsRepository;
        this.customerService = customerService;
    }


    public void addToCart(ChipsEntity chipsEntity) {

        boolean notInCart = true;

        for (int i = 0; i < cartList.size(); i++) {
            if (chipsEntity.getId().equals(cartList.get(i).getId())) {
                cartList.get(i).setQuantity(cartList.get(i).getQuantity() + 1);
                totalAmountOfItems++;
                totalSum = totalSum+chipsEntity.getPrice();
                notInCart = false;
                break;
            }
        }

        if(notInCart) {
            chipsEntity.setQuantity(1);
            cartList.add(chipsEntity);
            totalAmountOfItems++;
            totalSum = totalSum + chipsEntity.getPrice();
        }
    }

    public List<ChipsEntity> getCartList() {
        return cartList;
    }

    public void emptyCart() {
        cartList.clear();
        setTotalAmountOfItems(0);
        setTotalSum(0);
    }

    public Optional<ChipsEntity> findChipsEntity(long id) {
        return chipsRepository.findById(id);
    }

    public long getTotalSum() {
        if(customerService.getCurrentCustomerEntity().isPremiumCustomer()){
        return (long) (totalSum*0.9);
        }
        return totalSum;
    }

    public void setTotalSum(long totalSum) {
        this.totalSum = totalSum;
    }

    public int getTotalAmountOfItems() {
        return totalAmountOfItems;
    }

    public void setTotalAmountOfItems(int totalAmountOfItems) {
        this.totalAmountOfItems = totalAmountOfItems;
    }
}
