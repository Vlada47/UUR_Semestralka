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

public class CenterPane extends TabPane {
	
	private static final int MAIN_PANE_WIDTH = 750;
	private static final int MAIN_PANE_PADDING = 10;
	
	private final GeneralTab generalTab;
	private final SkillTab skillTab;
	private final AttrDistribTab attrDistribTab;
	
	public CenterPane() {
		super();
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.setPrefWidth(MAIN_PANE_WIDTH);
		this.setPadding(new Insets(MAIN_PANE_PADDING));
		this.setStyle(Main.MAIN_PANE_BORDER_STYLE);
		
		generalTab = new GeneralTab();
		skillTab = new SkillTab();
		attrDistribTab = new AttrDistribTab();
		
		this.getTabs().addAll(generalTab, skillTab, attrDistribTab);
	}
	
	public void setGeneralTabDisable(boolean disable) {
		generalTab.setDisable(disable);
	}
	
	public void setSkillTabDisable(boolean disable) {
		skillTab.setDisable(disable);
	}
	
	public void setAttrDistribTabDisable(boolean disable) {
		attrDistribTab.setDisable(disable);
	}
	
	public void setGeneralTabValues(RaceEnum race, GenderEnum gender, SpecializationEnum specialization, PrimaryAttrEnum primaryAttr, SecondaryAttrEnum secondaryAttrEnum, BirthsignEnum birthsign) {
		generalTab.setRaceValue(race);
		generalTab.setGenderValue(gender);
		generalTab.setSpecValue(specialization);
		generalTab.setPrimAttrValue(primaryAttr);
		generalTab.setSecAttrValue(secondaryAttrEnum);
		generalTab.setBirthsignValue(birthsign);
	}
	
	public void setSkillTabValues(SkillEnum skill, int skillLevel, List<PerkRec> perkList) {
		skillTab.setCurrentSkill(skill);
		skillTab.setCurrentSkillLevel(skillLevel);
		skillTab.setPerkList(perkList);
	}
	
	public void setAttrDistribTabList(List<AttributeRec> attributeList) {
		attrDistribTab.setAttributeList(attributeList);
	}
	

}
