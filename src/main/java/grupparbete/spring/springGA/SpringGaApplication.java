package grupparbete.spring.springGA;

import grupparbete.spring.springGA.Domain.AdminEntity;
import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.Domain.UserEntity;
import grupparbete.spring.springGA.persistance.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGaApplication.class, args);
	}

	@Bean // get an object from Bean -- EmployeeRepository
	public CommandLineRunner setUp(UserRepository userRepository){
		return (args -> {
			userRepository.save(new AdminEntity("Kening", "Fohlin"));
			userRepository.save(new AdminEntity("Hanna","Fohlin"));
			userRepository.save(new AdminEntity("Andre","Fohlin"));
			userRepository.save(new CustomerEntity("ABC","firstname","lastname","djaogieo","asdfa","dasfa","ddd","heri"));
			userRepository.save(new AdminEntity("EFG","Fohlin"));
		});
	}
}