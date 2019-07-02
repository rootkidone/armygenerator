package armygenerator.service;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

import org.springframework.stereotype.Component;

import armygenerator.troops.TroopEnum;
import armygenerator.util.TroopDTOJson;
import armygenerator.util.TroopManagerObject;

@Component
public class ArmyGeneratorService {
	
	private final Integer numberOfAllTroopVariations = TroopEnum.values().length;

	public TroopDTOJson createTroops(Integer numberOfTroops) {
		/*No boundary test necessary. Has been tested in resource*/
		TroopManagerObject manager = new TroopManagerObject();
		Random dice = new Random();
		for(int i = 0; i < numberOfTroops; i++) {
			TroopEnum generatedTroop = generateTroop(dice.nextInt(numberOfAllTroopVariations));
			if(generatedTroop != null) {
				manager.add(generateTroop(dice.nextInt(numberOfAllTroopVariations)));
			} else {
				throw new IllegalArgumentException("Troops could not be generated.");
			}
		}
		return buildDTO(manager);
	}

	private TroopDTOJson buildDTO(TroopManagerObject manager) {
		TroopDTOJson result = new TroopDTOJson();
		
		Iterator<Entry<TroopEnum, Integer>> iterator = manager.getTroopManagementMap().entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<TroopEnum, Integer> currentEntry = iterator.next();
			if(currentEntry.getKey().equals(TroopEnum.ARCHER)) {				
				result.setNumberOfArchers(currentEntry.getValue());
			}
			if(currentEntry.getKey().equals(TroopEnum.SWORDMAN)) {				
				result.setNumberOfSwordsmen(currentEntry.getValue());
			}
			if(currentEntry.getKey().equals(TroopEnum.SPEARMAN)) {				
				result.setNumberOfSpearmen(currentEntry.getValue());
			}
		}
		return result;
	}

	private TroopEnum generateTroop(Integer troopNumber) {
		switch (troopNumber) {
		case 0:
			return TroopEnum.ARCHER;
		case 1:
			return TroopEnum.SPEARMAN;
		case 2:
			return TroopEnum.SWORDMAN;
		default:
			return null;
		}
	}

}
