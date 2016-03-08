package model;

public class Perk {
	
	private final String perkLabel;
	private final String perkDescription;
	private final int maxLevel;
	private final int[] skillLevels;
	
	private int levelsTaken;
	
	public Perk(String perkLabel, String perkDescription, int maxLevel, int[] skillLevels) {
		this.perkLabel = perkLabel;
		this.perkDescription = perkDescription;
		this.maxLevel = maxLevel;
		this.skillLevels = skillLevels;
		this.levelsTaken = 0;
	}
	
	public boolean takeLevel(int skillLevel) {
		if((levelsTaken < maxLevel) && (skillLevel >= skillLevels[levelsTaken])) {
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
	
	public String getPerkLabel() {
		return perkLabel;
	}
	
	public String getPerkDescription() {
		return perkDescription;
	}
	
	public int getLevelsTaken() {
		return levelsTaken;
	}
	
	public int getMaxLevel() {
		return maxLevel;
	}
	
	public int[] getSkillLevels() {
		return skillLevels;
	}
	
	@Override
	public String toString() {
		String str = "Perk "+perkLabel+":\n"
				+ "- levels "+levelsTaken+"/"+maxLevel+"\n"
						+ "- description:\n"
						+ perkDescription;
		
		return str;
	}
}
