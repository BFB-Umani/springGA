package grupparbete.spring.springGA.Domain;

import grupparbete.spring.springGA.Domain.BrandEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.PERSIST;
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "chips")
public class ChipsEntity implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    private String name;
    private long price;
    //private String displayPrice;
    private String image;

    @ManyToOne(fetch = FetchType.EAGER, cascade = PERSIST)
    private BrandEntity brandEntity;

    public ChipsEntity(BrandEntity brand, String flavor, long price) {
        this.brandEntity = brand;
        this.name = flavor;
        this.price = price;
    }

}
