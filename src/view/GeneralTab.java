package view;

import app.Controller;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.BirthsignEnum;
import staticData.GenderEnum;
import staticData.PrimaryAttrEnum;
import staticData.RaceEnum;
import staticData.SecondaryAttrEnum;
import staticData.SpecializationEnum;

public class GeneralTab extends Tab {
	
	private static final int COMPONENT_PADDING = 10;
	
	private static final int GRID_HGAP = 50;
	private static final int GRID_VGAP = 10;
	private static final int COMBO_BOX_WIDTH = 150;
	private static final int BTTN_WIDTH = 150;
	private static final int BTTN_HEIGHT = 35;
	
	
	private static final String TAB_LABEL = "GENERAL";
	private static final String ATTR_PANE_LABEL = "Attributes";
	private static final String INFO_PANE_LABEL = "Details";
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
		this.setContent(new HBox(createAttributesPane(), createInfoBox()));
		this.setDisable(true);
	}
	
	private Node createAttributesPane() {
		GridPane attributesPane = new GridPane();
		attributesPane.setPadding(new Insets(COMPONENT_PADDING));
		attributesPane.setHgap(GRID_HGAP);
		attributesPane.setVgap(GRID_VGAP);
		
		Label boxLabel = new Label(ATTR_PANE_LABEL);
		
		Label raceLabel = new Label(RaceEnum.LABEL);
		raceComboBox = new ComboBox<>();
		raceComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		raceComboBox.getItems().setAll(RaceEnum.values());
		raceComboBox.setValue(RaceEnum.ALTMER);
		raceComboBox.setOnAction(event -> changeInfoAction(raceComboBox.getValue().getDescription()));
		
		Label genderLabel = new Label(GenderEnum.LABEL);
		genderComboBox = new ComboBox<>();
		genderComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		genderComboBox.getItems().setAll(GenderEnum.values());
		genderComboBox.setValue(GenderEnum.MALE);
		genderComboBox.setOnAction(event -> changeInfoAction(genderComboBox.getValue().getDescription()));
		
		Label specLabel = new Label(SpecializationEnum.LABEL);
		specComboBox = new ComboBox<>();
		specComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		specComboBox.getItems().setAll(SpecializationEnum.values());
		specComboBox.setValue(SpecializationEnum.COMBAT);
		specComboBox.setOnAction(event -> changeInfoAction(specComboBox.getValue().getDescription()));
		
		Label primAttrLabel = new Label(PrimaryAttrEnum.LABEL);
		primAttrComboBox = new ComboBox<>();
		primAttrComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		primAttrComboBox.getItems().setAll(PrimaryAttrEnum.values());
		primAttrComboBox.setValue(PrimaryAttrEnum.HEALTH);
		primAttrComboBox.setOnAction(event -> changeInfoAction(primAttrComboBox.getValue().getDescription()));
		
		Label secAttrLabel = new Label(SecondaryAttrEnum.LABEL);
		secAttrComboBox = new ComboBox<>();
		secAttrComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		secAttrComboBox.getItems().setAll(SecondaryAttrEnum.values());
		secAttrComboBox.setValue(SecondaryAttrEnum.STRENGTH);
		secAttrComboBox.setOnAction(event -> changeInfoAction(secAttrComboBox.getValue().getDescription()));
		
		Label birthsignLabel = new Label(BirthsignEnum.LABEL);
		birthsignComboBox = new ComboBox<>();
		birthsignComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		birthsignComboBox.getItems().setAll(BirthsignEnum.values());
		birthsignComboBox.setValue(BirthsignEnum.APPRENTICE);
		birthsignComboBox.setOnAction(event -> changeInfoAction(birthsignComboBox.getValue().getDescription()));
		
		confirmButt = new Button(CONF_BUTT_LABEL);
		confirmButt.setOnAction(event -> confirmAction());
		confirmButt.setPrefSize(BTTN_WIDTH, BTTN_HEIGHT);
		
		resetButt = new Button(RES_BUTT_LABEL);
		resetButt.setOnAction(event -> resetAction());
		resetButt.setPrefSize(BTTN_WIDTH, BTTN_HEIGHT);
		
		attributesPane.add(boxLabel, 0, 0);
		attributesPane.add(raceLabel, 0, 1);
		attributesPane.add(raceComboBox, 1, 1);
		attributesPane.add(genderLabel, 0, 2);
		attributesPane.add(genderComboBox, 1, 2);
		attributesPane.add(specLabel, 0, 3);
		attributesPane.add(specComboBox, 1, 3);
		attributesPane.add(primAttrLabel, 0, 4);
		attributesPane.add(primAttrComboBox, 1, 4);
		attributesPane.add(secAttrLabel, 0, 5);
		attributesPane.add(secAttrComboBox, 1, 5);
		attributesPane.add(birthsignLabel, 0, 6);
		attributesPane.add(birthsignComboBox, 1, 6);
		attributesPane.add(confirmButt, 0, 7);
		attributesPane.add(resetButt, 0, 8);
		
		return attributesPane;
	}
	
	private Node createInfoBox() {
		VBox skillBox = new VBox();
		skillBox.setPadding(new Insets(COMPONENT_PADDING));
		
		Label boxLabel = new Label(INFO_PANE_LABEL);
		
		infoArea = new TextArea("");
		infoArea.setEditable(false);
		skillBox.getChildren().addAll(boxLabel, infoArea);
		
		return skillBox;
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
