package view;

import java.util.List;

import app.Main;
import javafx.geometry.Insets;
import javafx.scene.control.TabPane;
import staticData.BirthsignEnum;
import staticData.GenderEnum;
import staticData.PrimaryAttrEnum;
import staticData.RaceEnum;
import staticData.SecondaryAttrEnum;
import staticData.SkillEnum;
import staticData.SpecializationEnum;
import view.recordObjects.AttributeRec;
import view.recordObjects.PerkRec;

/**
 * Instance of this class represents a pane with tabs containing individual main windows of the application.
 * @author Vlada47
 *
 */
public class CenterPane extends TabPane {
	
	private static final int MAIN_PANE_WIDTH = 750;
	private static final int MAIN_PANE_PADDING = 10;
	
	/**
	 * Instance of the {@code Tab} handling character creation.
	 */
	private final GeneralTab generalTab;
	
	/**
	 * Instance of the {@code Tab} handling skill leveling and perk points distribution.
	 */
	private final SkillTab skillTab;
	
	/**
	 * Instance of the {@code Tab} handling character attribute distribution.
	 */
	private final AttrDistribTab attrDistribTab;
	
	/**
	 * Constructor of the {@code CenterPane} class. It calls constructor of the {@code TabPane} class,
	 * sets necessary parameters and adds the tabs via respective methods.
	 */
	public CenterPane() {
		super();
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.setPrefWidth(MAIN_PANE_WIDTH);
		this.setPadding(new Insets(MAIN_PANE_PADDING));
		this.setStyle(Main.MAIN_PANE_BORDER_STYLE);
		
		generalTab = new GeneralTab();
		generalTab.setStyle(Main.TAB_LABEL_STYLE);
		
		skillTab = new SkillTab();
		skillTab.setStyle(Main.TAB_LABEL_STYLE);
		
		attrDistribTab = new AttrDistribTab();
		attrDistribTab.setStyle(Main.TAB_LABEL_STYLE);
		
		this.getTabs().addAll(generalTab, skillTab, attrDistribTab);
	}
	
	/**
	 * Method for enabling/disabling the general tab.
	 * @param disable	true/false
	 */
	public void setGeneralTabDisable(boolean disable) {
		generalTab.setDisable(disable);
	}
	
	/**
	 * Method for enabling/disabling the general tab's control elements only.
	 * @param disable	true/false
	 */
	public void setGeneralTabControlDisable(boolean disable) {
		generalTab.setControlDisable(disable);
	}
	
	/**
	 * Method for enabling/disabling the tab with skills and perks functionality.
	 * @param disable	true/false
	 */
	public void setSkillTabDisable(boolean disable) {
		skillTab.setDisable(disable);
	}
	
	/**
	 * Method for enabling/disabling the tab with attribute distribution functionality.
	 * @param disable	true/false
	 */
	public void setAttrDistribTabDisable(boolean disable) {
		attrDistribTab.setDisable(disable);
	}
	
	/**
	 * Method passing chosen general options during character creation to general tab.
	 * @param race					chosen race value
	 * @param gender				chosen gender value
	 * @param specialization		chosen specialization value
	 * @param primaryAttr			chosen primary attribute value
	 * @param secondaryAttrEnum		chosen secondary attribute value
	 * @param birthsign				chosen birthsign value
	 */
	public void setGeneralTabValues(RaceEnum race, GenderEnum gender, SpecializationEnum specialization, PrimaryAttrEnum primaryAttr, SecondaryAttrEnum secondaryAttrEnum, BirthsignEnum birthsign) {
		generalTab.setRaceValue(race);
		generalTab.setGenderValue(gender);
		generalTab.setSpecValue(specialization);
		generalTab.setPrimAttrValue(primaryAttr);
		generalTab.setSecAttrValue(secondaryAttrEnum);
		generalTab.setBirthsignValue(birthsign);
	}
	
	/**
	 * Method passing values to the tab with skills and perks functionality.
	 * @param skill			selected skill
	 * @param skillLevel	current skill level
	 * @param perkList		a list with {@code PerkRec} instances
	 */
	public void setSkillTabValues(SkillEnum skill, int skillLevel, List<PerkRec> perkList) {
		skillTab.setCurrentSkill(skill);
		skillTab.setCurrentSkillLevel(skillLevel);
		skillTab.setPerkList(perkList);
	}
	
	/**
	 * Method for passing new records to the table on the tab with attribute distribution.
	 * @param attributeList	a list with {@code AttributeRec} instances
	 */
	public void setAttrDistribTabList(List<AttributeRec> attributeList) {
		attrDistribTab.setAttributeList(attributeList);
	}
	

}
