package grupparbete.spring.springGA.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "admins")
public class AdminEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String password;

    public AdminEntity() {


    }

    public AdminEntity(String userName, String password) {
        this.userName = userName;
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
}
