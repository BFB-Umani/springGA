package grupparbete.spring.springGA.persistance;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.PERSIST;

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

    public ChipsEntity() {
    }

    public ChipsEntity(BrandEntity brand, String flavor, long price) {
        this.brandEntity = brand;
        this.name = flavor;
        this.price = price;
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

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Chips)) {
            return false;
        }
        Chips other = (Chips) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    } */

    @Override
    public String toString() {
        return "Chips{" +
                "name='" + name + '\'' +
                ", brand=" + brandEntity +
                '}';
    }
}
