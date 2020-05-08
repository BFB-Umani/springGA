package grupparbete.spring.springGA.Domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "users")
public abstract class UserEntity implements Serializable { // abstract!

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private final String userName;

    @Column(nullable = false, length = 50)
    private final String password;

    public UserEntity() {
        userName = null;
        password = null;
    }

    /*public abstract boolean isAdmin();

    public abstract boolean isCustomer();*/
}
