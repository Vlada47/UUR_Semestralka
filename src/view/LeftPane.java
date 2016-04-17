package view;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.BuildConstants;
import staticData.PrimaryAttrEnum;

public class LeftPane extends VBox {
	
	private static final int PANEL_WIDTH = 300;
	private static final int INFO_PANE_SPACING = 10;
	private static final int ATTRIBUTE_FIELDS_SPACING = 20;
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
		this.setPrefWidth(PANEL_WIDTH);
		this.getChildren().addAll(createGeneralInfoPane(), createExtensionPane());
	}
	
	private VBox createGeneralInfoPane() {
		VBox generalInfoPane = new VBox(INFO_PANE_SPACING);
		
		levelValueField = new TextField("1");
		levelValueField.setEditable(false);
		levelValueField.setDisable(true);
		
		perksValueField = new TextField("0");
		perksValueField.setEditable(false);
		perksValueField.setDisable(true);
		
		healthValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		healthValueField.setEditable(false);
		healthValueField.setDisable(true);
		
		magickaValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		magickaValueField.setEditable(false);
		magickaValueField.setDisable(true);
		
		staminaValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		staminaValueField.setEditable(false);
		staminaValueField.setDisable(true);
		
		HBox levelBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label("Level"), levelValueField);
		HBox perksBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label("Perk Points"), perksValueField);
		HBox healthBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label(PrimaryAttrEnum.HEALTH.getLabel()), healthValueField);
		HBox magickaBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label(PrimaryAttrEnum.MAGICKA.getLabel()), magickaValueField);
		HBox staminaBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label(PrimaryAttrEnum.STAMINA.getLabel()), staminaValueField);
		
		generalInfoPane.getChildren().addAll(levelBox, perksBox, healthBox, magickaBox, staminaBox);
		
		return generalInfoPane;
	}
	
	private VBox createExtensionPane() {
		VBox extensionPane = new VBox();
		notesArea = new TextArea(DEFAULT_NOTES);
		notesArea.setDisable(true);
		saveNotesBttn = new Button(NOTES_BTTN_TEXT);
		saveNotesBttn.setOnAction(event -> Controller.saveBuildNotes(notesArea.getText()));
		saveNotesBttn.setDisable(true);
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
