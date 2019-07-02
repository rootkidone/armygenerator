package armygenerator.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import armygenerator.service.ArmyGeneratorService;
import armygenerator.util.TroopDTOJson;

@SuppressWarnings("rawtypes")
@RestController
public class ArmyGeneratorResource {

	@Autowired
	private ArmyGeneratorService armyGeneratorService;

	public ArmyGeneratorResource(ArmyGeneratorService armyGeneratorService) {
		Assert.notNull(armyGeneratorService, "armyGeneratorService is null");

		this.armyGeneratorService = armyGeneratorService;
	}

	@GetMapping(value = "/generate", produces = "application/json")
	public ResponseEntity generateTroops(@RequestParam Integer numberOfTroops) {
		try {
			return buildJsonResponse(armyGeneratorService.createTroops(numberOfTroops));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.TEXT_PLAIN).body(e);
		}
	}

	@GetMapping("/ping")
	public ResponseEntity ping() {
		return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("pong");
	}

	private ResponseEntity buildJsonResponse(TroopDTOJson createdTroops) {
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(createdTroops);
	}

}
