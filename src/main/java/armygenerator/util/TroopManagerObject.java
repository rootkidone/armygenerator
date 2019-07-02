package armygenerator.util;

import java.util.HashMap;
import java.util.Map;

import armygenerator.troops.TroopEnum;

public class TroopManagerObject {
	
	private final Map<TroopEnum, Integer> troopManagementMap;

	public TroopManagerObject() {
		this.troopManagementMap = new HashMap<>();
		buildMap(troopManagementMap);
	}

	private void buildMap(Map<TroopEnum, Integer> troopManagementMap) {
		troopManagementMap.put(TroopEnum.SPEARMAN, 0);
		troopManagementMap.put(TroopEnum.SWORDMAN, 0);
		troopManagementMap.put(TroopEnum.ARCHER, 0);
	}
	
	public void add(TroopEnum troopToAdd) {
		if(troopToAdd != null) {
			if(troopToAdd.equals(TroopEnum.ARCHER)) {
				addArcher();
			}
			if(troopToAdd.equals(TroopEnum.SWORDMAN)) {
				addSwordman();
			}
			if(troopToAdd.equals(TroopEnum.SPEARMAN)) {
				addSpearman();
			}
		}
	}

	public Map<TroopEnum, Integer> getTroopManagementMap() {
		return troopManagementMap;
	}
	
	private void addSpearman() {
		troopManagementMap.put(TroopEnum.SPEARMAN, troopManagementMap.get(TroopEnum.SPEARMAN) + 1);
	}
	
	private void addSwordman() {
		troopManagementMap.put(TroopEnum.SWORDMAN, troopManagementMap.get(TroopEnum.SWORDMAN) + 1);
	}
	
	private void addArcher() {
		troopManagementMap.put(TroopEnum.ARCHER, troopManagementMap.get(TroopEnum.ARCHER) + 1);
	}
	
	

}
