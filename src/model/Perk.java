package model;

import java.io.Serializable;

public class Perk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String label;
	private final int maxLevel;
	private final int[] skillLevels;
	private final int[] reqPerks;
	
	private int levelsTaken;
	
	public Perk(String label, int maxLevel, int[] skillLevels, int[] reqPerks) {
		this.label = label;
		this.maxLevel = maxLevel;
		this.skillLevels = skillLevels;
		this.reqPerks = reqPerks;
		
		this.levelsTaken = 0;
	}
	
	public boolean takeLevel() {
		if(levelsTaken < maxLevel) {
			levelsTaken++;
			return true;
		}
		else return false;
	}
	
	public boolean removeLevel() {
		if(levelsTaken > 0) {
			levelsTaken--;
			return true;
		}
		else return false;
	}
	
	public void zeroLevel() {
		levelsTaken = 0;
	}
	
	public String getLabel() {
		return label;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public int[] getSkillLevels() {
		return skillLevels;
	}

	public int[] getReqPerks() {
		return reqPerks;
	}

	public int getLevelsTaken() {
		return levelsTaken;
	}
}
