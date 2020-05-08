package grupparbete.spring.springGA.persistance;

import grupparbete.spring.springGA.Domain.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {
}
