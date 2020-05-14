package grupparbete.spring.springGA.persistance;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByEmail(String email);
    CustomerEntity findById(long id);
    // public List<CustomerEntity> findAllByOrderByLastNameDesc(); //LastName A-Z order
}
