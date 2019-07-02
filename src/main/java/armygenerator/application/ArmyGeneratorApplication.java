package armygenerator.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = "armygenerator")
@EnableWebMvc
public class ArmyGeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArmyGeneratorApplication.class, args);
	}
}
