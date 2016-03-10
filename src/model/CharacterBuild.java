package model;

import controller.BuildConstants;
import enumerators.BirthsignEnum;
import enumerators.GenderEnum;
import enumerators.PrimaryAttrEnum;
import enumerators.RaceEnum;
import enumerators.SecondaryAttrEnum;
import enumerators.SpecializationEnum;

public class CharacterBuild {
	
	private final Skill[] skills;
	
	private RaceEnum race;
	private GenderEnum gender;
	private SpecializationEnum specialization;
	private PrimaryAttrEnum primaryAttribute;
	private SecondaryAttrEnum secondaryAttribute;
	private BirthsignEnum birthsign;
	private int[] skillBonuses;
	
	private int currentLevel;
	private int perksAvailable;
	private int currentHealth;
	private int currentMagicka;
	private int currentStamina;
	private int currentCarryWeight;
	
	public CharacterBuild(Skill[] skills) {
		this.skills = skills;
		
		this.currentLevel = 1;
		this.perksAvailable = 0;
		this.currentHealth = BuildConstants.ATTRIBUTE_MINIMUM;
		this.currentMagicka = BuildConstants.ATTRIBUTE_MINIMUM;
		this.currentStamina = BuildConstants.ATTRIBUTE_MINIMUM;
		this.currentCarryWeight = BuildConstants.CARRY_WEIGHT_MINIMUM;
	}
	
	public Skill[] getSkills() {
		return skills;
	}
	
	public void setCurrentLevel(int level) throws Exception {
		if((level >= 1) && (level <= 100)) {
			currentLevel = level;
		}
		else {
			throw new Exception("Level of the character must be at least 1 and no more than 100!");
		}
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public void setPerksAvailable(int perks) {
		perksAvailable = perks;
	}
	
	public int getPerksAvailable() {
		return perksAvailable;
	}
	
	public void setCurrentHealth(int health) throws Exception {
		if(health >= BuildConstants.ATTRIBUTE_MINIMUM) {
			currentHealth = health;
		}
		else {
			throw new Exception("Current health of the character must be greater or equal to minimum health!\n"
					+ "Your value: "+health+".\n"
					+ "Minimum health: "+BuildConstants.ATTRIBUTE_MINIMUM+".");
		}
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public void setCurrentMagicka(int magicka) throws Exception {
		if(magicka >= BuildConstants.ATTRIBUTE_MINIMUM) {
			currentMagicka = magicka;
		}
		else {
			throw new Exception("Current magicka of the character must be greater or equal to minimum magicka!\n"
					+ "Your value: "+magicka+".\n"
					+ "Minimum magicka: "+BuildConstants.ATTRIBUTE_MINIMUM+".");
		}
	}
	
	public int getCurrentMagicka() {
		return currentMagicka;
	}
	
	public void setCurrentStamina(int stamina) throws Exception {
		if(stamina >= BuildConstants.ATTRIBUTE_MINIMUM) {
			currentStamina = stamina;
		}
		else {
			throw new Exception("Current stamina of the character must be greater or equal to minimum stamina!\n"
					+ "Your value: "+stamina+".\n"
					+ "Minimum stamina: "+BuildConstants.ATTRIBUTE_MINIMUM+".");
		}
	}
	
	public int getCurrentStamina() {
		return currentStamina;
	}
	
	public void setCurrentCarryWeight(int carryWeight) throws Exception {
		if(carryWeight >= BuildConstants.ATTRIBUTE_MINIMUM) {
			currentCarryWeight = carryWeight;
		}
		else {
			throw new Exception("Current carry weight of the character must be greater or equal to minimum carry weight!\n"
					+ "Your value: "+carryWeight+".\n"
					+ "Minimum carry weight: "+BuildConstants.ATTRIBUTE_MINIMUM+".");
		}
	}
	
	public int getCurrentCarryWeight() {
		return currentCarryWeight;
	}

	public RaceEnum getRace() {
		return race;
	}

	public void setRace(RaceEnum race) {
		this.race = race;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public SpecializationEnum getSpecialization() {
		return specialization;
	}

	public void setSpecialization(SpecializationEnum specialization) {
		this.specialization = specialization;
	}

	public PrimaryAttrEnum getPrimaryAttribute() {
		return primaryAttribute;
	}

	public void setPrimaryAttribute(PrimaryAttrEnum primaryAttribute) {
		this.primaryAttribute = primaryAttribute;
	}

	public SecondaryAttrEnum getSecondaryAttribute() {
		return secondaryAttribute;
	}

	public void setSecondaryAttribute(SecondaryAttrEnum secondaryAttribute) {
		this.secondaryAttribute = secondaryAttribute;
	}

	public BirthsignEnum getBirthsign() {
		return birthsign;
	}

	public void setBirthsign(BirthsignEnum birthsign) {
		this.birthsign = birthsign;
	}

	public int[] getSkillBonuses() {
		return skillBonuses;
	}

	public void setSkillBonuses(int[] skillBonuses) {
		this.skillBonuses = skillBonuses;
	}
}
