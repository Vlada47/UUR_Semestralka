package model;

import java.io.Serializable;

import staticData.BuildConstants;
import staticData.SkillEnum;

public class Skill implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private final SkillEnum skillInstance;
	
	private Perk[] perks;
	private int startingLevel;
	private int currentLevel;
	
	public Skill(SkillEnum skillInstance) {
		this.skillInstance = skillInstance;
		
		this.startingLevel = BuildConstants.MIN_SKILL_LEVEL;
		this.currentLevel = BuildConstants.MIN_SKILL_LEVEL;
	}
	
	public boolean takeLevel() {
		if(currentLevel < BuildConstants.MAX_SKILL_LEVEL) {
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
	
	public SkillEnum getSkillInstance() {
		return skillInstance;
	}
	
	public void setPerks(Perk[] perks) {
		this.perks = perks;
	}
	
	public Perk[] getPerks() {
		return perks; 
	}
	
	public void setStartingLevel(int level) {
		startingLevel = level;
		currentLevel = level;
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
