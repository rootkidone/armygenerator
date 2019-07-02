package armygenerator.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TroopDTOJson {
	
	@JsonProperty("archers")
	private Integer numberOfArchers;
	@JsonProperty("spearmen")
	private Integer numberOfSpearmen;
	@JsonProperty("swordsmen")
	private Integer numberOfSwordsmen;

	public TroopDTOJson() {
		this.numberOfArchers = 0;
		this.numberOfSpearmen = 0;
		this.numberOfSwordsmen = 0;
	}

	public Integer getNumberOfArchers() {
		return numberOfArchers;
	}

	public void setNumberOfArchers(Integer numberOfArchers) {
		this.numberOfArchers = numberOfArchers;
	}

	public Integer getNumberOfSpearmen() {
		return numberOfSpearmen;
	}

	public void setNumberOfSpearmen(Integer numberOfSpearmen) {
		this.numberOfSpearmen = numberOfSpearmen;
	}

	public Integer getNumberOfSwordsmen() {
		return numberOfSwordsmen;
	}

	public void setNumberOfSwordsmen(Integer numberOfSwordsmen) {
		this.numberOfSwordsmen = numberOfSwordsmen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberOfArchers == null) ? 0 : numberOfArchers.hashCode());
		result = prime * result + ((numberOfSpearmen == null) ? 0 : numberOfSpearmen.hashCode());
		result = prime * result + ((numberOfSwordsmen == null) ? 0 : numberOfSwordsmen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TroopDTOJson other = (TroopDTOJson) obj;
		if (numberOfArchers == null) {
			if (other.numberOfArchers != null)
				return false;
		} else if (!numberOfArchers.equals(other.numberOfArchers))
			return false;
		if (numberOfSpearmen == null) {
			if (other.numberOfSpearmen != null)
				return false;
		} else if (!numberOfSpearmen.equals(other.numberOfSpearmen))
			return false;
		if (numberOfSwordsmen == null) {
			if (other.numberOfSwordsmen != null)
				return false;
		} else if (!numberOfSwordsmen.equals(other.numberOfSwordsmen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TroopDTOJson [numberOfArchers=" + numberOfArchers + ", numberOfSpearmen=" + numberOfSpearmen
				+ ", numberOfSwordsmen=" + numberOfSwordsmen + "]";
	}

}
