package model;

import enumerators.PerkEnum;

public class Perk {
	
	private PerkEnum perkInstance;
	private int levelsTaken;
	
	public Perk(PerkEnum perkInstance) {
		this.perkInstance = perkInstance;
		this.levelsTaken = 0;
	}
	
	public boolean takeLevel(int skillLevel) {
		if((levelsTaken < perkInstance.getMaxLevel()) && (skillLevel >= perkInstance.getSkillLevels()[levelsTaken])) {
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
	
	public PerkEnum getPerkInstance() {
		return perkInstance;
	}
	
	public int getLevelsTaken() {
		return levelsTaken;
	}
	
	@Override
	public String toString() {
		String str = "Perk "+perkInstance.getLabel()+":\n"
				+ "- levels "+levelsTaken+"/"+perkInstance.getMaxLevel()+"\n"
						+ "- description:\n"
						+ perkInstance.getDescription();
		
		return str;
	}
}
