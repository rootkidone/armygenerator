package armygenerator.service;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

import armygenerator.util.TroopDTOJson;

public class ArmyGeneratorServiceTest {
	private static final int NUMBER_OF_TROOPS_MINUS = -1;
	private static final int NUMBER_OF_TROOPS_ZERO = 0;
	private static final int NUMBER_OF_TROOPS_10 = 10;
	private static final int NUMBER_OF_TROOPS_100 = 100;
	private static final int NUMBER_OF_TROOPS_1000 = 1000;
	private static final int NUMBER_OF_TROOPS_10000 = 10000;
	private static ArmyGeneratorService service;

	@BeforeClass
	public static void setup() {
		service = new ArmyGeneratorService();
	}

	@Test
	public void test_create_troops() {
		int numberOfTroops = calculateNumberOfTroops(service.createTroops(NUMBER_OF_TROOPS_10));
		Assertions.assertThat(numberOfTroops).isEqualTo(NUMBER_OF_TROOPS_10);
		
		int numberOfTroops100 = calculateNumberOfTroops(service.createTroops(NUMBER_OF_TROOPS_100));
		Assertions.assertThat(numberOfTroops100).isEqualTo(NUMBER_OF_TROOPS_100);
		
		int numberOfTroops1000= calculateNumberOfTroops(service.createTroops(NUMBER_OF_TROOPS_1000));
		Assertions.assertThat(numberOfTroops1000).isEqualTo(NUMBER_OF_TROOPS_1000);
		
		int numberOfTroops10000 = calculateNumberOfTroops(service.createTroops(NUMBER_OF_TROOPS_10000));
		Assertions.assertThat(numberOfTroops10000).isEqualTo(NUMBER_OF_TROOPS_10000);
		
		int numberOfTroopsZero = calculateNumberOfTroops(service.createTroops(NUMBER_OF_TROOPS_ZERO));
		Assertions.assertThat(numberOfTroopsZero).isEqualTo(NUMBER_OF_TROOPS_ZERO);
		
		/*returns zero due to for() not triggering*/
		int numberOfTroopsMinus = calculateNumberOfTroops(service.createTroops(NUMBER_OF_TROOPS_MINUS));
		Assertions.assertThat(numberOfTroopsMinus).isEqualTo(NUMBER_OF_TROOPS_ZERO);
	}

	private int calculateNumberOfTroops(TroopDTOJson createTroops) {
		return createTroops.getNumberOfArchers() + createTroops.getNumberOfSpearmen()
				+ createTroops.getNumberOfSwordsmen();
	}

}
