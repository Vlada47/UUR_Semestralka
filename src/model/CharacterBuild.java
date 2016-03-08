package model;

import java.util.List;

public class CharacterBuild {
	
	private final int minHealth;
	private final int minMagicka;
	private final int minStamina;
	private final int minCarryWeight;
	private final List<Skill> skills;
	
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
	
	public void setCurrentLevel(int level) throws Exception {
		if(level >= 1) {
			currentLevel = level;
		}
		else {
			throw new Exception("Level of the character must be at least 1!");
		}
	}
	
	public void setPerksAvailable(int perks) {
		perksAvailable = perks;
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
}
