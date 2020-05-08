package grupparbete.spring.springGA.Domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name = "admins")
public class AdminEntity extends UserEntity implements Serializable {
    public AdminEntity() {
    }

    public AdminEntity(String userName, String password) {
        super(userName, password);
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
