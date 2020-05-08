package grupparbete.spring.springGA.persistance;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChipsRepository extends JpaRepository<ChipsEntity,Long> {
   // void addChips(ChipsEntity chipsEntity);
}
