package armygenerator.util;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

import armygenerator.troops.TroopEnum;

public class TroopManagerTest {

	private static TroopManagerObject manager;

	@BeforeClass
	public static void setup() {
		manager = new TroopManagerObject();
	}

	@Test
	public void test_add_troop_archers() {
		int numberOfArchers = 5;
		for (int i = 0; i < numberOfArchers; i++) {
			manager.add(TroopEnum.ARCHER);
		}
		Integer archers = manager.getTroopManagementMap().get(TroopEnum.ARCHER);
		Assertions.assertThat(archers).isEqualTo(numberOfArchers);
	}

	@Test
	public void test_add_troop_spearmen() {
		int numberOfSpearman = 5;
		for (int i = 0; i < numberOfSpearman; i++) {
			manager.add(TroopEnum.SPEARMAN);
		}
		Integer spearmen = manager.getTroopManagementMap().get(TroopEnum.SPEARMAN);
		Assertions.assertThat(spearmen).isEqualTo(numberOfSpearman);
	}

	@Test
	public void test_add_troop_swordsman() {
		int numberOfSwordmen = 5;
		for (int i = 0; i < numberOfSwordmen; i++) {
			manager.add(TroopEnum.SWORDMAN);
		}
		Integer swordsmen = manager.getTroopManagementMap().get(TroopEnum.SWORDMAN);
		Assertions.assertThat(swordsmen).isEqualTo(numberOfSwordmen);
	}
}
