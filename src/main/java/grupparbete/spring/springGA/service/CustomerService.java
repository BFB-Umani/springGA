package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.ChipsEntity;
import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.Domain.PurchaseEntity;
import grupparbete.spring.springGA.persistance.ChipsRepository;
import grupparbete.spring.springGA.persistance.CustomerRepository;
import grupparbete.spring.springGA.request.UserDetailsRequestModel;
import grupparbete.spring.springGA.request.UserLoginRequestModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerEntity currentCustomerEntity;




    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }


    public CustomerEntity getCustomerById(long id) {
        return customerRepository.findById(id);
    }

    public String createUser(UserDetailsRequestModel user) {

        if (customerRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Record already exists");
        }

        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(user, customerEntity);

        customerRepository.save(customerEntity);


        return "User created";
    }

    public String loadUserByEmail(UserLoginRequestModel userLoginRequestModel) { //changed from loadUserByUserName
        String result = "fail";
        try {
            CustomerEntity customerEntity = customerRepository.findByEmail(userLoginRequestModel.getEmail());
            if (customerEntity.getPassword().equals(userLoginRequestModel.getPassword())) {
                setCurrentCustomerEntity(customerEntity);
                result = "success";
            }
        } catch (NullPointerException e) {
            result = "fail";
        }

        return result;
    }

    public CustomerEntity getCurrentCustomerEntity() {
        return currentCustomerEntity;
    }

    public void setCurrentCustomerEntity(CustomerEntity currentCustomerEntity) {
        this.currentCustomerEntity = currentCustomerEntity;
    }

    public void save(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }

    public boolean isCustomerLoggedIn() {
        boolean loggedin = false;
        if (getCurrentCustomerEntity() != null) {
            loggedin = true;
        }
        return loggedin;
    }

    public long getTotalPrice(){
        List<PurchaseEntity> purchaseList = customerRepository.findByEmail(currentCustomerEntity.getEmail()).getPurchaseList();
        long sum = 0;
        for(PurchaseEntity purchaseEntity :purchaseList ){
           sum += purchaseEntity.getPurchasePrice();
        }
        return sum;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public long calculateSpentSumForACustomer(){
        long totalSpentSumForACustomer = currentCustomerEntity.getTotalAmountSpent() + getTotalPrice();
        currentCustomerEntity.setTotalAmountSpent(totalSpentSumForACustomer);
        return totalSpentSumForACustomer;
    }

    public boolean upgradeCustomerToPremium(){
        if(calculateSpentSumForACustomer()>=500000 && !currentCustomerEntity.isPremiumCustomer()){
            currentCustomerEntity.setPremiumCustomer(true);
            customerRepository.save(currentCustomerEntity);
            return true;
        }
        return false;
    }


}
