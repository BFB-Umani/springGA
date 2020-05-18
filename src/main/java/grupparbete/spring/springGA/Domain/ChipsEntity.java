package grupparbete.spring.springGA.Domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.PERSIST;

@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "chips")
@SequenceGenerator(name="seqChi", initialValue=15, allocationSize = 1)
public class ChipsEntity implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqChi")
    private Long id;

    private String name;
    private long price;
    //private String displayPrice;
    private String image;
    private String brand;
    private long quantity;

    public ChipsEntity(String name, long price, String image, String brand, long quantity) {
    this.name=name;
    this.price=price;
    this.image=image;
    this.brand=brand;
    this.quantity = quantity;
    }

    public ChipsEntity() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }
}
