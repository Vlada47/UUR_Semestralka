package view;

import app.Controller;
import app.Main;
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
	
	private static final int DETAIL_BOX_SPACING = 20;
	
	private static final String TAB_LABEL = "GENERAL";
	private static final String PROP_PANE_LABEL = "Properties";
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
		this.setContent(new HBox(createPropertiesPane(), createInfoBox()));
		this.setDisable(true);
	}
	
	private Node createPropertiesPane() {
		GridPane propertiesPane = new GridPane();
		propertiesPane.setPadding(new Insets(COMPONENT_PADDING));
		propertiesPane.setHgap(GRID_HGAP);
		propertiesPane.setVgap(GRID_VGAP);
		
		Label mainLabel = new Label(PROP_PANE_LABEL);
		mainLabel.setStyle(Main.PRIMARY_LABEL_STYLE);
		
		Label raceLabel = new Label(RaceEnum.LABEL);
		raceLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		raceComboBox = new ComboBox<>();
		raceComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		raceComboBox.getItems().setAll(RaceEnum.values());
		raceComboBox.setValue(RaceEnum.ALTMER);
		raceComboBox.setOnAction(event -> changeInfoAction(raceComboBox.getValue().getDescription()));
		
		Label genderLabel = new Label(GenderEnum.LABEL);
		genderLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		genderComboBox = new ComboBox<>();
		genderComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		genderComboBox.getItems().setAll(GenderEnum.values());
		genderComboBox.setValue(GenderEnum.MALE);
		genderComboBox.setOnAction(event -> changeInfoAction(genderComboBox.getValue().getDescription()));
		
		Label specLabel = new Label(SpecializationEnum.LABEL);
		specLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		specComboBox = new ComboBox<>();
		specComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		specComboBox.getItems().setAll(SpecializationEnum.values());
		specComboBox.setValue(SpecializationEnum.COMBAT);
		specComboBox.setOnAction(event -> changeInfoAction(specComboBox.getValue().getDescription()));
		
		Label primAttrLabel = new Label(PrimaryAttrEnum.LABEL);
		primAttrLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		primAttrComboBox = new ComboBox<>();
		primAttrComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		primAttrComboBox.getItems().setAll(PrimaryAttrEnum.values());
		primAttrComboBox.setValue(PrimaryAttrEnum.HEALTH);
		primAttrComboBox.setOnAction(event -> changeInfoAction(primAttrComboBox.getValue().getDescription()));
		
		Label secAttrLabel = new Label(SecondaryAttrEnum.LABEL);
		secAttrLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		secAttrComboBox = new ComboBox<>();
		secAttrComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		secAttrComboBox.getItems().setAll(SecondaryAttrEnum.values());
		secAttrComboBox.setValue(SecondaryAttrEnum.STRENGTH);
		secAttrComboBox.setOnAction(event -> changeInfoAction(secAttrComboBox.getValue().getDescription()));
		
		Label birthsignLabel = new Label(BirthsignEnum.LABEL);
		birthsignLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		birthsignComboBox = new ComboBox<>();
		birthsignComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		birthsignComboBox.getItems().setAll(BirthsignEnum.values());
		birthsignComboBox.setValue(BirthsignEnum.APPRENTICE);
		birthsignComboBox.setOnAction(event -> changeInfoAction(birthsignComboBox.getValue().getDescription()));
		
		confirmButt = new Button(CONF_BUTT_LABEL);
		confirmButt.setStyle(Main.BUTTON_LABEL_STYLE);
		confirmButt.setOnAction(event -> confirmAction());
		confirmButt.setPrefSize(BTTN_WIDTH, BTTN_HEIGHT);
		
		resetButt = new Button(RES_BUTT_LABEL);
		resetButt.setStyle(Main.BUTTON_LABEL_STYLE);
		resetButt.setOnAction(event -> resetAction());
		resetButt.setPrefSize(BTTN_WIDTH, BTTN_HEIGHT);
		
		propertiesPane.add(mainLabel, 0, 0);
		propertiesPane.add(raceLabel, 0, 1);
		propertiesPane.add(raceComboBox, 1, 1);
		propertiesPane.add(genderLabel, 0, 2);
		propertiesPane.add(genderComboBox, 1, 2);
		propertiesPane.add(specLabel, 0, 3);
		propertiesPane.add(specComboBox, 1, 3);
		propertiesPane.add(primAttrLabel, 0, 4);
		propertiesPane.add(primAttrComboBox, 1, 4);
		propertiesPane.add(secAttrLabel, 0, 5);
		propertiesPane.add(secAttrComboBox, 1, 5);
		propertiesPane.add(birthsignLabel, 0, 6);
		propertiesPane.add(birthsignComboBox, 1, 6);
		propertiesPane.add(confirmButt, 0, 7);
		propertiesPane.add(resetButt, 0, 8);
		
		return propertiesPane;
	}
	
	private Node createInfoBox() {
		VBox infoBox = new VBox();
		infoBox.setPadding(new Insets(COMPONENT_PADDING));
		infoBox.setSpacing(DETAIL_BOX_SPACING);
		
		Label detailLabel = new Label(INFO_PANE_LABEL);
		detailLabel.setStyle(Main.PRIMARY_LABEL_STYLE);
		
		infoArea = new TextArea("");
		infoArea.setEditable(false);
		infoBox.getChildren().addAll(detailLabel, infoArea);
		
		return infoBox;
	}
	
	private void confirmAction() {
		Controller.setBuildBase(raceComboBox.getValue(), genderComboBox.getValue(), specComboBox.getValue(), primAttrComboBox.getValue(), secAttrComboBox.getValue(), birthsignComboBox.getValue());
		Controller.setGeneralTabControlDisable(true);
		Controller.setDevelopmentTabsDisable(false);
	}
	
	private void resetAction() {
		Controller.setDevelopmentTabsDisable(true);
		Controller.setGeneralTabControlDisable(false);
		Controller.clearBuild();
	}
	
	public void setControlDisable(boolean disable) {
		raceComboBox.setDisable(disable);
		genderComboBox.setDisable(disable);
		specComboBox.setDisable(disable);
		primAttrComboBox.setDisable(disable);
		secAttrComboBox.setDisable(disable);
		birthsignComboBox.setDisable(disable);
		confirmButt.setDisable(disable);
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
