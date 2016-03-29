package model;

import java.util.ArrayList;
import java.util.List;

import staticData.BirthsignEnum;
import staticData.BuildConstants;
import staticData.GenderEnum;
import staticData.PrimaryAttrEnum;
import staticData.RaceEnum;
import staticData.SecondaryAttrEnum;
import staticData.SpecializationEnum;

public class CharacterBuild {
	
	private final Skill[] skills;
	private final List<Attribute> attributes;
	
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
	
	private boolean mastery;
	private boolean focus;
	private boolean prodigy;
	
	public CharacterBuild(Skill[] skills) {
		this.attributes = new ArrayList<Attribute>();
		this.skills = skills;
		
		this.currentLevel = 1;
		this.perksAvailable = 0;
		this.currentHealth = BuildConstants.ATTRIBUTE_BASE;
		this.currentMagicka = BuildConstants.ATTRIBUTE_BASE;
		this.currentStamina = BuildConstants.ATTRIBUTE_BASE;
		this.currentCarryWeight = BuildConstants.CARRY_WEIGHT_BASE;
		
		this.mastery = false;
		this.focus = false;
		this.prodigy = false;
	}
	
	public Skill[] getSkills() {
		return skills;
	}
	
	public List<Attribute> getAttributes() {
		return attributes;
	}
	
	public void setCurrentLevel(int level) {
		currentLevel = level;
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
	
	public void setCurrentHealth(int health) {
		currentHealth = health;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public void setCurrentMagicka(int magicka){
		currentMagicka = magicka;
	}
	
	public int getCurrentMagicka() {
		return currentMagicka;
	}
	
	public void setCurrentStamina(int stamina) {
			currentStamina = stamina;
	}
	
	public int getCurrentStamina() {
		return currentStamina;
	}
	
	public void setCurrentCarryWeight(int carryWeight) {
		currentCarryWeight = carryWeight;
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

	public boolean isMastery() {
		return mastery;
	}

	public void setMastery(boolean mastery) {
		this.mastery = mastery;
	}

	public boolean isFocus() {
		return focus;
	}

	public void setFocus(boolean focus) {
		this.focus = focus;
	}

	public boolean isProdigy() {
		return prodigy;
	}

	public void setProdigy(boolean prodigy) {
		this.prodigy = prodigy;
	}
}
