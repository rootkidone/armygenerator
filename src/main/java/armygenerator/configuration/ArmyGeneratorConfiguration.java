package armygenerator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import armygenerator.resource.ArmyGeneratorResource;
import armygenerator.service.ArmyGeneratorService;

@Configuration
public class ArmyGeneratorConfiguration {
	
	@Bean
	public ArmyGeneratorService armyGeneratorService() {
		return new ArmyGeneratorService();
	}
	
	@Bean
	public ArmyGeneratorResource armyGeneratorResource() {
		return new ArmyGeneratorResource(armyGeneratorService());
	}

}
