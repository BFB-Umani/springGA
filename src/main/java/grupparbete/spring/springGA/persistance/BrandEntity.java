package grupparbete.spring.springGA.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@Entity(name = "brands")
public class BrandEntity implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    private String brandName;

    @OneToMany(fetch = FetchType.EAGER, cascade = PERSIST, mappedBy = "brandEntity")
    private List<ChipsEntity> chipsList = new ArrayList<>();

    public BrandEntity() {
    }

    public BrandEntity(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id)); */

    @Override
    public String toString() {
        return brandName;
    }

}
