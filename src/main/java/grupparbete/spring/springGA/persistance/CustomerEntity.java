package grupparbete.spring.springGA.persistance;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

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

    public CustomerEntity() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isPremiumCustomer() {
        return premiumCustomer;
    }

    public void setPremiumCustomer(boolean premiumCustomer) {
        this.premiumCustomer = premiumCustomer;
    }

    public long getTotalAmountSpent() {
        return totalAmountSpent;
    }

    public void setTotalAmountSpent(long totalAmountSpent) {
        this.totalAmountSpent = totalAmountSpent;
    }

    /*@Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public boolean isCustomer() {
        return true;
    }
*/
}
