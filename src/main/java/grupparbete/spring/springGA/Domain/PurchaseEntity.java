package grupparbete.spring.springGA.Domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;


@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "Purchases")
@SequenceGenerator(name="seqPur", initialValue=4, allocationSize = 1)
public class PurchaseEntity implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPur")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    CustomerEntity customerEntity;

    @ElementCollection
    Map<ChipsEntity, Long> entries = new TreeMap<>(Comparator.comparing(ChipsEntity::getId));

    private long purchasePrice;

    private boolean applyDiscount = false;

    private Date dateOfPurchase;

    public boolean isApplyDiscount() {
        return applyDiscount;
    }

    public void setApplyDiscount(boolean applyDiscount) {
        this.applyDiscount = applyDiscount;
    }

    public String getDateOfPurchase() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(dateOfPurchase);
        return date;
    }

    public void setDateOfPurchase(Date dateofPurchase) {
        this.dateOfPurchase = dateofPurchase;
    }

    public Map<ChipsEntity, Long> getEntries() {
        return entries;
    }

    public Long getId() {
        return id;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }


    public void setCustomerEntity(CustomerEntity customerEntity) {this.customerEntity = customerEntity;

    }

    public long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
