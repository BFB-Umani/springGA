package grupparbete.spring.springGA.persistance;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.Domain.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {

    List<PurchaseEntity> findByCustomerEntityId(Long customerEntityId);

    PurchaseEntity findPurchaseById(long id);
}
