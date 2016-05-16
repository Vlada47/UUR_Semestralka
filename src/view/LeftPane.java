package view;

import app.Controller;
import app.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import staticData.BuildConstants;
import staticData.PrimaryAttrEnum;

/**
 * Instance of this class represents application's left pane displaying basic character status,
 * information like current health, level or perk points available.
 * @author Vlada47
 *
 */
public class LeftPane extends VBox {
	
	private static final int MAIN_PANE_WIDTH = 350;
	private static final int MAIN_PANE_SPACING = 25;
	private static final int MAIN_PANE_PADDING = 10;
	
	private static final int GRID_HGAP = 50;
	private static final int GRID_VGAP = 10;
	private static final int INFO_PANE_PADDING = 5;
	private static final int FIELDS_WIDTH = 100;
	private static final int FIELDS_PADDING_TOP = 5;
	private static final int FIELDS_PADDING_RIGHT = 0;
	private static final int FIELDS_PADDING_BOTTOM = 5;
	private static final int FIELDS_PADDING_LEFT = 10;
	
	private static final int EXTENSION_PADDING = 5;
	private static final int EXTENSION_SPACING = 20;
	private static final int NOTES_ROW_CNT = 12;
	private static final int SAVE_BTTN_WIDTH = 150;
	private static final int SAVE_BTTN_HEIGHT = 35;
	
	private static final String LEVEL_LABEL = "Character level:";
	private static final String PERK_LABEL = "Perk points available:";
	private static final String DEFAULT_NOTES = "Notes...";
	private static final String NOTES_BTTN_TEXT = "Save notes";
	
	/**
	 * {@code TextField} displaying current character level.
	 */
	private TextField levelValueField;
	
	/**
	 * {@code TextField} displaying current number of perk points available.
	 */
	private TextField perksValueField;
	
	/**
	 * {@code TextField} displaying current amount of health.
	 */
	private TextField healthValueField;
	
	/**
	 * {@code TextField} displaying current amount of magicka.
	 */
	private TextField magickaValueField;
	
	/**
	 * {@code TextField} displaying current amount of stamina.
	 */
	private TextField staminaValueField;
	
	/**
	 * {@code TextArea} containing user's notes.
	 */
	private TextArea notesArea;
	
	/**
	 * Button with event for saving user's notes.
	 */
	private Button saveNotesBttn;
	
	/**
	 * Constructor of the {@code LeftPane} class. It calls constructor of the {@code VBox} class,
	 * sets basic parameters and then adds elements via respective methods.
	 */
	public LeftPane() {
		super();
		this.setPrefWidth(MAIN_PANE_WIDTH);
		this.setSpacing(MAIN_PANE_SPACING);
		this.setPadding(new Insets(MAIN_PANE_PADDING));
		this.setStyle(Main.MAIN_PANE_BORDER_STYLE);
		this.getChildren().addAll(createGeneralInfoPane(), createExtensionPane());
	}
	
	/**
	 * Method creating sub-pane with informative text fields and labels identifying them.
	 * @return	a node with informative text fields
	 */
	private Node createGeneralInfoPane() {
		GridPane generalInfoPane = new GridPane();
		generalInfoPane.setHgap(GRID_HGAP);
		generalInfoPane.setVgap(GRID_VGAP);
		generalInfoPane.setPadding(new Insets(INFO_PANE_PADDING));
		generalInfoPane.setStyle(Main.INNER_PANE_BORDER_STYLE);
		
		Label levelLabel = new Label(LEVEL_LABEL);
		levelLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		levelValueField = new TextField("1");
		levelValueField.setEditable(false);
		levelValueField.setDisable(true);
		levelValueField.setPrefWidth(FIELDS_WIDTH);
		levelValueField.setPadding(new Insets(FIELDS_PADDING_TOP, FIELDS_PADDING_RIGHT, FIELDS_PADDING_BOTTOM, FIELDS_PADDING_LEFT));
		
		Label perksLabel = new Label(PERK_LABEL);
		perksLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		perksValueField = new TextField("0");
		perksValueField.setEditable(false);
		perksValueField.setDisable(true);
		perksValueField.setPrefWidth(FIELDS_WIDTH);
		perksValueField.setPadding(new Insets(FIELDS_PADDING_TOP, FIELDS_PADDING_RIGHT, FIELDS_PADDING_BOTTOM, FIELDS_PADDING_LEFT));
		
		Label healthLabel = new Label(PrimaryAttrEnum.HEALTH.getLabel()+":");
		healthLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		healthValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		healthValueField.setEditable(false);
		healthValueField.setDisable(true);
		healthValueField.setPrefWidth(FIELDS_WIDTH);
		healthValueField.setPadding(new Insets(FIELDS_PADDING_TOP, FIELDS_PADDING_RIGHT, FIELDS_PADDING_BOTTOM, FIELDS_PADDING_LEFT));
		
		Label magickaLabel = new Label(PrimaryAttrEnum.MAGICKA.getLabel()+":");
		magickaLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		magickaValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		magickaValueField.setEditable(false);
		magickaValueField.setDisable(true);
		magickaValueField.setPrefWidth(FIELDS_WIDTH);
		magickaValueField.setPadding(new Insets(FIELDS_PADDING_TOP, FIELDS_PADDING_RIGHT, FIELDS_PADDING_BOTTOM, FIELDS_PADDING_LEFT));
		
		Label staminaLabel = new Label(PrimaryAttrEnum.STAMINA.getLabel()+":");
		staminaLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		staminaValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		staminaValueField.setEditable(false);
		staminaValueField.setDisable(true);
		staminaValueField.setPrefWidth(FIELDS_WIDTH);
		staminaValueField.setPadding(new Insets(FIELDS_PADDING_TOP, FIELDS_PADDING_RIGHT, FIELDS_PADDING_BOTTOM, FIELDS_PADDING_LEFT));
		
		generalInfoPane.add(levelLabel, 0, 0);
		generalInfoPane.add(levelValueField, 1, 0);
		generalInfoPane.add(perksLabel, 0, 1);
		generalInfoPane.add(perksValueField, 1, 1);
		generalInfoPane.add(healthLabel, 0, 2);
		generalInfoPane.add(healthValueField, 1, 2);
		generalInfoPane.add(magickaLabel, 0, 3);
		generalInfoPane.add(magickaValueField, 1, 3);
		generalInfoPane.add(staminaLabel, 0, 4);
		generalInfoPane.add(staminaValueField, 1, 4);
		return generalInfoPane;
	}
	
	/**
	 * Method creating the sub-pane with {@code TextArea} for user's notes and button for saving them to data model.
	 * @return	a node with elements handling user's notes
	 */
	private Node createExtensionPane() {
		VBox extensionPane = new VBox();
		extensionPane.setAlignment(Pos.CENTER);
		extensionPane.setSpacing(EXTENSION_SPACING);
		extensionPane.setPadding(new Insets(EXTENSION_PADDING));
		extensionPane.setStyle(Main.INNER_PANE_BORDER_STYLE);
		
		notesArea = new TextArea("");
		notesArea.setDisable(true);
		notesArea.setWrapText(true);
		notesArea.setPrefRowCount(NOTES_ROW_CNT);
		notesArea.setPromptText(DEFAULT_NOTES);
		
		saveNotesBttn = new Button(NOTES_BTTN_TEXT);
		saveNotesBttn.setStyle(Main.BUTTON_LABEL_STYLE);
		saveNotesBttn.setOnAction(event -> Controller.saveBuildNotes(notesArea.getText()));
		saveNotesBttn.setDisable(true);
		saveNotesBttn.setPrefSize(SAVE_BTTN_WIDTH, SAVE_BTTN_HEIGHT);
		
		extensionPane.getChildren().addAll(notesArea, saveNotesBttn);
		return extensionPane;
	}
	
	/**
	 * Setter for the text of {@code levelValueField} instance.
	 * @param value	value for the respective text field
	 */
	public void setLevelValue(int value) {
		levelValueField.setText(Integer.toString(value));
	}
	
	/**
	 * Setter for the text of {@code perksValueField} instance.
	 * @param value	value for the respective text field
	 */
	public void setPerksValue(int value) {
		perksValueField.setText(Integer.toString(value));
	}
	
	/**
	 * Setter for the text of {@code healthValueField} instance.
	 * @param value	value for the respective text field
	 */
	public void setHealthValue(int value) {
		healthValueField.setText(Integer.toString(value));
	}
	
	/**
	 * Setter for the text of {@code magickaValueField} instance.
	 * @param value	value for the respective text field
	 */
	public void setMagickaValue(int value) {
		magickaValueField.setText(Integer.toString(value));
	}
	
	/**
	 * Setter for the text of {@code staminaValueField} instance.
	 * @param value	value for the respective text field
	 */
	public void setStaminaValue(int value) {
		staminaValueField.setText(Integer.toString(value));
	}
	
	/**
	 * Setter for the text of the {@code TextArea} for user's notes.
	 * @param value	user's notes
	 */
	public void setNotesText(String text) {
		notesArea.setText(text);
	}
	
	/**
	 * Method disabling/enabling individual text fields.
	 * @param disable	true/false
	 */
	public void setTextFieldsDisable(boolean disable) {
		levelValueField.setDisable(disable);
		perksValueField.setDisable(disable);
		healthValueField.setDisable(disable);
		magickaValueField.setDisable(disable);
		staminaValueField.setDisable(disable);
	}
	
	/**
	 * Method disabling/enabling elements handling user's notes.
	 * @param disable	true/false
	 */
	public void setExtensionPaneDisable(boolean disable) {
		notesArea.setDisable(disable);
		saveNotesBttn.setDisable(disable);
	}
}
