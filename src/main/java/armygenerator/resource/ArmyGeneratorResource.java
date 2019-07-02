package armygenerator.resource;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import armygenerator.service.ArmyGeneratorService;
import armygenerator.util.TroopDTOJson;

@RestController
public class ArmyGeneratorResource {

	private ArmyGeneratorService armyGeneratorService;

	public ArmyGeneratorResource(ArmyGeneratorService armyGeneratorService) {
		Assert.notNull(armyGeneratorService, "armyGeneratorService is null");

		this.armyGeneratorService = armyGeneratorService;
	}

	@RequestMapping("/generate")
	public Response generateTroops(@RequestParam(value="numberOfTroops") Integer numberOfTroops) {
		try {
			return buildResponse(armyGeneratorService.createTroops(numberOfTroops));
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Something went wrong.").build();
		}
	}

	private Response buildResponse(TroopDTOJson createdTroops) {
		return Response.ok(createdTroops, MediaType.APPLICATION_JSON).build();
	}

}
