package grupparbete.spring.springGA.service;

import grupparbete.spring.springGA.Domain.UserEntity;
import grupparbete.spring.springGA.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUser(Long id) {
        return userRepository.findById(id);
    }
}
