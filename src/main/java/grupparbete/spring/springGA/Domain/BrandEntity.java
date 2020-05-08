package grupparbete.spring.springGA.Domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "brands")
public class BrandEntity implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    private String brandName;

    @OneToMany(fetch = FetchType.EAGER, cascade = PERSIST, mappedBy = "brandEntity")
    private List<ChipsEntity> chipsList = new ArrayList<>();

    public BrandEntity(String brandName) {
        this.brandName = brandName;
    }



}
