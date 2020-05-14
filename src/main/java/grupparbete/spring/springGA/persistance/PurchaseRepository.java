package grupparbete.spring.springGA.persistance;

import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.Domain.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {

    List<PurchaseEntity> findByCustomerEntity_Id(Long customerEntity_id);
}
