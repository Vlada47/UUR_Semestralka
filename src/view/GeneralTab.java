package view;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
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
	private static final String INFO_BOX_LABEL = "Details";
	private static final String CONF_BUTT_LABEL = "Confirm";
	private static final String RES_BUTT_LABEL = "Reset";
	
	private ComboBox<RaceEnum> raceComboBox;
	private ComboBox<GenderEnum> genderComboBox;
	private ComboBox<SpecializationEnum> specComboBox;
	private ComboBox<PrimaryAttrEnum> primAttrComboBox;
	private ComboBox<SecondaryAttrEnum> secAttrComboBox;
	private ComboBox<BirthsignEnum> birthsignComboBox;
	private Button confirmButt;
	private Button resetButt;
	TextArea infoArea;
	
	public GeneralTab() {
		super();
		this.setText(TAB_LABEL);
		this.setContent(new HBox(new VBox(createAttributesBox(), createButtonBox()), createInfoBox()));
		this.setDisable(true);
	}
	
	private VBox createAttributesBox() {
		VBox attributesVBox = new VBox();
		
		Label boxLabel = new Label(ATTR_BOX_LABEL);
		
		HBox raceBox = new HBox();
		Label raceLabel = new Label(RaceEnum.LABEL);
		raceComboBox = new ComboBox<>();
		raceComboBox.getItems().setAll(RaceEnum.values());
		raceComboBox.setValue(RaceEnum.ALTMER);
		raceComboBox.setOnAction(event -> changeInfoAction(raceComboBox.getValue().getDescription()));
		raceBox.getChildren().addAll(raceLabel, raceComboBox);
		
		HBox genderBox = new HBox();
		Label genderLabel = new Label(GenderEnum.LABEL);
		genderComboBox = new ComboBox<>();
		genderComboBox.getItems().setAll(GenderEnum.values());
		genderComboBox.setValue(GenderEnum.MALE);
		genderComboBox.setOnAction(event -> changeInfoAction(genderComboBox.getValue().getDescription()));
		genderBox.getChildren().addAll(genderLabel, genderComboBox);
		
		HBox specBox = new HBox();
		Label specLabel = new Label(SpecializationEnum.LABEL);
		specComboBox = new ComboBox<>();
		specComboBox.getItems().setAll(SpecializationEnum.values());
		specComboBox.setValue(SpecializationEnum.COMBAT);
		specComboBox.setOnAction(event -> changeInfoAction(specComboBox.getValue().getDescription()));
		specBox.getChildren().addAll(specLabel, specComboBox);
		
		HBox primAttrBox = new HBox();
		Label primAttrLabel = new Label(PrimaryAttrEnum.LABEL);
		primAttrComboBox = new ComboBox<>();
		primAttrComboBox.getItems().setAll(PrimaryAttrEnum.values());
		primAttrComboBox.setValue(PrimaryAttrEnum.HEALTH);
		primAttrComboBox.setOnAction(event -> changeInfoAction(primAttrComboBox.getValue().getDescription()));
		primAttrBox.getChildren().addAll(primAttrLabel, primAttrComboBox);
		
		HBox secAttrBox = new HBox();
		Label secAttrLabel = new Label(SecondaryAttrEnum.LABEL);
		secAttrComboBox = new ComboBox<>();
		secAttrComboBox.getItems().setAll(SecondaryAttrEnum.values());
		secAttrComboBox.setValue(SecondaryAttrEnum.STRENGTH);
		secAttrComboBox.setOnAction(event -> changeInfoAction(secAttrComboBox.getValue().getDescription()));
		secAttrBox.getChildren().addAll(secAttrLabel, secAttrComboBox);
		
		HBox birthsignBox = new HBox();
		Label birthsignLabel = new Label(BirthsignEnum.LABEL);
		birthsignComboBox = new ComboBox<>();
		birthsignComboBox.getItems().setAll(BirthsignEnum.values());
		birthsignComboBox.setValue(BirthsignEnum.APPRENTICE);
		birthsignComboBox.setOnAction(event -> changeInfoAction(birthsignComboBox.getValue().getDescription()));
		birthsignBox.getChildren().addAll(birthsignLabel, birthsignComboBox);
		
		attributesVBox.getChildren().addAll(boxLabel, raceBox, genderBox, specBox, primAttrBox, secAttrBox, birthsignBox);
		
		return attributesVBox;
	}
	
	private VBox createInfoBox() {
		VBox skillBox = new VBox();
		
		Label boxLabel = new Label(INFO_BOX_LABEL);
		infoArea = new TextArea("");
		infoArea.setEditable(false);
		skillBox.getChildren().addAll(boxLabel, infoArea);
		
		return skillBox;
	}
	
	private VBox createButtonBox() {
		VBox buttonBox = new VBox();
		
		confirmButt = new Button(CONF_BUTT_LABEL);
		confirmButt.setOnAction(event -> confirmAction());
		resetButt = new Button(RES_BUTT_LABEL);
		resetButt.setOnAction(event -> resetAction());
		buttonBox.getChildren().addAll(confirmButt, resetButt);
		
		return buttonBox;
	}
	
	private void confirmAction() {
		Controller.setBuildBase(raceComboBox.getValue(), genderComboBox.getValue(), specComboBox.getValue(), primAttrComboBox.getValue(), secAttrComboBox.getValue(), birthsignComboBox.getValue());
		raceComboBox.setDisable(true);
		genderComboBox.setDisable(true);
		specComboBox.setDisable(true);
		primAttrComboBox.setDisable(true);
		secAttrComboBox.setDisable(true);
		birthsignComboBox.setDisable(true);
		confirmButt.setDisable(true);
		Controller.setDevelopmentTabsDisable(false);
	}
	
	private void resetAction() {
		Controller.setDevelopmentTabsDisable(true);
		Controller.clearBuild();
		raceComboBox.setDisable(false);
		genderComboBox.setDisable(false);
		specComboBox.setDisable(false);
		primAttrComboBox.setDisable(false);
		secAttrComboBox.setDisable(false);
		birthsignComboBox.setDisable(false);
		confirmButt.setDisable(false);
	}
	
	private void changeInfoAction(String text) {
		infoArea.setText(text);
	}
	
	public void setRaceValue(RaceEnum race) {
		raceComboBox.setValue(race);
	}
	
	public void setGenderValue(GenderEnum gender) {
		genderComboBox.setValue(gender);
	}
	
	public void setSpecValue(SpecializationEnum spec) {
		specComboBox.setValue(spec);
	}
	
	public void setPrimAttrValue(PrimaryAttrEnum primAttr) {
		primAttrComboBox.setValue(primAttr);
	}
	
	public void setSecAttrValue(SecondaryAttrEnum secAttr) {
		secAttrComboBox.setValue(secAttr);
	}
	
	public void setBirthsignValue(BirthsignEnum birthsign) {
		birthsignComboBox.setValue(birthsign);
	}
}
