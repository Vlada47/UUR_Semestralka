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

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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

/**
 * The controller class of the applications. It contains a number of methods, which server as "broker" between the data model and view elements.
 * Class and its methods are completely static and can be accessed from any place of the application (the public ones). 
 * @author Vlada47
 *
 */
public class Controller {
	
	/**
	 * Reference to the left pane instance.
	 */
	private static LeftPane leftPane;
	
	/**
	 * Reference to the center pane instance.
	 */
	private static CenterPane centerPane;
	
	/**
	 * Variable indicating warning status (true/false) of the application.
	 * It is used for displaying alerts and notifications. It's defaulted to true.
	 */
	private static boolean warningStatus = true;
	
	/**
	 * Indicator of currently chosen skill on skill tab.
	 * It is defaulted to Illusion skill (first value from {@code SkillEnum} enumerator).
	 */
	private static SkillEnum currentSkill = SkillEnum.ILLUSION;
	
	/**
	 * Instance of the character build.
	 */
	private static CharacterBuild characterBuild;
	
	/**
	 * Method for confirmation of exiting the application.
	 * @return	true/false
	 */
	public static boolean endAppConfirmed() {
		ButtonType result = displayAlert(AlertType.CONFIRMATION, 
				"Confirmation alert", 
				"Exiting application confirmation:", 
				"Make sure any changes you made are saved or you don't care about them, because they will gone... forever. "
				+ "Are you sure you want to continue?");
		
		if(result == ButtonType.OK) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method which saves the references to main GUI instances, so the controller can make changes on GUI.
	 * @param lp	instance of the left pane
	 * @param cp	instance of the center pane
	 */
	public static void setGuiReferences(LeftPane lp, CenterPane cp) {
		leftPane = lp;
		centerPane = cp;
	}
	
	/**
	 * Method that informs, if the build was started/loaded.
	 * It is used for saving build functionality.
	 * @return	true/false
	 */
	public static boolean characterBuildInstanceExists() {
		if(characterBuild != null) {
			return true;
		}
		else {
			displayAlert(AlertType.ERROR, 
					"Save build error", 
					"Error:", 
					"The build hasn't been started yet. "
					+ "You have to start a build or load some from the file to be able to save it.");
			
			return false;
		}
	}
	
	/**
	 * Method, which purpose is to disable fields with values on the left pane.
	 * It calls {@code setTextFieldsDisable} method from {@code LeftPane} class.
	 * @param disable	true/false
	 */
	public static void setInfoFieldsDisable(boolean disable) {
		leftPane.setTextFieldsDisable(disable);
	}
	
	/**
	 * Method, which purpose is to disable text area and save button for notes on the left pane.
	 * It calls {@code setExtensionPaneDisable} method from {@code LeftPane} class.
	 * @param disable	true/false
	 */
	public static void setBuildNotesDisable(boolean disable) {
		leftPane.setExtensionPaneDisable(disable);
	}
	
	/**
	 * Method, which purpose is to disable the general tab on center pane.
	 * It calls {@code setGeneralTabDisable} method from {@code CenterPane} class.
	 * @param disable	true/false
	 */
	public static void setGeneralTabDisable(boolean disable) {
		centerPane.setGeneralTabDisable(disable);
	}
	
	/**
	 * Method, which purpose is to disable the combo boxes and confirm button of the general tab.
	 * It calls {@code setGeneralTabControlDisable} method from {@code CenterPane} class.
	 * @param disable	true/false
	 */
	public static void setGeneralTabControlDisable(boolean disable) {
		centerPane.setGeneralTabControlDisable(disable);
	}
	
	/**
	 * Method, which purpose is to disable skill and attributes tabs on the center pane.
	 * It calls {@code setSkillTabDisable} and {@code setAttrDistribTabDisable} method from {@code CenterPane} class.
	 * @param disable	true/false
	 */
	public static void setDevelopmentTabsDisable(boolean disable) {
		centerPane.setSkillTabDisable(disable);
		centerPane.setAttrDistribTabDisable(disable);
	}
	
	/**
	 * Setter for the {@code warningStatus} variable.
	 * @param wStatus true/false
	 */
	public static void setWarningStatus(boolean wStatus) {
		warningStatus = wStatus;
	}
	
	/**
	 * Getter for the {@code warningStatus} variable.
	 * @return	current value of the {@code warningStatus} variable
	 */
	public static boolean getWarningStatus() {
		return warningStatus;
	}
	
	/**
	 * Method servicing the functionality for saving the file with current build serialization.
	 * It uses {@code ObjectOutputStream} to write the serialized {@code CharacterBuild} object.
	 * If the build was saved successfully, the information alert is displayed, otherwise the error alert will appear.
	 * @param file	target file for the build's content
	 */
	public static void saveBuild(File file) {
		boolean success = false;
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				
			oos.writeObject(characterBuild);
			oos.close();
			fos.close();
			success = true;
		}
		catch (IOException e) {
			//e.printStackTrace();
		}
		
		if(!success) {
			displayAlert(AlertType.ERROR, 
					"Save build error", 
					"Error:", 
					"The build couldn't be saved in the file. "
					+ "Make sure you can create a file on target position.");
		}
	}
	
	/**
	 * Method servicing the functionality for loading the file with saved build serialization.
	 * It uses {@code ObjectInputStream} to read the serialized {@code CharacterBuild} object.
	 * If the build was loaded successfully, the information alert is displayed, otherwise the error alert will appear.
	 * Depending on the value of the {@code buildSet} attribute of the object, different GUI parts are enabled/disabled.
	 * @param file	source file with the build's content
	 */
	public static void loadBuild(File file) {
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
				//character is already in the development state
				setGeneralTabControlDisable(true);
				setDevelopmentTabsDisable(false);
			}
			else {
				setGeneralTabControlDisable(false);
				setDevelopmentTabsDisable(true);
			}
			
		} 
		catch(IOException e) {
			//e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			//e.printStackTrace();
		}
		
		if(!success) {
			displayAlert(AlertType.ERROR, 
					"Load build error", 
					"Error:", 
					"The build wasn't loaded from the file. "
					+ "Make sure you're trying to load the correct file (correct format).");
		}
	}
	
	/**
	 * Method, which initiates the {@code characterBuild} object and creates the array with {@code Skill} instances for it.
	 * Then it calls other methods, which creates more starting data for the build instance.
	 */
	public static void createCharacter() {
			Skill[] skills = new Skill[BuildConstants.SKILLS_COUNT];
			
			for(SkillEnum skill : SkillEnum.values()) {
				skills[skill.getId()] = new Skill(skill);
			}
			
			characterBuild = new CharacterBuild(skills);
			createCharacterPerks(skills);
			createPerkCntLevelUps();
			createAttrGainsLevelUps();
			displayStatus();
	}
	
	/**
	 * Method, which iterates through the {@code Skill} instances of the build and creates the arrays of {@code Perk} instances for them.
	 * Perk data are read from constants in {@code PerkConstants} class.
	 * @param skills	array of {@code Skill} instances of the build
	 */
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
	
	/**
	 * This method represents sort of a control, when starting a new build. In case the {@code characterBuild} instance is already set,
	 * the confirmation alert is displayed. If user confirms the action, method returns true otherwise false.
	 * @return	confirmation of the action (true/false)
	 */
	public static boolean confirmNewBuild() {
		boolean confirm = true;
		
		if(warningStatus && characterBuild != null) {
			ButtonType result = displayAlert(AlertType.CONFIRMATION, 
					"Confirmation alert", 
					"New build confirmation:", 
					"This action will erase any values you have currently set up and resets all leveling parameters. "
					+ "Are you sure you want to continue?");
			
			if(result != ButtonType.OK) {
				confirm = false;
			}
		}
		
		return confirm;
	}
	
	/**
	 * Method, which sets up general build creation (when confirming the choices on the general tab).
	 * It takes passed choices (selected enum values) and saves them in the data model. More attributes
	 * on data model are modified depending on aforementioned choices (exact values are taken from {@code BuildConstants} class).
	 * At the end it sets up {@code buildSet} attribute of the build instance on true (indicating it is now in development state).
	 * @param race					selected race
	 * @param gender				selected gender
	 * @param specialization		selected specialization
	 * @param primaryAttribute		selected primary attribute
	 * @param secondaryAttribute	selected secondary attribute
	 * @param birthsign				selected birthsign
	 */
	public static void setBuildBase(RaceEnum race, GenderEnum gender, SpecializationEnum specialization, PrimaryAttrEnum primaryAttribute, SecondaryAttrEnum secondaryAttribute, BirthsignEnum birthsign) {
		if(characterBuild != null) {
			//setting up choices in the model
			characterBuild.setRace(race);
			characterBuild.setGender(gender);
			characterBuild.setSpecialization(specialization);
			characterBuild.setPrimaryAttribute(primaryAttribute);
			characterBuild.setSecondaryAttribute(secondaryAttribute);
			characterBuild.setBirthsign(birthsign);
			
			//modifying selected primary attribute based on the choices
			int health = characterBuild.getCurrentHealth();
			health += BuildConstants.HEALTH_MODIFIERS[race.getId()][gender.getId()];
			if(primaryAttribute == PrimaryAttrEnum.HEALTH) health += BuildConstants.PRIMARY_ATTRIBUTE_BONUS;
			
			int magicka = characterBuild.getCurrentMagicka();
			magicka += BuildConstants.MAGICKA_MODIFIERS[race.getId()][gender.getId()];
			if(primaryAttribute == PrimaryAttrEnum.MAGICKA) magicka += BuildConstants.PRIMARY_ATTRIBUTE_BONUS;
			
			int stamina = characterBuild.getCurrentStamina();
			stamina += BuildConstants.STAMINA_MODIFIERS[race.getId()][gender.getId()];
			if(primaryAttribute == PrimaryAttrEnum.STAMINA) stamina += BuildConstants.PRIMARY_ATTRIBUTE_BONUS;
			
			//setting up current values of primary attributes
			characterBuild.setCurrentHealth(health);
			characterBuild.setCurrentMagicka(magicka);
			characterBuild.setCurrentStamina(stamina);
			
			//setting up skill modifiers based on race choice
			Skill[] skills = characterBuild.getSkills();
			for(int i = 0; i < skills.length; i++) {
				int skillId = skills[i].getSkillInstance().getId();
				int targetLevel = skills[i].getCurrentLevel() + BuildConstants.SKILL_MODIFIERS[race.getId()][skillId];
				skills[i].setStartingLevel(targetLevel);
			}
			
			characterBuild.setBuildSet(true);
		}
		
		displayStatus();
	}
	
	/**
	 * Method, which initiates new build by calling {@code createCharacter} method.
	 * It is used, when "Reset" button on general tab is used. 
	 * It saves the notes by storing them shortly in its {@code String} and setting it back to the build. 
	 */
	public static void clearBuild() {
		String notes = characterBuild.getBuildNotes();
		createCharacter();
		characterBuild.setBuildNotes(notes);
		displayStatus();
	}
	
	/**
	 * This method represents sort of a control, when reseting the build.
	 * If user confirms the action, method returns true otherwise false.
	 * @return	confirmation of the action (true/false)
	 */
	public static boolean confirmBuildReset() {
		boolean confirm = true;
		
		if(warningStatus) {
			ButtonType result = displayAlert(AlertType.CONFIRMATION, 
					"Confirmation alert", 
					"Reset build confirmation:", 
					"This action will reset values you have currently set up (apart from your notes). "
					+ "Are you sure you want to proceed?");
			
			if(result != ButtonType.OK) {
				confirm = false;
			}
		}
		
		return confirm;
	}
	
	/**
	 * Method, which services increasing of chosen primary attribute per character level gained.
	 * It first calculates the target level, for which the attribute is being increased and then checks,
	 * whether this level is lesser or equal to current character level. If yes, then the attribute is added
	 * to its respective stack and also to the list of attribute gains. Current value of that attribute
	 * is also increased on the build. If not, then the alert may be shown to inform the user that all levels
	 * of the character has been used to distribute primary attributes.
	 * @param attribute	chosen attribute to increase
	 */
	public static void increaseAttribute(PrimaryAttrEnum attribute) {
		int healthLvlCnt = characterBuild.getLastHealth().size();
		int magickaLvlCnt = characterBuild.getLastMagicka().size();
		int staminaLvlCnt = characterBuild.getLastStamina().size();
		int attrLevel = healthLvlCnt + magickaLvlCnt + staminaLvlCnt + 2;
		
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
				displayAlert(AlertType.INFORMATION, 
						"Attribute increase alert", 
						"Character level too low:", 
						"You have to aquire more character levels to increase the attribute.");
			}
		}
	}
	
	/**
	 * Method, which services decreasing of chosen primary attribute per character level gained.
	 * Unless the stack of chosen attribute is empty, it pops the last one and removes (by calling {@code removeAttribute} method) it from list of all
	 * distributed primary attributes. It then decrease the current value of the respective attribute in the build.
	 * @param attribute	chosen attribute to decrease
	 */
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
	
	/**
	 * Method, which iterates through the array of distributed attributes and removes the one, of which instance is passed to the method. 
	 * @param a	attribute to be be removed
	 */
	private static void removeAttribute(Attribute a) {
		Attribute[] attributes = characterBuild.getAttributes();
		
		for(int i = 0; i < attributes.length; i++) {
			if(attributes[i] == a) attributes[i] = null;
		}
	}
	
	/**
	 * Method for switching currently set skill (when user selects different one on skill tab).
	 * @param skill	the skill, which will be switched to
	 */
	public static void changeSkill(SkillEnum skill) {
		currentSkill = skill;
		displayStatus();
	}
	
	/**
	 * Method which handles increasing of the currently set skill level and resulting calculations of the character's main level.
	 * Unless the skill is on the maximal level, it gets increased on the build and then it is calculated (with the aid of few other methods)
	 * how much experience points was gained by the skill level increase. If the experience gained is big enough for advance in the main character level,
	 * this level value is increased by 1 and perk points available are increased by respective amount.
	 */
	public static void takeSkillLevel() {
		boolean result = characterBuild.getSkills()[currentSkill.getId()].takeLevel();
		
		if(!result && warningStatus) {
			displayAlert(AlertType.INFORMATION, 
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
				characterBuild.setCurrentXP(currentXP - levelUpXP);
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
	
	/**
	 * Method which handles decreasing of the currently set skill level and resulting calculations of the character's main level.
	 * Unless the skill is on the minimal level or the character has some perk chosen, which requires the current level,
	 * it gets decreased on the build and then it is calculated (with the aid of few other methods)
	 * how much experience points was lost by the skill level decrease. If the experience lost is big enough for losing the main character level,
	 * this level value is decreased by 1 and perk points available are decreased by respective amount.
	 */
	public static void removeSkillLevel() {
		boolean result = characterBuild.getSkills()[currentSkill.getId()].removeLevel();
		
		if(!result && warningStatus) {
			displayAlert(AlertType.INFORMATION, 
					"Skill level decrease alert", 
					"Skill is on the minimum functional level:", 
					"Skill is either on the minimal level for your character or some perk(s) requires this level.");
		}
		else {
			int currentCharacterLevel = characterBuild.getCurrentLevel();
			int currentSkillLevel = characterBuild.getSkills()[currentSkill.getId()].getCurrentLevel();
			double gainXP =  getXPGain(currentSkillLevel + 1, BuildConstants.SKILL_XP_MULTS[currentSkill.getId()]);
			double currentXP = characterBuild.getCurrentXP() - gainXP;
			
			if(currentXP < 0) {
				int perksAvailable = characterBuild.getPerksAvailable();
				int perksGain = characterBuild.getPerkCntAtLevelUp()[currentCharacterLevel - 1];
				currentXP = getLevelUpXP(currentCharacterLevel - 1) + currentXP;
				characterBuild.setCurrentXP(currentXP);
				characterBuild.setCurrentLevel(currentCharacterLevel - 1);
				characterBuild.setPerksAvailable(perksAvailable - perksGain);
			}
			else {
				characterBuild.setCurrentXP(currentXP);
			}
			
		}
		
		displayStatus();
	}
	
	/**
	 * Method, which handles reseting currently chosen skill. It decreases the skill level to starting value of the character
	 * and removes all perk investments. Character level and perk points available are calculated accordingly. It basically
	 * works in the same way as {@code takeSkillLevel} and {@code removeSkillLevel}, it basically loops the removing the skill level
	 * and it is modified by some incomprehensible black magic.
	 */
	public static void resetSkill() {
		int currentCharacterLevel = characterBuild.getCurrentLevel();
		int currentSkillLevel = characterBuild.getSkills()[currentSkill.getId()].getCurrentLevel();
		int perkPointsTaken = characterBuild.getSkills()[currentSkill.getId()].getTakenPerkCount();
		characterBuild.setPerksAvailable(characterBuild.getPerksAvailable() + perkPointsTaken);
		characterBuild.getSkills()[currentSkill.getId()].resetSkill();
		int targetSkillLevel = characterBuild.getSkills()[currentSkill.getId()].getCurrentLevel();
		
		while(currentSkillLevel > targetSkillLevel) {
			double gainXP =  getXPGain(currentSkillLevel, BuildConstants.SKILL_XP_MULTS[currentSkill.getId()]);
			double currentXP = characterBuild.getCurrentXP() - gainXP;
			
			if(currentXP < 0) {
				int perksAvailable = characterBuild.getPerksAvailable();
				int perksGain = characterBuild.getPerkCntAtLevelUp()[currentCharacterLevel - 1];
				currentXP = getLevelUpXP(currentCharacterLevel - 1) + currentXP;
				characterBuild.setCurrentXP(currentXP);
				characterBuild.setCurrentLevel(currentCharacterLevel - 1);
				currentCharacterLevel = characterBuild.getCurrentLevel();
				characterBuild.setPerksAvailable(perksAvailable - perksGain);
			}
			else {
				characterBuild.setCurrentXP(currentXP);
			}
			
			currentSkillLevel--;
		}
		
		displayStatus();
	}
	
	/**
	 * Method, which handles taking perk level process. It finds perk's instance from passed {@code perkIndex} value.
	 * Then it checks for skill level requirement of respective perk level, if the level is not high enough, alert may be displayed informing the user.
	 * If it is, then level is taken, unless the method {@code takeLevel} from {@code Perk} class returns false (in that case another alert may be displayed).
	 * Amoun of perk points available is then decremented by 1.
	 * @param perkIndex	index of the perk, which the level is being invested in
	 */
	public static void takePerkLevel(int perkIndex) {
		Perk selectedPerk = characterBuild.getSkills()[currentSkill.getId()].getPerks()[perkIndex];
		int currentSkillLevel = characterBuild.getSkills()[currentSkill.getId()].getCurrentLevel();
		int perkLevel = selectedPerk.getLevelsTaken();
		int reqSkillLevel = 0;
		
		if(perkLevel < selectedPerk.getSkillLevels().length) {
			reqSkillLevel = selectedPerk.getSkillLevels()[perkLevel];
		}
		 
		if(currentSkillLevel >= reqSkillLevel) {
			boolean result = selectedPerk.takeLevel();
			
			if(!result && warningStatus) {
				displayAlert(AlertType.INFORMATION, 
						"Perk level increase alert", 
						"All available levels already taken:", 
						"You have already taken all available levels of the perk.");
			}
			else {
				characterBuild.setPerksAvailable(characterBuild.getPerksAvailable() - 1);
			}
		}
		else {
			if(warningStatus) {
				displayAlert(AlertType.INFORMATION, 
						"Perk level increase alert", 
						"Skill level not high enough:", 
						"This perk (or its currently chosen level) requires higher skill level.");
			}
		}
		
		displayStatus();
	}
	
	/**
	 * Method, which handles removing perk level process. It finds perk's instance from passed {@code perkIndex} value.
	 * Unless there is no level taken yet in this perk, the last level invested is removed and amount of perk points
	 * available is incremented by 1.
	 * @param perkIndex	index of the perk, which the level is being remove from
	 */
	public static void removePerkLevel(int perkIndex) {
		Perk selectedPerk = characterBuild.getSkills()[currentSkill.getId()].getPerks()[perkIndex];
		boolean result = selectedPerk.removeLevel();
		
		if(!result && warningStatus) {
			displayAlert(AlertType.INFORMATION, 
					"Perk level decrease alert", 
					"No levels taken yet:", 
					"You have not taken any level in the perk.");
		}
		else {
			characterBuild.setPerksAvailable(characterBuild.getPerksAvailable() + 1);
		}
		
		displayStatus();
	}
	
	/**
	 * Method, which stores passed {@code String} into build's notes.
	 * @param notes	notes to be saved
	 */
	public static void saveBuildNotes(String notes) {
		characterBuild.setBuildNotes(notes);
	}
	
	/**
	 * Method that is called from various other methods of controller. It passes all relevant values from the model to view objects,
	 * which can then display them.
	 */
	private static void displayStatus() {
		//displaying values in left pane
		leftPane.setLevelValue(characterBuild.getCurrentLevel());
		leftPane.setPerksValue(characterBuild.getPerksAvailable());
		leftPane.setHealthValue(characterBuild.getCurrentHealth());
		leftPane.setMagickaValue(characterBuild.getCurrentMagicka());
		leftPane.setStaminaValue(characterBuild.getCurrentStamina());
		leftPane.setNotesText(characterBuild.getBuildNotes());
		
		//setting the values for combo boxes on general tab
		RaceEnum race = characterBuild.getRace();
		GenderEnum gender = characterBuild.getGender();
		SpecializationEnum spec = characterBuild.getSpecialization();
		PrimaryAttrEnum primAttr = characterBuild.getPrimaryAttribute();
		SecondaryAttrEnum secAttr = characterBuild.getSecondaryAttribute();
		BirthsignEnum birthsign = characterBuild.getBirthsign();
		
		//creating record lists for tables on development tabs and getting current skill level
		int skillLevel = characterBuild.getSkills()[currentSkill.getId()].getCurrentLevel();
		List<PerkRec> perks = createPerkRecList(characterBuild.getSkills()[currentSkill.getId()].getPerks());
		List<AttributeRec> attributes = createAttrRecList(characterBuild.getAttributes());
		
		//passing values to center pane tabs
		centerPane.setGeneralTabValues(race, gender, spec, primAttr, secAttr, birthsign);
		centerPane.setSkillTabValues(currentSkill, skillLevel, perks);
		centerPane.setAttrDistribTabList(attributes);
	}
	
	/**
	 * Method that calculates how many perk points will be awarded per main level gained.
	 * The numbers are saved into an array, which belongs to {@code characterBuild} instance for later use.
	 * Basically the index of the array means the character level.
	 */
	private static void createPerkCntLevelUps() {
		double sum = 0.0;
		int index = 0;
		
		characterBuild.getPerkCntAtLevelUp()[0] = 0;
		
		for(int i = 1; i < characterBuild.getPerkCntAtLevelUp().length; i++) {
			if(index < (BuildConstants.PERK_LEVELUPS.length - 1)) {
				if(i >= BuildConstants.PERK_LEVELUPS[index + 1][0]) {
					index++;
				}
			}
			
			sum += BuildConstants.PERK_LEVELUPS[index][1];
			characterBuild.getPerkCntAtLevelUp()[i] = (int)sum;
			sum = sum - (int)sum;
		}
	}
	
	/**
	 * Method that calculates how much will get primary attribute increased per individual character level.
	 * The numbers are saved into an array, which belongs to {@code characterBuild} instance for later use.
	 * Basically the index of the array means the character level.
	 */
	private static void createAttrGainsLevelUps() {
		int index = 0;
		
		characterBuild.getAttributeGainAtLevelUp()[0] = 0;
		
		for(int i = 1; i < characterBuild.getAttributeGainAtLevelUp().length; i++) {
			if(index < (BuildConstants.ATTRIBUTE_LEVELUPS.length - 1)) {
				if(i >= BuildConstants.ATTRIBUTE_LEVELUPS[index + 1][0]) {
					index++;
				}
			}
			
			characterBuild.getAttributeGainAtLevelUp()[i] = BuildConstants.ATTRIBUTE_LEVELUPS[index][1];
		}
	}	
	
	/**
	 * Method that an array of perks and makes them into list of {@code PerkRec} instances that can be displayed on table of perks.
	 * @param perks	array with perks from the {@code Skill} instance
	 * @return	list of {@code PerkRec} instances, which can be displayed by perk table
	 */
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
	
	/**
	 * Method that an array of attribute increases and makes them into list of {@code AttributeRec} instances
	 * that can be displayed on table of attribute distribution.
	 * @param attributes	array with attribute increases from the {@code Skill} instance
	 * @return	list of {@code AttributeRec} instances, which can be displayed by attribute distribution table
	 */
	private static List<AttributeRec> createAttrRecList(Attribute[] attributes) {
		List<AttributeRec> attrRecList = new ArrayList<>();
		
		for(int i = 0; i < attributes.length; i++) {
			if(attributes[i] != null) {
				attrRecList.add(new AttributeRec(i+1, attributes[i].getAttribute().getLabel(), attributes[i].getGain()));
			}
		}
		
		return attrRecList;
	}
	
	/**
	 * Method with formula for calculation of experience points gain given the skill level and skill XP modifier.
	 * @param skillLevel	skill level, for which the XP gain should be calculated
	 * @param skillXPMod	modifier for XP gain for certain skill
	 * @return	experience points gain
	 */
	private static double getXPGain(int skillLevel, double skillXPMod) {
		return (skillLevel * skillXPMod);
	}
	
	/**
	 * Method with formula for calculation of experience points needed to level up the character from current level.
	 * @param currentLevel	current character level
	 * @return	experience points needed to level up
	 */
	private static double getLevelUpXP(int currentLevel) {
		return (currentLevel + 3) * 25;
	}
	
	/**
	 * Method that displays the alert with text passed from input parameters. It returns the {@code ButtonType}, which user clicked on.
	 * @param alertType		type of the alert
	 * @param title			title of the alert
	 * @param headerText	header text of the alert
	 * @param contentText	content text of the alert
	 * @return	type of the button, which the user clicked on
	 */
	private static ButtonType displayAlert(AlertType alertType, String title, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		
		ButtonType buttonType = alert.showAndWait().get();
		return buttonType;
	}
}
