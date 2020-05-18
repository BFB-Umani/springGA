package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.persistance.ChipsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private ChipsRepository chipsRepository;
    private List<ChipsEntity> cartList = new ArrayList<>();
    private long totalSum = 0;
    private int totalAmountOfItems = 0;


    public CartService(ChipsRepository chipsRepository) {
        this.chipsRepository = chipsRepository;
    }


    public void addToCart(ChipsEntity chipsEntity) {
        cartList.add(chipsEntity);
        totalAmountOfItems++;
        totalSum = totalSum+chipsEntity.getPrice();

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