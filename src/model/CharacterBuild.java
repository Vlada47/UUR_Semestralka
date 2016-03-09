package model;

import java.util.List;

import enumerators.BirthsignEnum;
import enumerators.GenderEnum;
import enumerators.PrimaryAttrEnum;
import enumerators.RaceEnum;
import enumerators.SecondaryAttrEnum;
import enumerators.SpecializationEnum;

public class CharacterBuild {
	
	private final int minHealth;
	private final int minMagicka;
	private final int minStamina;
	private final int minCarryWeight;
	private final List<Skill> skills;
	
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
	
	public CharacterBuild(int minHealth, int minMagicka, int minStamina, int minCarryWeight, List<Skill> skills) {
		this.minHealth = minHealth;
		this.minMagicka = minMagicka;
		this.minStamina = minStamina;
		this.minCarryWeight = minCarryWeight;
		this.skills = skills;
		
		this.currentLevel = 1;
		this.perksAvailable = 0;
		this.currentHealth = minHealth;
		this.currentMagicka = minMagicka;
		this.currentStamina = minStamina;
		this.currentCarryWeight = minCarryWeight;
	}
	
	public List<Skill> getSkills() {
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
		if(health >= minHealth) {
			currentHealth = health;
		}
		else {
			throw new Exception("Current health of the character must be greater or equal to minimum health!\n"
					+ "Your value: "+health+".\n"
					+ "Minimum health: "+minHealth+".");
		}
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public void setCurrentMagicka(int magicka) throws Exception {
		if(magicka >= minMagicka) {
			currentMagicka = magicka;
		}
		else {
			throw new Exception("Current magicka of the character must be greater or equal to minimum magicka!\n"
					+ "Your value: "+magicka+".\n"
					+ "Minimum magicka: "+minMagicka+".");
		}
	}
	
	public int getCurrentMagicka() {
		return currentMagicka;
	}
	
	public void setCurrentStamina(int stamina) throws Exception {
		if(stamina >= minStamina) {
			currentStamina = stamina;
		}
		else {
			throw new Exception("Current stamina of the character must be greater or equal to minimum stamina!\n"
					+ "Your value: "+stamina+".\n"
					+ "Minimum stamina: "+minStamina+".");
		}
	}
	
	public int getCurrentStamina() {
		return currentStamina;
	}
	
	public void setCurrentCarryWeight(int carryWeight) throws Exception {
		if(carryWeight >= minCarryWeight) {
			currentCarryWeight = carryWeight;
		}
		else {
			throw new Exception("Current carry weight of the character must be greater or equal to minimum carry weight!\n"
					+ "Your value: "+carryWeight+".\n"
					+ "Minimum carry weight: "+minCarryWeight+".");
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
