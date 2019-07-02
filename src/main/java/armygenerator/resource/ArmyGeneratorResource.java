package armygenerator.resource;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armygenerator.service.ArmyGeneratorService;

@RestController
public class ArmyGeneratorResource {
	
	private ArmyGeneratorService armyGeneratorService;
	
	public ArmyGeneratorResource(ArmyGeneratorService armyGeneratorService) {
		Assert.notNull(armyGeneratorService, "armyGeneratorService is null");


		this.armyGeneratorService = armyGeneratorService;
	}
	
	@RequestMapping("/generate")
	public String generateTroops(Integer numberOfTroops) {
		return armyGeneratorService.createTroops(numberOfTroops);
	}

}
