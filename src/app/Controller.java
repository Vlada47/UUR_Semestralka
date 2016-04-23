package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.control.Alert.AlertType;
import model.Attribute;
import model.CharacterBuild;
import model.Perk;
import model.Skill;
import staticData.BirthsignEnum;
import staticData.BuildConstants;
import staticData.GenderEnum;
import staticData.PerkConstants;
import staticData.PrimaryAttrEnum;
import staticData.RaceEnum;
import staticData.SecondaryAttrEnum;
import staticData.SkillEnum;
import staticData.SpecializationEnum;
import view.CenterPane;
import view.LeftPane;
import view.recordObjects.AttributeRec;
import view.recordObjects.PerkRec;

public class Controller {
	
	private static LeftPane leftPane;
	private static CenterPane centerPane;
	
	private static boolean warningStatus = true;
	private static SkillEnum currentSkill = SkillEnum.ILLUSION;
	private static CharacterBuild characterBuild;
	
	public static void setGuiReferences(LeftPane lp, CenterPane cp) {
		leftPane = lp;
		centerPane = cp;
	}
	
	public static void setInfoFieldsDisable(boolean disable) {
		leftPane.setTextFieldsDisable(disable);
	}
	
	public static void setBuildNotesDisable(boolean disable) {
		leftPane.setExtensionPaneDisable(disable);
	}
	
	public static void setGeneralTabDisable(boolean disable) {
		centerPane.setGeneralTabDisable(disable);
	}
	
	public static void setGeneralTabControlDisable(boolean disable) {
		centerPane.setGeneralTabControlDisable(disable);
	}
	
	public static void setDevelopmentTabsDisable(boolean disable) {
		centerPane.setSkillTabDisable(disable);
		centerPane.setAttrDistribTabDisable(disable);
	}
	
	public static void setWarningStatus(boolean wStatus) {
		warningStatus = wStatus;
	}
	
	public static boolean getWarningStatus() {
		return warningStatus;
	}
	
	public static boolean saveBuild(File file) {
		boolean success = false;
		
		if(characterBuild != null) {
			try {
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(characterBuild);
				oos.close();
				fos.close();
				success = true;
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		return success;
	}
	
	public static boolean loadBuild(File file) {
		boolean success = false;
		
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			characterBuild = (CharacterBuild) ois.readObject();
			ois.close();
			fis.close();
			success = true;
			displayStatus();
			
			setInfoFieldsDisable(false);
			setBuildNotesDisable(false);
			setGeneralTabDisable(false);
			if(characterBuild.isBuildSet()) {
				setGeneralTabControlDisable(true);
				setDevelopmentTabsDisable(false);
			}
			else {
				setGeneralTabControlDisable(false);
				setDevelopmentTabsDisable(true);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	public static void createCharacter() {
			Skill[] skills = new Skill[BuildConstants.SKILLS_COUNT];
			
			for(SkillEnum skill : SkillEnum.values()) {
				skills[skill.getId()] = new Skill(skill);
			}
			
			characterBuild = new CharacterBuild(skills);
			createCharacterPerks(skills);
			createPerkCntLevelUps();
			createAttrGainsLevelUps();
	}
	
	private static void createCharacterPerks(Skill[] skills) {
		for(Skill skill : skills) {
			Perk[] perks = new Perk[PerkConstants.PERK_LABELS[skill.getSkillInstance().getId()].length];
			
			for(int i = 0; i < perks.length; i++) {
				int skillIndex = skill.getSkillInstance().getId();
				perks[i] = new Perk(PerkConstants.PERK_LABELS[skillIndex][i], 
						PerkConstants.PERK_MAX_LEVELS[skillIndex][i], 
						PerkConstants.PERK_SKILL_LEVELS[skillIndex][i], 
						PerkConstants.PERK_REQ_PERKS[skillIndex][i]);
			}
			skill.setPerks(perks);
		}
	}
	
	public static void setBuildBase(RaceEnum race, GenderEnum gender, SpecializationEnum specialization, PrimaryAttrEnum primaryAttribute, SecondaryAttrEnum secondaryAttribute, BirthsignEnum birthsign) {
		if(characterBuild != null) {
			characterBuild.setRace(race);
			characterBuild.setGender(gender);
			characterBuild.setSpecialization(specialization);
			characterBuild.setPrimaryAttribute(primaryAttribute);
			characterBuild.setSecondaryAttribute(secondaryAttribute);
			characterBuild.setBirthsign(birthsign);
			
			int health = characterBuild.getCurrentHealth();
			health += BuildConstants.HEALTH_MODIFIERS[race.getId()][gender.getId()];
			if(primaryAttribute == PrimaryAttrEnum.HEALTH) health += BuildConstants.PRIMARY_ATTRIBUTE_BONUS;
			
			int magicka = characterBuild.getCurrentMagicka();
			magicka += BuildConstants.MAGICKA_MODIFIERS[race.getId()][gender.getId()];
			if(primaryAttribute == PrimaryAttrEnum.MAGICKA) magicka += BuildConstants.PRIMARY_ATTRIBUTE_BONUS;
			
			int stamina = characterBuild.getCurrentStamina();
			stamina += BuildConstants.STAMINA_MODIFIERS[race.getId()][gender.getId()];
			if(primaryAttribute == PrimaryAttrEnum.STAMINA) stamina += BuildConstants.PRIMARY_ATTRIBUTE_BONUS;
			
			characterBuild.setCurrentHealth(health);
			characterBuild.setCurrentMagicka(magicka);
			characterBuild.setCurrentStamina(stamina);
			
			Skill[] skills = characterBuild.getSkills();
			for(int i = 0; i < skills.length; i++) {
				int targetLevel = skills[i].getCurrentLevel() + BuildConstants.SKILL_MODIFIERS[race.getId()][skills[i].getSkillInstance().getId()];
				skills[i].setStartingLevel(targetLevel);
			}
			
			characterBuild.setBuildSet(true);
		}
		
		displayStatus();
	}
	
	public static void clearBuild() {
		createCharacter();
		displayStatus();
	}
	
	public static void increaseAttribute(PrimaryAttrEnum attribute) {
		int attrLevel = characterBuild.getLastHealth().size()+characterBuild.getLastMagicka().size()+characterBuild.getLastStamina().size() + 2;
		
		if(attrLevel <= characterBuild.getCurrentLevel()) {
			int attrGain = characterBuild.getAttributeGainAtLevelUp()[attrLevel];
			
			Attribute a = new Attribute(attribute, attrGain);
			characterBuild.addAttribute(a);
			
			if(attribute == PrimaryAttrEnum.HEALTH) {
				characterBuild.pushLastHealth(a);
				characterBuild.setCurrentHealth(characterBuild.getCurrentHealth() + attrGain);
			}
			else if(attribute == PrimaryAttrEnum.MAGICKA) {
				characterBuild.pushLastMagicka(a);
				characterBuild.setCurrentMagicka(characterBuild.getCurrentMagicka() + attrGain);
			}
			else if(attribute == PrimaryAttrEnum.STAMINA) {
				characterBuild.pushLastStamina(a);
				characterBuild.setCurrentStamina(characterBuild.getCurrentStamina() + attrGain);
			}
			
			displayStatus();
		}
		else {
			if(warningStatus) {
				Main.displayAlert(AlertType.INFORMATION, 
						"Attribute increase alert", 
						"Character level too low:", 
						"You have to aquire more character levels to increase the attribute.");
			}
		}
	}
	
	public static void decreaseAttribute(PrimaryAttrEnum attribute) {
		if(attribute == PrimaryAttrEnum.HEALTH) {
			if(!characterBuild.getLastHealth().empty()) {
				Attribute a = characterBuild.getLastHealth().pop();
				removeAttribute(a);
				characterBuild.setCurrentHealth(characterBuild.getCurrentHealth() - a.getGain());
			}
		}
		else if(attribute == PrimaryAttrEnum.MAGICKA) {
			if(!characterBuild.getLastMagicka().empty()) {
				Attribute a = characterBuild.getLastMagicka().pop();
				removeAttribute(a);
				characterBuild.setCurrentMagicka(characterBuild.getCurrentMagicka() - a.getGain());
			}
		}
		else if(attribute == PrimaryAttrEnum.STAMINA) {
			if(!characterBuild.getLastStamina().empty()) {
				Attribute a = characterBuild.getLastStamina().pop();
				removeAttribute(a);
				characterBuild.setCurrentStamina(characterBuild.getCurrentStamina() - a.getGain());
			}
		}
		
		displayStatus();
	}
	
	public static void changeSkill(SkillEnum skill) {
		currentSkill = skill;
		displayStatus();
	}
	
	public static void takeSkillLevel() {
		boolean result = characterBuild.getSkills()[currentSkill.getId()].takeLevel();
		
		if(!result && warningStatus) {
			Main.displayAlert(AlertType.INFORMATION, 
					"Skill level increase alert", 
					"Maximum skill level reached:", 
					"You can't increase the skill level over "+BuildConstants.MAX_SKILL_LEVEL+".");
		}
		else {
			int currentCharacterLevel = characterBuild.getCurrentLevel();
			int currentSkillLevel = characterBuild.getSkills()[currentSkill.getId()].getCurrentLevel();
			double levelUpXP = getLevelUpXP(currentCharacterLevel);
			double gainXP =  getXPGain(currentSkillLevel, BuildConstants.SKILL_XP_MULTS[currentSkill.getId()]);
			double currentXP = characterBuild.getCurrentXP() + gainXP;
			
			if(currentXP >= levelUpXP) {
				characterBuild.setCurrentXP(0);
				int perksAvailable = characterBuild.getPerksAvailable();
				int perksGain = characterBuild.getPerkCntAtLevelUp()[currentCharacterLevel];
				characterBuild.setCurrentLevel(currentCharacterLevel + 1);
				characterBuild.setPerksAvailable(perksAvailable + perksGain);
			}
			else {
				characterBuild.setCurrentXP(currentXP);
			}
		}
		
		displayStatus();
	}
	
	public static void removeSkillLevel() {
		boolean result = characterBuild.getSkills()[currentSkill.getId()].removeLevel();
		
		if(!result && warningStatus) {
			Main.displayAlert(AlertType.INFORMATION, 
					"Skill level decrease alert", 
					"Skill is on the minimum functional level:", 
					"Skill is either on the minimal level for your character or some perk(s) requires this level.");
		}
		else {
			//to-do: removing gained character levels and perk points
		}
		
		displayStatus();
	}
	
	public static void resetSkill() {
		characterBuild.getSkills()[currentSkill.getId()].resetSkill();
		
		//to-do: removing gained character levels and perk points
		
		displayStatus();
	}
	
	public static void takePerkLevel(int perkIndex) {
		boolean result = characterBuild.getSkills()[currentSkill.getId()].getPerks()[perkIndex].takeLevel();
		
		if(!result && warningStatus) {
			Main.displayAlert(AlertType.INFORMATION, 
					"Perk level increase alert", 
					"All available levels already taken:", 
					"You have already taken all available levels of the perk.");
		}
		else {
			characterBuild.setPerksAvailable(characterBuild.getPerksAvailable()-1);
		}
		
		displayStatus();
	}
	
	public static void removePerkLevel(int perkIndex) {
		boolean result = characterBuild.getSkills()[currentSkill.getId()].getPerks()[perkIndex].removeLevel();
		
		if(!result && warningStatus) {
			Main.displayAlert(AlertType.INFORMATION, 
					"Perk level decrease alert", 
					"No levels taken yet:", 
					"You have not taken any level in the perk.");
		}
		else {
			characterBuild.setPerksAvailable(characterBuild.getPerksAvailable()+1);
		}
		
		displayStatus();
	}
	
	public static void saveBuildNotes(String notes) {
		characterBuild.setBuildNotes(notes);
	}
	
	private static void displayStatus() {
		leftPane.setLevelValue(characterBuild.getCurrentLevel());
		leftPane.setPerksValue(characterBuild.getPerksAvailable());
		leftPane.setHealthValue(characterBuild.getCurrentHealth());
		leftPane.setMagickaValue(characterBuild.getCurrentMagicka());
		leftPane.setStaminaValue(characterBuild.getCurrentStamina());
		leftPane.setNotesText(characterBuild.getBuildNotes());
		
		centerPane.setGeneralTabValues(characterBuild.getRace(), characterBuild.getGender(), characterBuild.getSpecialization(), characterBuild.getPrimaryAttribute(), characterBuild.getSecondaryAttribute(), characterBuild.getBirthsign());
		centerPane.setSkillTabValues(currentSkill, characterBuild.getSkills()[currentSkill.getId()].getCurrentLevel(), createPerkRecList(characterBuild.getSkills()[currentSkill.getId()].getPerks()));
		centerPane.setAttrDistribTabList(createAttrRecList(characterBuild.getAttributes()));
	}
	
	private static void createPerkCntLevelUps() {
		double sum = 0.0;
		int index = 0;
		
		characterBuild.getPerkCntAtLevelUp()[0] = 0;
		
		for(int i = 1; i < characterBuild.getPerkCntAtLevelUp().length; i++) {
			if(index < (BuildConstants.PERK_LEVELUPS.length-1)) {
				if(i >= BuildConstants.PERK_LEVELUPS[index+1][0]) {
					index++;
				}
			}
			
			sum += BuildConstants.PERK_LEVELUPS[index][1];
			characterBuild.getPerkCntAtLevelUp()[i] = (int)sum;
			sum = sum - (int)sum;
		}
	}
	
	private static void createAttrGainsLevelUps() {
		int index = 0;
		
		characterBuild.getAttributeGainAtLevelUp()[0] = 0;
		
		for(int i = 1; i < characterBuild.getAttributeGainAtLevelUp().length; i++) {
			if(index < (BuildConstants.ATTRIBUTE_LEVELUPS.length-1)) {
				if(i >= BuildConstants.ATTRIBUTE_LEVELUPS[index+1][0]) {
					index++;
				}
			}
			
			characterBuild.getAttributeGainAtLevelUp()[i] = BuildConstants.ATTRIBUTE_LEVELUPS[index][1];
		}
	}
	
	private static void removeAttribute(Attribute a) {
		Attribute[] attributes = characterBuild.getAttributes();
		
		for(int i = 0; i < attributes.length; i++) {
			if(attributes[i] == a) attributes[i] = null;
		}
	}
	
	private static List<PerkRec> createPerkRecList(Perk[] perks) {
		List<PerkRec> perkRecList = new ArrayList<>();
		
		for(int i = 0; i < perks.length; i++) {
			String reqPerks = "";
			String skillLevels = Arrays.toString(perks[i].getSkillLevels());
			
			for(int index : perks[i].getReqPerks()) {
				if(index >= 0) reqPerks += perks[index].getLabel() + "; ";
			}
			
			perkRecList.add(new PerkRec(i, perks[i].getLabel(), reqPerks, perks[i].getLevelsTaken(), perks[i].getMaxLevel(), skillLevels));
		}
		
		return perkRecList;
	}
	
	private static List<AttributeRec> createAttrRecList(Attribute[] attributes) {
		List<AttributeRec> attrRecList = new ArrayList<>();
		
		for(int i = 0; i < attributes.length; i++) {
			if(attributes[i] != null) {
				attrRecList.add(new AttributeRec(i+1, attributes[i].getAttribute().getLabel(), attributes[i].getGain()));
			}
		}
		
		return attrRecList;
	}
	
	private static double getXPGain(int skillLevel, double skillXPMod) {
		return (skillLevel * skillXPMod);
	}
	
	private static double getLevelUpXP(int currentLevel) {
		return (currentLevel + 3) * 25;
	}

}
