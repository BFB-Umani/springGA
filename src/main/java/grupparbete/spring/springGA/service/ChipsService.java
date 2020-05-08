package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.persistance.ChipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ChipsService {

    private ChipsRepository chipsRepository;

    @Autowired
    public ChipsService(ChipsRepository chipsRepository){
        this.chipsRepository = chipsRepository;
    }

    public List<ChipsEntity> getAllChips(){
        return chipsRepository.findAll();
    }

    public Optional<ChipsEntity> getAChips(long id){
        return chipsRepository.findById(id);
    }

    public void addChips(ChipsEntity chipsEntity) {
        chipsRepository.save(chipsEntity);
    }

//    public List<Chips> search(String searchString) {
//        TypedQuery<Chips> q = em.createQuery("select c from Chips c inner join Brand as b on b.id = c.brand.id " +
//                "where lower(b.brandName) like :name or lower(c.name) like :name", Chips.class);
//        q.setParameter("name", "%" + toLower(searchString) + "%");
//        return q.getResultList();
//    }



}
