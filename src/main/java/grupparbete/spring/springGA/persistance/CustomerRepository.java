package grupparbete.spring.springGA.persistance;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

    CustomerEntity findByEmail(String email);
}
