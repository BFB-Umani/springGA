package grupparbete.spring.springGA.Domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity(name = "customers")
@SequenceGenerator(name = "seqCus", initialValue = 10, allocationSize = 1)
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCus")
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseList;

    private String password;
    private String firstName; //inga siffror/konstiga tecken, minst 2 bokstäver max 40
    private String lastName; //inga siffror/konstiga tecken, minst 2 bokstäver max 40
    private String address; // not null max 40 bokstäver
    private String city; // not null max 40
    private String country; // not null
    private String email; //behöver snabelA ("@")
    private String zipCode; //felhantering för input av bokstäver (får enbart innehålla siffror och max 5 tecken)
    private boolean premiumCustomer = false;
    private long totalAmountSpent;

    public CustomerEntity(String password, String firstName, String lastName, String address, String city, String country, String email, String zipCode, boolean premiumCustomer) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.zipCode = zipCode;
        this.premiumCustomer = premiumCustomer;
        this.totalAmountSpent = 0;
    }

    public CustomerEntity() {

    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
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

    public List<PurchaseEntity> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<PurchaseEntity> purchaseList) {
        this.purchaseList = purchaseList;
    }
}
