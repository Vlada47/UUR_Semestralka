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

public class LeftPane extends VBox {
	
	private static final int MAIN_PANE_WIDTH = 350;
	private static final int MAIN_PANE_SPACING = 50;
	private static final int MAIN_PANE_PADDING = 10;
	
	private static final int INFO_PANE_PADDING = 5;
	private static final int FIELDS_WIDTH = 135;
	private static final int FIELDS_PADDING_TOP = 5;
	private static final int FIELDS_PADDING_RIGHT = 0;
	private static final int FIELDS_PADDING_BOTTOM = 5;
	private static final int FIELDS_PADDING_LEFT = 10;
	private static final int GRID_HGAP = 50;
	private static final int GRID_VGAP = 10;
	
	private static final int EXTENSION_PADDING = 5;
	private static final int EXTENSION_SPACING = 20;
	private static final int NOTES_ROW_CNT = 20;
	private static final int SAVE_BTTN_WIDTH = 150;
	private static final int SAVE_BTTN_HEIGHT = 35;
	
	private static final String LEVEL_LABEL = "Character level:";
	private static final String PERK_LABEL = "Perk points available:";
	private static final String DEFAULT_NOTES = "Notes...";
	private static final String NOTES_BTTN_TEXT = "Save notes";
	
	private TextField levelValueField;
	private TextField perksValueField;
	private TextField healthValueField;
	private TextField magickaValueField;
	private TextField staminaValueField;
	private TextArea notesArea;
	private Button saveNotesBttn;
	
	public LeftPane() {
		super();
		this.setPrefWidth(MAIN_PANE_WIDTH);
		this.setSpacing(MAIN_PANE_SPACING);
		this.setPadding(new Insets(MAIN_PANE_PADDING));
		this.setStyle(Main.MAIN_PANE_BORDER_STYLE);
		this.getChildren().addAll(createGeneralInfoPane(), createExtensionPane());
	}
	
	private Node createGeneralInfoPane() {
		GridPane generalInfoPane = new GridPane();
		generalInfoPane.setHgap(GRID_HGAP);
		generalInfoPane.setVgap(GRID_VGAP);
		generalInfoPane.setPadding(new Insets(INFO_PANE_PADDING));
		generalInfoPane.setStyle(Main.INNER_PANE_BORDER_STYLE);
		
		levelValueField = new TextField("1");
		levelValueField.setEditable(false);
		levelValueField.setDisable(true);
		levelValueField.setPrefWidth(FIELDS_WIDTH);
		levelValueField.setPadding(new Insets(FIELDS_PADDING_TOP, FIELDS_PADDING_RIGHT, FIELDS_PADDING_BOTTOM, FIELDS_PADDING_LEFT));
		
		perksValueField = new TextField("0");
		perksValueField.setEditable(false);
		perksValueField.setDisable(true);
		perksValueField.setPrefWidth(FIELDS_WIDTH);
		perksValueField.setPadding(new Insets(FIELDS_PADDING_TOP, FIELDS_PADDING_RIGHT, FIELDS_PADDING_BOTTOM, FIELDS_PADDING_LEFT));
		
		healthValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		healthValueField.setEditable(false);
		healthValueField.setDisable(true);
		healthValueField.setPrefWidth(FIELDS_WIDTH);
		healthValueField.setPadding(new Insets(FIELDS_PADDING_TOP, FIELDS_PADDING_RIGHT, FIELDS_PADDING_BOTTOM, FIELDS_PADDING_LEFT));
		
		magickaValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		magickaValueField.setEditable(false);
		magickaValueField.setDisable(true);
		magickaValueField.setPrefWidth(FIELDS_WIDTH);
		magickaValueField.setPadding(new Insets(FIELDS_PADDING_TOP, FIELDS_PADDING_RIGHT, FIELDS_PADDING_BOTTOM, FIELDS_PADDING_LEFT));
		
		staminaValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		staminaValueField.setEditable(false);
		staminaValueField.setDisable(true);
		staminaValueField.setPrefWidth(FIELDS_WIDTH);
		staminaValueField.setPadding(new Insets(FIELDS_PADDING_TOP, FIELDS_PADDING_RIGHT, FIELDS_PADDING_BOTTOM, FIELDS_PADDING_LEFT));
		
		generalInfoPane.add(new Label(LEVEL_LABEL), 0, 0);
		generalInfoPane.add(levelValueField, 1, 0);
		generalInfoPane.add(new Label(PERK_LABEL), 0, 1);
		generalInfoPane.add(perksValueField, 1, 1);
		generalInfoPane.add(new Label(PrimaryAttrEnum.HEALTH.getLabel()), 0, 2);
		generalInfoPane.add(healthValueField, 1, 2);
		generalInfoPane.add(new Label(PrimaryAttrEnum.MAGICKA.getLabel()), 0, 3);
		generalInfoPane.add(magickaValueField, 1, 3);
		generalInfoPane.add(new Label(PrimaryAttrEnum.STAMINA.getLabel()), 0, 4);
		generalInfoPane.add(staminaValueField, 1, 4);
		return generalInfoPane;
	}
	
	private Node createExtensionPane() {
		VBox extensionPane = new VBox();
		extensionPane.setAlignment(Pos.CENTER);
		extensionPane.setSpacing(EXTENSION_SPACING);
		extensionPane.setPadding(new Insets(EXTENSION_PADDING));
		extensionPane.setStyle(Main.INNER_PANE_BORDER_STYLE);
		
		notesArea = new TextArea(DEFAULT_NOTES);
		notesArea.setDisable(true);
		notesArea.setPrefRowCount(NOTES_ROW_CNT);
		
		saveNotesBttn = new Button(NOTES_BTTN_TEXT);
		saveNotesBttn.setOnAction(event -> Controller.saveBuildNotes(notesArea.getText()));
		saveNotesBttn.setDisable(true);
		saveNotesBttn.setPrefSize(SAVE_BTTN_WIDTH, SAVE_BTTN_HEIGHT);
		
		extensionPane.getChildren().addAll(notesArea, saveNotesBttn);
		return extensionPane;
	}
	
	public void setLevelValue(int value) {
		levelValueField.setText(Integer.toString(value));
	}
	
	public void setPerksValue(int value) {
		perksValueField.setText(Integer.toString(value));
	}
	
	public void setHealthValue(int value) {
		healthValueField.setText(Integer.toString(value));
	}
	
	public void setMagickaValue(int value) {
		magickaValueField.setText(Integer.toString(value));
	}
	
	public void setStaminaValue(int value) {
		staminaValueField.setText(Integer.toString(value));
	}
	
	public void setNotesText(String text) {
		notesArea.setText(text);
	}
	
	public void setTextFieldsDisable(boolean disable) {
		levelValueField.setDisable(disable);
		perksValueField.setDisable(disable);
		healthValueField.setDisable(disable);
		magickaValueField.setDisable(disable);
		staminaValueField.setDisable(disable);
	}
	
	public void setExtensionPaneDisable(boolean disable) {
		notesArea.setDisable(disable);
		saveNotesBttn.setDisable(disable);
	}
}
