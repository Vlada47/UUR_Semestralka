package model;

import java.util.ArrayList;
import java.util.List;

import controller.BuildConstants;
import enumerators.SkillEnum;

public class Skill {
	
	private final SkillEnum skillInstance;
	private final List<Perk> perks;
	private int startingLevel;
	private int currentLevel;
	
	public Skill(SkillEnum skillInstance) {
		this.skillInstance = skillInstance;
		this.perks = new ArrayList<Perk>();
		
		this.startingLevel = BuildConstants.MIN_SKILL_LEVEL;
		this.currentLevel = BuildConstants.MIN_SKILL_LEVEL;
	}
	
	public void setStartingLevel(int level) throws Exception {
		if((level >= BuildConstants.MIN_SKILL_LEVEL) && (level <= BuildConstants.MAX_SKILL_LEVEL)) {
			startingLevel = level;
		}
		else {
			throw new Exception("Starting level of the skill must in the interval between minimum and maximum level!\n"
					+ "Skill: "+skillInstance.getLabel()+".\n"
					+ "Your value: "+level+".\n"
					+ "Minimum level: "+BuildConstants.MIN_SKILL_LEVEL+"."
					+ "Maximum level: "+BuildConstants.MAX_SKILL_LEVEL+".");
		}
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
					if(p.getPerkInstance().getSkillLevels()[levelIndex-1] >= currentLevel) {
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
