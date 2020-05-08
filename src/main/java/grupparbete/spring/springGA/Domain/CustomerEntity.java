package grupparbete.spring.springGA.Domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity(name = "customers")
public class CustomerEntity extends UserEntity implements Serializable {

   @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseList;

    private String firstName; //inga siffror/konstiga tecken, minst 2 bokstäver max 40
    private String lastName; //inga siffror/konstiga tecken, minst 2 bokstäver max 40
    private String address; // not null max 40 bokstäver
    private String city; // not null max 40
    private String country; // not null
    private String eMail; //behöver snabelA ("@")
    private String zipCode; //felhantering för input av bokstäver (får enbart innehålla siffror och max 5 tecken)
    private boolean premiumCustomer = false;
    private long totalAmountSpent;

    public CustomerEntity(String password, String firstName, String lastName, String address, String city, String country, String eMail, String zipCode) {
        super(eMail, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.eMail = eMail;
        this.totalAmountSpent = 0;
    }


}
