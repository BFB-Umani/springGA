package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.BrandEntity;
import grupparbete.spring.springGA.persistance.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }
    public List<BrandEntity> getAllBrands(){
        return brandRepository.findAll();
    }
}
