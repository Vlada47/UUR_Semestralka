package model;

import java.io.Serializable;

/**
 * Instances of this class represent individual perks falling under certain skill.
 * As a part of the data model, these instances are serialized with other model class instances.
 * @author Vlada47
 *
 */
public class Perk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Name of the perk.
	 */
	private final String label;
	
	/**
	 * Maximum number of perk points, which can be invested into this perk.
	 */
	private final int maxLevel;
	
	/**
	 * Level requirement of respective skill level for being able to invest the perk point on specific perk level.
	 */
	private final int[] skillLevels;
	
	/**
	 * Indexes of perks in context of the respective skill, which are predecessors of this perk.
	 */
	private final int[] reqPerks;
	
	/**
	 * Current number of perk points invested into this perk.
	 */
	private int levelsTaken;
	
	/**
	 * Constructor of the {@code Perk} class. It sets passed values and {@code levelsTaken} variable to 0.
	 * @param label			perk's name
	 * @param maxLevel		maximum level of the perk
	 * @param skillLevels	skill level requirement for each level
	 * @param reqPerks		IDs of predecessor perks
	 */
	public Perk(String label, int maxLevel, int[] skillLevels, int[] reqPerks) {
		this.label = label;
		this.maxLevel = maxLevel;
		this.skillLevels = skillLevels;
		this.reqPerks = reqPerks;
		
		this.levelsTaken = 0;
	}
	
	/**
	 * Method for increase the perk level by 1. It returns {@code true}, when number of perk points already invested
	 * is lesser than maximum perk level. It returns {@code false} otherwise (no level increase in that case). 
	 * @return	true/false
	 */
	public boolean takeLevel() {
		if(levelsTaken < maxLevel) {
			levelsTaken++;
			return true;
		}
		else return false;
	}
	
	/**
	 * Method for decreasing the perk level by 1. It returns {@code true}, when the number of perk points invested
	 * if at least 1. It returns {@code false} otherwise (no level decrease in that case).
	 * @return	true/false
	 */
	public boolean removeLevel() {
		if(levelsTaken > 0) {
			levelsTaken--;
			return true;
		}
		else return false;
	}
	
	/**
	 * Sets level of the perk to 0.
	 */
	public void zeroLevel() {
		levelsTaken = 0;
	}
	
	/**
	 * Getter for the perk's name.
	 * @return	perk's name
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Getter for perk's maximum level.
	 * @return	maximum level of the perk
	 */
	public int getMaxLevel() {
		return maxLevel;
	}
	
	/**
	 * Getter for the array with required skill levels.
	 * @return	an array with required skill levels
	 */
	public int[] getSkillLevels() {
		return skillLevels;
	}
	
	/**
	 * Getter for the array with indexes of predecessor perks.
	 * @return	an array with perk indexes
	 */
	public int[] getReqPerks() {
		return reqPerks;
	}
	
	/**
	 * Getter for the number of perk points invested.
	 * @return	perk points already invested
	 */
	public int getLevelsTaken() {
		return levelsTaken;
	}
}
