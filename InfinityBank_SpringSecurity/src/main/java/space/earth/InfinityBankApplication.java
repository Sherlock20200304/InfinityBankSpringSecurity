package space.earth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("space.earth")
// @EnableAutoConfiguration
public class InfinityBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfinityBankApplication.class, args);
	}
	
	

		


}
