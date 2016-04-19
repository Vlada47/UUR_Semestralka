package model;

import java.util.Stack;

import staticData.BirthsignEnum;
import staticData.BuildConstants;
import staticData.GenderEnum;
import staticData.PrimaryAttrEnum;
import staticData.RaceEnum;
import staticData.SecondaryAttrEnum;
import staticData.SpecializationEnum;

public class CharacterBuild {
	
	private final Skill[] skills;
	private final Attribute[] attributes;
	private final Stack<Attribute> lastHealth;
	private final Stack<Attribute> lastMagicka;
	private final Stack<Attribute> lastStamina;
	private final int[] perkCntAtLevelUp;
	private final int[] attributeGainAtLevelUp;
	
	private RaceEnum race;
	private GenderEnum gender;
	private SpecializationEnum specialization;
	private PrimaryAttrEnum primaryAttribute;
	private SecondaryAttrEnum secondaryAttribute;
	private BirthsignEnum birthsign;
	
	private int currentLevel;
	private double currentXP;
	private int perksAvailable;
	private int currentHealth;
	private int currentMagicka;
	private int currentStamina;
	
	private String buildNotes;

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
		
		this.currentLevel = 1;
		this.perksAvailable = 0;
		this.currentHealth = BuildConstants.ATTRIBUTE_BASE;
		this.currentMagicka = BuildConstants.ATTRIBUTE_BASE;
		this.currentStamina = BuildConstants.ATTRIBUTE_BASE;
		this.buildNotes = "Notes...";
		
		attributes[0] = new Attribute(PrimaryAttrEnum.HEALTH, 0);
	}

	public Skill[] getSkills() {
		return skills;
	}
	
	public int[] getPerkCntAtLevelUp() {
		return perkCntAtLevelUp;
	}

	public int[] getAttributeGainAtLevelUp() {
		return attributeGainAtLevelUp;
	}
	
	public void addAttribute(Attribute attribute) {
		for(int i = 0; i < attributes.length; i++) {
			if(attributes[i] == null) {
				attributes[i] = attribute;
				break;
			}
		}
	}
	
	public Attribute[] getAttributes() {
		return attributes;
	}
	
	public void pushLastHealth(Attribute health) {
		lastHealth.push(health);
	}
	
	public Stack<Attribute> getLastHealth() {
		return lastHealth;
	}
	
	public void pushLastMagicka(Attribute magicka) {
		lastMagicka.push(magicka);
	}
	
	public Stack<Attribute> getLastMagicka() {
		return lastMagicka;
	}
	
	public void pushLastStamina(Attribute stamina) {
		lastStamina.push(stamina);
	}
	
	public Stack<Attribute> getLastStamina() {
		return lastStamina;
	}
	
	public void setCurrentLevel(int level) {
		currentLevel = level;
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public double getCurrentXP() {
		return currentXP;
	}

	public void setCurrentXP(double currentXP) {
		this.currentXP = currentXP;
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
	
	public String getBuildNotes() {
		return buildNotes;
	}

	public void setBuildNotes(String buildNotes) {
		this.buildNotes = buildNotes;
	}
}
