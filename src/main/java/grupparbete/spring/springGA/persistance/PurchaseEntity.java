package grupparbete.spring.springGA.persistance;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Purchases")
public class PurchaseEntity implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    CustomerEntity customerEntity;

    private boolean applyDiscount = false;

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customer) {
        this.customerEntity = customer;
    }

    public boolean isApplyDiscount() {
        return applyDiscount;
    }

    public void setApplyDiscount(boolean applyDiscount) {
        this.applyDiscount = applyDiscount;
    }
}
