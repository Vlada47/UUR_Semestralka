package view;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.BirthsignEnum;
import staticData.GenderEnum;
import staticData.PrimaryAttrEnum;
import staticData.RaceEnum;
import staticData.SecondaryAttrEnum;
import staticData.SpecializationEnum;

public class GeneralTab extends Tab {
	
	private static final String TAB_LABEL = "GENERAL";
	private static final String ATTR_BOX_LABEL = "Attributes";
	private static final String SKILL_BOX_LABEL = "Skills";
	private static final String RACE_LABEL = "Race";
	private static final String GENDER_LABEL = "Gender";
	private static final String SPEC_LABEL = "Specialization";
	private static final String PRIM_ATTR_LABEL = "Primary Attribute";
	private static final String SEC_ATTR_LABEL = "Secondary Attribute";
	private static final String BIRTHSIGN = "Birthsign";
	private static final String CONF_BUTT_LABEL = "Confirm";
	private static final String RES_BUTT_LABEL = "Reset";
	
	private ComboBox<RaceEnum> raceComboBox;
	private ComboBox<GenderEnum> genderComboBox;
	private ComboBox<SpecializationEnum> specComboBox;
	private ComboBox<PrimaryAttrEnum> primAttrComboBox;
	private ComboBox<SecondaryAttrEnum> secAttrComboBox;
	private ComboBox<BirthsignEnum> birthsignComboBox;
	
	public GeneralTab() {
		super();
		this.setText(TAB_LABEL);
		this.setContent(new HBox(new VBox(createAttributesBox(), createButtonBox()), createSkillBox()));
	}
	
	private VBox createAttributesBox() {
		VBox attributesVBox = new VBox();
		
		Label boxLabel = new Label(ATTR_BOX_LABEL);
		
		HBox raceBox = new HBox();
		Label raceLabel = new Label(RACE_LABEL);
		raceComboBox = new ComboBox<>();
		raceComboBox.getItems().setAll(RaceEnum.values());
		raceBox.getChildren().addAll(raceLabel, raceComboBox);
		
		HBox genderBox = new HBox();
		Label genderLabel = new Label(GENDER_LABEL);
		genderComboBox = new ComboBox<>();
		genderComboBox.getItems().setAll(GenderEnum.values());
		genderBox.getChildren().addAll(genderLabel, genderComboBox);
		
		HBox specBox = new HBox();
		Label specLabel = new Label(SPEC_LABEL);
		specComboBox = new ComboBox<>();
		specComboBox.getItems().setAll(SpecializationEnum.values());
		raceBox.getChildren().addAll(specLabel, specComboBox);
		
		HBox primAttrBox = new HBox();
		Label primAttrLabel = new Label(PRIM_ATTR_LABEL);
		primAttrComboBox = new ComboBox<>();
		primAttrComboBox.getItems().setAll(PrimaryAttrEnum.values());
		primAttrBox.getChildren().addAll(primAttrLabel, primAttrComboBox);
		
		HBox secAttrBox = new HBox();
		Label secAttrLabel = new Label(SEC_ATTR_LABEL);
		secAttrComboBox = new ComboBox<>();
		secAttrComboBox.getItems().setAll(SecondaryAttrEnum.values());
		secAttrBox.getChildren().addAll(secAttrLabel, secAttrComboBox);
		
		HBox birthsignBox = new HBox();
		Label birthsignLabel = new Label(BIRTHSIGN);
		birthsignComboBox = new ComboBox<>();
		birthsignComboBox.getItems().setAll(BirthsignEnum.values());
		birthsignBox.getChildren().addAll(birthsignLabel, birthsignComboBox);
		
		attributesVBox.getChildren().addAll(boxLabel, raceBox, genderBox, specBox, primAttrBox, secAttrBox, birthsignBox);
		
		return attributesVBox;
	}
	
	private VBox createSkillBox() {
		VBox skillBox = new VBox();
		
		Label boxLabel = new Label(SKILL_BOX_LABEL);
		
		skillBox.getChildren().addAll(boxLabel);
		
		return skillBox;
	}
	
	private VBox createButtonBox() {
		VBox buttonBox = new VBox();
		
		Button confirmButt = new Button(CONF_BUTT_LABEL);
		Button resetButt = new Button(RES_BUTT_LABEL);
		buttonBox.getChildren().addAll(confirmButt, resetButt);
		
		return buttonBox;
	}

}
