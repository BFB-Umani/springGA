package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.persistance.CustomerRepository;
import grupparbete.spring.springGA.request.UserDetailsRequestModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Optional<CustomerEntity> getACustomer(long id){
        return customerRepository.findById(id);
    }

    public String createUser(UserDetailsRequestModel user) {

        if (customerRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Record already exists");
        }

        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(user, customerEntity);

        CustomerEntity storedUserDetails = customerRepository.save(customerEntity);


        return "User created";
    }
}
