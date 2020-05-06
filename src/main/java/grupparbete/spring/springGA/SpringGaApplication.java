package grupparbete.spring.springGA;

import grupparbete.spring.springGA.persistance.UserEntity;
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
			userRepository.save(new UserEntity("Kening", "Fohlin"));
			userRepository.save(new UserEntity("Hanna","Fohlin"));
			userRepository.save(new UserEntity("Andre","Fohlin"));
			userRepository.save(new UserEntity("ABC","Fohlin"));
			userRepository.save(new UserEntity("EFG","Fohlin"));
		});
	}
}