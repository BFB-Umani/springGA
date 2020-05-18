package grupparbete.spring.springGA.Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "admins")
@SequenceGenerator(name="seqAd", initialValue=4, allocationSize = 1)
public class AdminEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAd")
    private Long id;

    private String email;
    private String password;

    public AdminEntity() {


    }

    public AdminEntity(String userName, String password) {
        this.email = userName;
        this.password = password;
    }

    /*@Override
    public boolean isAdmin() {
        return true;
    }

    @Override
    public boolean isCustomer() {
        return false;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String userName) {
        this.email = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
