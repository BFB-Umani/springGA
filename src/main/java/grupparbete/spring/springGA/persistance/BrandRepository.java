package grupparbete.spring.springGA.persistance;

import grupparbete.spring.springGA.Domain.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long> {
}
