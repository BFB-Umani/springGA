package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.AdminEntity;
import grupparbete.spring.springGA.persistance.AdminRepository;
import grupparbete.spring.springGA.request.UserLoginRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository adminRepository;
    private AdminEntity currentAdminEntity;

    @Autowired
    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public String loadUserByEmail(UserLoginRequestModel userLoginRequestModel) {
        String result="fail";
        try{
            AdminEntity adminEntity = adminRepository.findByEmail(userLoginRequestModel.getEmail());
            if (adminEntity.getPassword().equals(userLoginRequestModel.getPassword())){
                setCurrentAdminEntity(adminEntity);
                result = "success";
            }
        } catch (NullPointerException e) {
            result = "fail";
        }
return result;
    }

    public void setCurrentAdminEntity(AdminEntity adminEntity){
        this.currentAdminEntity =adminEntity;
    }

    public AdminEntity getCurrentAdminEntity() {
        return currentAdminEntity;
    }

    public boolean isAdminLoggedIn() {
        boolean loggedin = false;
        if (getCurrentAdminEntity() != null) {
            loggedin = true;
        }
        return loggedin;
    }
}
