package model;

import java.io.Serializable;

import staticData.BuildConstants;
import staticData.SkillEnum;

/**
 * Instances of this class represent individual skill of the character.
 * As a part of the data model, these instances are serialized with other model class instances.
 * @author Vlada47
 *
 */
public class Skill implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Enumerator identifying this skill (and holding static data about the skill).
	 */
	private final SkillEnum skillInstance;
	
	/**
	 * An array with skill's perks - instances of the {@code Perk} class.
	 */
	private Perk[] perks;
	
	/**
	 * Starting level of the skill, which is set after initial creation. It varies for different character races.
	 */
	private int startingLevel;
	
	/**
	 * Current level of the skill.
	 */
	private int currentLevel;
	
	/**
	 * Constructor of the {@code Skill} class. It sets passed {@code skillInstance} enumerator value
	 * and starting and current level to global minimum.  
	 * @param skillInstance
	 */
	public Skill(SkillEnum skillInstance) {
		this.skillInstance = skillInstance;
		
		this.startingLevel = BuildConstants.MIN_SKILL_LEVEL;
		this.currentLevel = BuildConstants.MIN_SKILL_LEVEL;
	}
	
	/**
	 * Method for increase the skill level by 1. It returns {@code true}, when skill level has not reached global maximum level yet.
	 * It returns {@code false} otherwise (no level increase in that case). 
	 * @return	true/false
	 */
	public boolean takeLevel() {
		if(currentLevel < BuildConstants.MAX_SKILL_LEVEL) {
			currentLevel++; 
			return true;
		}
		else return false;
	}
	
	/**
	 * Method for decrease the skill level by 1. It returns {@code true}, when skill level is greater than the starting level
	 * and all currently taken skill's perks has lower skill level requirement.
	 * It returns {@code false} otherwise (no level increase in that case). 
	 * @return	true/false
	 */
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
	
	/**
	 * Method for setting all skill's perk's level to 0 and the skill level to startin level.  
	 */
	public void resetSkill() {
		for(Perk p : perks) {
			p.zeroLevel();
		}
		currentLevel = startingLevel;
	}
	
	/**
	 * Getter for the actual skill instance.
	 * @return	{@code SkillEnum} value
	 */
	public SkillEnum getSkillInstance() {
		return skillInstance;
	}
	
	/**
	 * Setter for the array with perks.
	 * @param perks	an array with {@code Perk} instances
	 */
	public void setPerks(Perk[] perks) {
		this.perks = perks;
	}
	
	/**
	 * Getter for the array with perks.
	 * @return	an array with {@code Perk} instances
	 */
	public Perk[] getPerks() {
		return perks; 
	}
	
	/**
	 * Setter for the starting level. It sets both starting level and current level to passed value.
	 * @param level	starting level of the skill
	 */
	public void setStartingLevel(int level) {
		startingLevel = level;
		currentLevel = level;
	}
	
	/**
	 * Getter for the starting level.
	 * @return	starting level of the skill
	 */
	public int getStartingLevel() {
		return startingLevel;
	}
	
	/**
	 * Getter for the current level.
	 * @return	current level of the skill
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	/**
	 * Getter for the number of perk points invested to all possible perks of this skill.
	 * @return	number of perk points invested to perks of this skill
	 */
	public int getTakenPerkCount() {
		int count = 0;
		
		for(Perk p : perks) {
			count += p.getLevelsTaken();
		}
		
		return count;
	}
}
