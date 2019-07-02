package armygenerator.integration;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import armygenerator.application.ArmyGeneratorApplication;
import armygenerator.resource.ArmyGeneratorResource;
import armygenerator.service.ArmyGeneratorService;
import armygenerator.util.TroopDTOJson;

@SuppressWarnings("rawtypes")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArmyGeneratorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArmyGeneratorIntegrationTest {

	@Autowired
	private ArmyGeneratorResource resource;

	@MockBean
	private static ArmyGeneratorService service;

	@Test
	public void test_ArmyGeneratorServiceResource_integration() {
		TroopDTOJson troopsToCheckAgainst = createTroopDTO();
		Mockito.when(service.createTroops(Mockito.anyInt())).thenReturn(troopsToCheckAgainst);
		
		ResponseEntity generatedTroops = resource.generateTroops(10);
		TroopDTOJson body = ((TroopDTOJson)generatedTroops.getBody());
		
		Assertions.assertThat(body).isEqualTo(troopsToCheckAgainst);
	}

	private TroopDTOJson createTroopDTO() {
		TroopDTOJson result = new TroopDTOJson();
		result.setNumberOfArchers(1);
		result.setNumberOfSpearmen(1);
		result.setNumberOfSwordsmen(1);
		return result;
	}

}
