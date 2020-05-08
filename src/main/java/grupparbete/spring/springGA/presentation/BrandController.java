package grupparbete.spring.springGA.presentation;

import grupparbete.spring.springGA.Domain.BrandEntity;
import grupparbete.spring.springGA.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("brands")
public class BrandController {

    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    public List<BrandEntity> getBrands(){
       return brandService.getAllBrands();
    }
}
