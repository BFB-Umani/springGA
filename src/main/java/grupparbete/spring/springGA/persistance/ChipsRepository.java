package grupparbete.spring.springGA.persistance;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChipsRepository extends JpaRepository<ChipsEntity,Long> {
   // void addChips(ChipsEntity chipsEntity);

    List<ChipsEntity> findByBrandContainingIgnoreCase(String brand);
    List<ChipsEntity> findByNameContainingIgnoreCase(String name);

}
