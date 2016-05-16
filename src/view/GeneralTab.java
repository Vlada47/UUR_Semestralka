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

/**
 * Instance of this class represents a tab with general character creation functionality.
 * @author Vlada47
 *
 */
public class GeneralTab extends Tab {
	
	private static final int COMPONENT_PADDING = 10;
	
	private static final int GRID_HGAP = 50;
	private static final int GRID_VGAP = 10;
	private static final int COMBO_BOX_WIDTH = 150;
	private static final int BTTN_WIDTH = 150;
	private static final int BTTN_HEIGHT = 35;
	
	private static final int DETAIL_BOX_SPACING = 20;
	private static final int DETAIL_AREA_ROWS = 25;
	
	private static final String TAB_LABEL = "GENERAL";
	private static final String PROP_PANE_LABEL = "Properties";
	private static final String INFO_PANE_LABEL = "Details";
	private static final String CONF_BUTT_LABEL = "Confirm";
	private static final String RES_BUTT_LABEL = "Reset";
	
	/**
	 * {@code ComboBox} for the character's race choice.
	 */
	private ComboBox<RaceEnum> raceComboBox;
	
	/**
	 * {@code ComboBox} for the character's gender choice.
	 */
	private ComboBox<GenderEnum> genderComboBox;
	
	/**
	 * {@code ComboBox} for the character's specialization choice.
	 */
	private ComboBox<SpecializationEnum> specComboBox;
	
	/**
	 * {@code ComboBox} for the character's primary attribute choice.
	 */
	private ComboBox<PrimaryAttrEnum> primAttrComboBox;
	
	/**
	 * {@code ComboBox} for the character's secondary attribute choice.
	 */
	private ComboBox<SecondaryAttrEnum> secAttrComboBox;
	
	/**
	 * {@code ComboBox} for the character's birthsign choice.
	 */
	private ComboBox<BirthsignEnum> birthsignComboBox;
	
	/**
	 * Button confirming selected choices.
	 */
	private Button confirmButt;
	
	/**
	 * Button reseting character building.
	 */
	private Button resetButt;
	
	/**
	 * {@code TextArea} displaying information about selected choices.
	 */
	private TextArea infoArea;
	
	/**
	 * Constructor of the {@code GeneralTab} class. It calls the constructor of the {@code Tab} class,
	 * sets the label of the tab and the content of the tab via respective methods. The tab starts as disabled.
	 */
	public GeneralTab() {
		super();
		this.setText(TAB_LABEL);
		this.setContent(new HBox(createPropertiesPane(), createInfoBox()));
		this.setDisable(true);
	}
	
	/**
	 * Method creating a component (node) with combo boxes for selecting character creation choices and buttons for confirming/reseting the character build.
	 * Combo boxes are given initial value and event, which refreshes information about all choices. 
	 * @return	a node with control elements
	 */
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
		raceComboBox.setOnAction(event -> changeInfoAction());
		
		Label genderLabel = new Label(GenderEnum.LABEL);
		genderLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		
		genderComboBox = new ComboBox<>();
		genderComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		genderComboBox.getItems().setAll(GenderEnum.values());
		genderComboBox.setValue(GenderEnum.MALE);
		genderComboBox.setOnAction(event -> changeInfoAction());
		
		Label specLabel = new Label(SpecializationEnum.LABEL);
		specLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		
		specComboBox = new ComboBox<>();
		specComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		specComboBox.getItems().setAll(SpecializationEnum.values());
		specComboBox.setValue(SpecializationEnum.COMBAT);
		specComboBox.setOnAction(event -> changeInfoAction());
		
		Label primAttrLabel = new Label(PrimaryAttrEnum.LABEL);
		primAttrLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		
		primAttrComboBox = new ComboBox<>();
		primAttrComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		primAttrComboBox.getItems().setAll(PrimaryAttrEnum.values());
		primAttrComboBox.setValue(PrimaryAttrEnum.HEALTH);
		primAttrComboBox.setOnAction(event -> changeInfoAction());
		
		Label secAttrLabel = new Label(SecondaryAttrEnum.LABEL);
		secAttrLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		
		secAttrComboBox = new ComboBox<>();
		secAttrComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		secAttrComboBox.getItems().setAll(SecondaryAttrEnum.values());
		secAttrComboBox.setValue(SecondaryAttrEnum.STRENGTH);
		secAttrComboBox.setOnAction(event -> changeInfoAction());
		
		Label birthsignLabel = new Label(BirthsignEnum.LABEL);
		birthsignLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		
		birthsignComboBox = new ComboBox<>();
		birthsignComboBox.setPrefWidth(COMBO_BOX_WIDTH);
		birthsignComboBox.getItems().setAll(BirthsignEnum.values());
		birthsignComboBox.setValue(BirthsignEnum.APPRENTICE);
		birthsignComboBox.setOnAction(event -> changeInfoAction());
		
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
	
	/**
	 * Method creating a component with {@code TextArea} containing information about character creation choices.
	 * @return	a node containing the {@code TextArea}
	 */
	private Node createInfoBox() {
		VBox infoBox = new VBox();
		infoBox.setPadding(new Insets(COMPONENT_PADDING));
		infoBox.setSpacing(DETAIL_BOX_SPACING);
		
		Label detailLabel = new Label(INFO_PANE_LABEL);
		detailLabel.setStyle(Main.PRIMARY_LABEL_STYLE);
		
		infoArea = new TextArea("");
		infoArea.setEditable(false);
		infoArea.setWrapText(true);
		infoArea.setPrefRowCount(DETAIL_AREA_ROWS);
		changeInfoAction();
		infoBox.getChildren().addAll(detailLabel, infoArea);
		
		return infoBox;
	}
	
	/**
	 * Method handling the event, when pressing the button for confirmation of choices.
	 * It sets selected values to the data model, disables control elements on this tab
	 * and enables other tabs.
	 */
	private void confirmAction() {
		Controller.setBuildBase(raceComboBox.getValue(), genderComboBox.getValue(), specComboBox.getValue(), primAttrComboBox.getValue(), secAttrComboBox.getValue(), birthsignComboBox.getValue());
		Controller.setGeneralTabControlDisable(true);
		Controller.setDevelopmentTabsDisable(false);
	}
	
	/**
	 * Method handling the event, when pressing the button for reseting the values of character build.
	 * It calls the {@code confirmBuildReset} method and if case the return is true it enables
	 * the control elements of this tab and disables other tabs. The build is then cleared.
	 */
	private void resetAction() {
		if(Controller.confirmBuildReset()) {
			Controller.setDevelopmentTabsDisable(true);
			Controller.setGeneralTabControlDisable(false);
			Controller.clearBuild();
		}
	}
	
	/**
	 * Method handling the enabling/disabling of control elements of this tab. 
	 * @param disable	true/false
	 */
	public void setControlDisable(boolean disable) {
		raceComboBox.setDisable(disable);
		genderComboBox.setDisable(disable);
		specComboBox.setDisable(disable);
		primAttrComboBox.setDisable(disable);
		secAttrComboBox.setDisable(disable);
		birthsignComboBox.setDisable(disable);
		confirmButt.setDisable(disable);
	}
	
	/**
	 * Method handling the event on individual combo boxes, when changing the value.
	 * It creates a {@code String} with information about selected choices and passes it
	 * to respective {@code TextArea}.
	 */
	private void changeInfoAction() {
		String info = raceComboBox.getValue().getLabel()+":\n"
					+ raceComboBox.getValue().getDescription() + "\n\n"
					+ genderComboBox.getValue().getLabel()+":\n"
					+ genderComboBox.getValue().getDescription() + "\n\n"
					+ specComboBox.getValue().getLabel()+":\n"
					+ specComboBox.getValue().getDescription() + "\n\n"
					+ primAttrComboBox.getValue().getLabel()+":\n"
					+ primAttrComboBox.getValue().getDescription() + "\n\n"
					+ secAttrComboBox.getValue().getLabel()+":\n"
					+ secAttrComboBox.getValue().getDescription() + "\n\n"
					+ birthsignComboBox.getValue().getLabel()+":\n"
					+ birthsignComboBox.getValue().getDescription();
		
		infoArea.setText(info);
	}
	
	/**
	 * Setter for the value on {@code raceComboBox} instance.
	 * @param race	selected race
	 */
	public void setRaceValue(RaceEnum race) {
		raceComboBox.setValue(race);
	}
	
	/**
	 * Setter for the value on {@code genderComboBox} instance.
	 * @param gender	selected gender
	 */
	public void setGenderValue(GenderEnum gender) {
		genderComboBox.setValue(gender);
	}
	
	/**
	 * Setter for the value on {@code specComboBox} instance.
	 * @param spec	selected specialization
	 */
	public void setSpecValue(SpecializationEnum spec) {
		specComboBox.setValue(spec);
	}
	
	/**
	 * Setter for the value on {@code primAttrComboBox} instance.
	 * @param primAttr	selected primary attribute
	 */
	public void setPrimAttrValue(PrimaryAttrEnum primAttr) {
		primAttrComboBox.setValue(primAttr);
	}
	
	/**
	 * Setter for the value on {@code secAttrComboBox} instance.
	 * @param secAttr	selected secondary attribute
	 */
	public void setSecAttrValue(SecondaryAttrEnum secAttr) {
		secAttrComboBox.setValue(secAttr);
	}
	
	/**
	 * Setter for the value on {@code birthsignComboBox} instance.
	 * @param birthsign	selected birthsign
	 */
	public void setBirthsignValue(BirthsignEnum birthsign) {
		birthsignComboBox.setValue(birthsign);
	}
}
