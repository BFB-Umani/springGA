package grupparbete.spring.springGA;


import grupparbete.spring.springGA.Domain.CustomerEntity;
import grupparbete.spring.springGA.persistance.CustomerRepository;
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
	public CommandLineRunner setUp(CustomerRepository customerRepository){
		return (args -> {
			customerRepository.save(new CustomerEntity("testpassword1","test1","lastname1","street1","city1","country1","email1@test.se","zipcode1"));
			customerRepository.save(new CustomerEntity("testpassword2","test2","lastname2","street2","city2","country2","email2@test.se","zipcode2"));
			customerRepository.save(new CustomerEntity("testpassword3","test3","lastname3","street3","city3","country3","email3@test.se","zipcode3"));
			customerRepository.save(new CustomerEntity("testpassword4","test4","lastname4","street4","city4","country4","email4@test.se","zipcode4"));
			customerRepository.save(new CustomerEntity("testpassword5","test5","lastname5","street5","city5","country5","email5@test.se","zipcode5"));
		});
	}
}