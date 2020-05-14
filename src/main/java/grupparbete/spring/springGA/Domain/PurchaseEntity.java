package grupparbete.spring.springGA.Domain;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "Purchases")
public class PurchaseEntity implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    CustomerEntity customerEntity;

    private boolean applyDiscount = false;

    private Date dateofPurchase;

    public boolean isApplyDiscount() {
        return applyDiscount;
    }

    public void setApplyDiscount(boolean applyDiscount) {
        this.applyDiscount = applyDiscount;
    }

    public Date getDateofPurchase() {
        return dateofPurchase;
    }

    public void setDateofPurchase(Date dateofPurchase) {
        this.dateofPurchase = dateofPurchase;
    }
}
