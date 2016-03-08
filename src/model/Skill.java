package model;

import java.util.List;

public class Skill {
	
	private final String skillLabel;
	private final String skillDescription;
	private final int minLevel;
	private final int maxLevel;
	private final List<Perk> perks;
	
	private int startingLevel;
	private int currentLevel;
	
	public Skill(String skillLabel, String skillDescription, int minLevel, int maxLevel, List<Perk> perks) {
		this.skillLabel = skillLabel;
		this.skillDescription = skillDescription;
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		this.perks = perks;
		
		this.startingLevel = minLevel;
		this.currentLevel = minLevel;
	}
	
	public void setStartingLevel(int level) throws Exception {
		if((level >= minLevel) && (level <= maxLevel)) {
			startingLevel = level;
		}
		else {
			throw new Exception("Starting level of the skill must in the interval between minimum and maximum level!\n"
					+ "Skill: "+skillLabel+".\n"
					+ "Your value: "+level+".\n"
					+ "Minimum level: "+minLevel+"."
					+ "Maximum level: "+maxLevel+".");
		}
	}
	
	public boolean takeLevel() {
		if(currentLevel < maxLevel) {
			currentLevel++; 
			return true;
		}
		else return false;
	}
	
	public boolean removeLevel() {
		if(currentLevel > startingLevel) {
			for(Perk p : perks) {
				int levelIndex = p.getLevelsTaken();
				if(levelIndex > 0) {
					if(p.getSkillLevels()[levelIndex-1] >= currentLevel) {
						return false;
					}
				}
			}
			
			currentLevel--;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void resetSkill() {
		for(Perk p : perks) {
			p.zeroLevel();
		}
		currentLevel = startingLevel;
	}
	
	public String getSkillLabel() {
		return skillLabel;
	}
	
	public String getSkillDescription() {
		return skillDescription;
	}
	
	public int getMinLevel() {
		return minLevel;
	}
	
	public int getMaxLevel() {
		return maxLevel;
	}
	
	public List<Perk> getPerks() {
		return perks;
	}
	
	public int getStartingLevel() {
		return startingLevel;
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public int getTakenPerkCount() {
		int count = 0;
		
		for(Perk p : perks) {
			count += p.getLevelsTaken();
		}
		
		return count;
	}

}
