package model;

import java.io.Serializable;
import java.util.Stack;

import staticData.BirthsignEnum;
import staticData.BuildConstants;
import staticData.GenderEnum;
import staticData.PrimaryAttrEnum;
import staticData.RaceEnum;
import staticData.SecondaryAttrEnum;
import staticData.SpecializationEnum;

/**
 * Instances of this class represents the specific build character. It holds general information about the character
 * and it is serialized along with the the lesser classes ({@code Perk}, {@code Skill} and {@code Attribute}) for saving the build on disk.
 * @author Vlada47
 *
 */
public class CharacterBuild implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Array of {@code Skill} instances, which represent character's individual skills.
	 */
	private final Skill[] skills;
	
	/**
	 * Array of {@code Attribute} instances, which represent individual primary attribute distributions per level.
	 */
	private final Attribute[] attributes;
	
	/**
	 * Stack with health attribute distributions.
	 */
	private final Stack<Attribute> lastHealth;
	
	/**
	 * Stack with magicka attribute distributions.
	 */
	private final Stack<Attribute> lastMagicka;
	
	/**
	 * Stack with stamina attribute distributions.
	 */
	private final Stack<Attribute> lastStamina;
	
	/**
	 * Array with amounts of perk points, which are awarded to character on each level.
	 */
	private final int[] perkCntAtLevelUp;
	
	/**
	 * Array with amounts of primary attribute points, which can be distributed to character on each level.
	 */
	private final int[] attributeGainAtLevelUp;
	
	/**
	 * Race of the character.
	 */
	private RaceEnum race;
	
	/**
	 * Gender of the character.
	 */
	private GenderEnum gender;
	
	/**
	 * Specialization of the character.
	 */
	private SpecializationEnum specialization;
	
	/**
	 * Primary attribute of character's choice.
	 */
	private PrimaryAttrEnum primaryAttribute;
	
	/**
	 * Secondary attribute of character's choice.
	 */
	private SecondaryAttrEnum secondaryAttribute;
	
	/**
	 * Birthsign of the character.
	 */
	private BirthsignEnum birthsign;
	
	/**
	 * Indication of whether the general creation of the build was already done.
	 */
	private boolean buildSet;
	
	/**
	 * Main level of the character.
	 */
	private int currentLevel;
	
	/**
	 * Experience points gained through the leveling skills. 
	 */
	private double currentXP;
	
	/**
	 * Number of perk points available for perk investment.
	 */
	private int perksAvailable;
	
	/**
	 * Health of the character.
	 */
	private int currentHealth;
	
	/**
	 * Magicka of the character.
	 */
	private int currentMagicka;
	
	/**
	 * Stamina of the character.
	 */
	private int currentStamina;
	
	/**
	 * Text of the user's build notes.
	 */
	private String buildNotes;
	
	/**
	 * Constructor of the class. It saves reference to the array with {@code Skill} instances and creates instances of all other arrays and stacks.
	 * It then sets default values to all variables.
	 * @param skills	array with {@code Skill} instances
	 */
	public CharacterBuild(Skill[] skills) {
		this.skills = skills;
		this.attributes = new Attribute[BuildConstants.MAX_CHARACTER_LEVEL];
		this.lastHealth = new Stack<Attribute>();
		this.lastMagicka = new Stack<Attribute>();
		this.lastStamina = new Stack<Attribute>();
		perkCntAtLevelUp = new int[BuildConstants.MAX_CHARACTER_LEVEL];
		attributeGainAtLevelUp = new int[BuildConstants.MAX_CHARACTER_LEVEL];
		
		race = RaceEnum.ALTMER;
		gender = GenderEnum.MALE;
		specialization = SpecializationEnum.COMBAT;
		primaryAttribute = PrimaryAttrEnum.HEALTH;
		secondaryAttribute = SecondaryAttrEnum.STRENGTH;
		birthsign = BirthsignEnum.APPRENTICE;
		
		this.buildSet = false;
		this.currentLevel = 1;
		this.perksAvailable = 0;
		this.currentHealth = BuildConstants.ATTRIBUTE_BASE;
		this.currentMagicka = BuildConstants.ATTRIBUTE_BASE;
		this.currentStamina = BuildConstants.ATTRIBUTE_BASE;
		this.buildNotes = "";
		
		attributes[0] = new Attribute(PrimaryAttrEnum.HEALTH, 0);
	}
	
	/**
	 * Getter for the array with {@code Skill} instances.
	 * @return	array with {@code Skill} instances
	 */
	public Skill[] getSkills() {
		return skills;
	}
	
	/**
	 * Getter for the array with perk points gains per level.
	 * @return	array with perk points gains per level
	 */
	public int[] getPerkCntAtLevelUp() {
		return perkCntAtLevelUp;
	}
	
	/**
	 * Getter for the array with primary attribute point gains per level.
	 * @return	array with primary attribute distributions per level
	 */
	public int[] getAttributeGainAtLevelUp() {
		return attributeGainAtLevelUp;
	}
	
	/**
	 * Method for adding new attribute distribution. It is saved on the first empty index of the array.  
	 * @param attribute
	 */
	public void addAttribute(Attribute attribute) {
		for(int i = 0; i < attributes.length; i++) {
			if(attributes[i] == null) {
				attributes[i] = attribute;
				break;
			}
		}
	}
	
	/**
	 * Getter for the array with primary attribute distribtuions.
	 * @return
	 */
	public Attribute[] getAttributes() {
		return attributes;
	}
	
	/**
	 * Setter for new health {@code Attribute} to the top of its stack.
	 * @param health	health {@code Attribute}
	 */
	public void pushLastHealth(Attribute health) {
		lastHealth.push(health);
	}
	
	/**
	 * Getter for the stack with health {@code Attribute} distributions.
	 * @return	stack with health {@code Attribute} distributions
	 */
	public Stack<Attribute> getLastHealth() {
		return lastHealth;
	}
	
	/**
	 * Setter for new magicka {@code Attribute} to the top of its stack.
	 * @param magicka	magicka {@code Attribute}
	 */
	public void pushLastMagicka(Attribute magicka) {
		lastMagicka.push(magicka);
	}
	
	/**
	 * Getter for the stack with magicka {@code Attribute} distributions.
	 * @return	stack with magicka {@code Attribute} distributions
	 */
	public Stack<Attribute> getLastMagicka() {
		return lastMagicka;
	}
	
	/**
	 * Setter for new stamina {@code Attribute} to the top of its stack.
	 * @param stamina	stamina {@code Attribute}
	 */
	public void pushLastStamina(Attribute stamina) {
		lastStamina.push(stamina);
	}
	
	/**
	 * Getter for the stack with stamina {@code Attribute} distributions.
	 * @return	stack with stamina {@code Attribute} distributions
	 */
	public Stack<Attribute> getLastStamina() {
		return lastStamina;
	}
	
	/**
	 * Getter for the {@code buildSet} variable.
	 * @return	{@code buildSet} variable
	 */
	public boolean isBuildSet() {
		return buildSet;
	}
	
	/**
	 * Setter for the {@code buildSet} variable.
	 * @param buildSet	{@code buildSet} variable
	 */
	public void setBuildSet(boolean buildSet) {
		this.buildSet = buildSet;
	}
	
	/**
	 * Setter for current character level.
	 * @param level	current character level
	 */
	public void setCurrentLevel(int level) {
		currentLevel = level;
	}
	
	/**
	 * Getter for current character level.
	 * @return	current character level
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	/**
	 * Getter for current experience points amount.
	 * @return	current experience points amount
	 */
	public double getCurrentXP() {
		return currentXP;
	}
	
	/**
	 * Setter for current experience points amount.
	 * @param currentXP	current experience points amount
	 */
	public void setCurrentXP(double currentXP) {
		this.currentXP = currentXP;
	}
	
	/**
	 * Setter for the count of perks points available.
	 * @param perks	count of perks points available
	 */
	public void setPerksAvailable(int perks) {
		perksAvailable = perks;
	}
	
	/**
	 * Getter for the count of perks points available.
	 * @return	count of perks points available
	 */
	public int getPerksAvailable() {
		return perksAvailable;
	}
	
	/**
	 * Setter for character health.
	 * @param health	character health
	 */
	public void setCurrentHealth(int health) {
		currentHealth = health;
	}
	
	/**
	 * Getter for character health.
	 * @return	character health
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	/**
	 * Setter for character magicka.
	 * @param magicka	character magicka
	 */
	public void setCurrentMagicka(int magicka){
		currentMagicka = magicka;
	}
	
	/**
	 * Getter for character magicka.
	 * @return	character magicka
	 */
	public int getCurrentMagicka() {
		return currentMagicka;
	}
	
	/**
	 * Setter for character stamina.
	 * @param stamina	character stamina
	 */
	public void setCurrentStamina(int stamina) {
			currentStamina = stamina;
	}
	
	/**
	 * Getter for character stamina.
	 * @return	character stamina
	 */
	public int getCurrentStamina() {
		return currentStamina;
	}
	
	/**
	 * Getter for character race.
	 * @return	character race
	 */
	public RaceEnum getRace() {
		return race;
	}
	
	/**
	 * Setter for character race.
	 * @param race	character race
	 */
	public void setRace(RaceEnum race) {
		this.race = race;
	}
	
	/**
	 * Getter for character gender.
	 * @return	character gender
	 */
	public GenderEnum getGender() {
		return gender;
	}
	
	/**
	 * Setter for character gender.
	 * @param gender	character gender
	 */
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}
	
	/**
	 * Getter for character specialization.
	 * @return	character specialization
	 */
	public SpecializationEnum getSpecialization() {
		return specialization;
	}
	
	/**
	 * Setter for character specialization.
	 * @param specialization	character specialization
	 */
	public void setSpecialization(SpecializationEnum specialization) {
		this.specialization = specialization;
	}
	
	/**
	 * Getter for character primary attribute choice.
	 * @return	primary attribute choice
	 */
	public PrimaryAttrEnum getPrimaryAttribute() {
		return primaryAttribute;
	}
	
	/**
	 * Setter for character primary attribute choice.
	 * @param primaryAttribute	primary attribute choice
	 */
	public void setPrimaryAttribute(PrimaryAttrEnum primaryAttribute) {
		this.primaryAttribute = primaryAttribute;
	}
	
	/**
	 * Getter for character secondary attribute choice.
	 * @return	secondary attribute choice
	 */
	public SecondaryAttrEnum getSecondaryAttribute() {
		return secondaryAttribute;
	}
	
	/**
	 * Setter for character secondary attribute choice.
	 * @param secondaryAttribute	secondary attribute choice
	 */
	public void setSecondaryAttribute(SecondaryAttrEnum secondaryAttribute) {
		this.secondaryAttribute = secondaryAttribute;
	}
	
	/**
	 * Getter for character birthsign.
	 * @return	birthsign
	 */
	public BirthsignEnum getBirthsign() {
		return birthsign;
	}
	
	/**
	 * Setter for character birthsign.
	 * @param birthsign	birthsign
	 */
	public void setBirthsign(BirthsignEnum birthsign) {
		this.birthsign = birthsign;
	}
	
	/**
	 * Getter for user's text with notes about the build.
	 * @return	notes about the build
	 */
	public String getBuildNotes() {
		return buildNotes;
	}
	
	/**
	 * Setter for user's text with notes about the build.
	 * @param buildNotes	notes about the build
	 */
	public void setBuildNotes(String buildNotes) {
		this.buildNotes = buildNotes;
	}
}
