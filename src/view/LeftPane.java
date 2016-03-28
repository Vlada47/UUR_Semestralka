package view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.BuildConstants;
import staticData.PrimaryAttrEnum;

public class LeftPane extends VBox {
	
	private static final int INFO_PANE_SPACING = 10;
	private static final int ATTRIBUTE_FIELDS_SPACING = 20;
	
	private VBox generalInfoPane;
	private TextField levelValueField;
	private TextField perksValueField;
	private TextField healthValueField;
	private TextField magickaValueField;
	private TextField staminaValueField;
	private TextField weightValueField;
	
	private VBox extensionPane;
	
	public LeftPane() {
		super();
		
		this.getChildren().addAll(createGeneralInfoPane(), createExtensionPane());
	}
	
	private VBox createGeneralInfoPane() {
		generalInfoPane = new VBox(INFO_PANE_SPACING);
		
		levelValueField = new TextField("1");
		levelValueField.setDisable(true);
		perksValueField = new TextField("0");
		perksValueField.setDisable(true);
		healthValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		healthValueField.setDisable(true);
		magickaValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		magickaValueField.setDisable(true);
		staminaValueField = new TextField(Integer.toString(BuildConstants.ATTRIBUTE_BASE));
		staminaValueField.setDisable(true);
		weightValueField = new TextField(Integer.toString(BuildConstants.CARRY_WEIGHT_BASE));
		weightValueField.setDisable(true);
		
		HBox levelBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label("Level"), levelValueField);
		HBox perksBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label("Perk Points"), perksValueField);
		HBox healthBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label(PrimaryAttrEnum.HEALTH.getLabel()), healthValueField);
		HBox magickaBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label(PrimaryAttrEnum.MAGICKA.getLabel()), magickaValueField);
		HBox staminaBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label(PrimaryAttrEnum.STAMINA.getLabel()), staminaValueField);
		HBox weightBox = new HBox(ATTRIBUTE_FIELDS_SPACING, new Label("Carry Weight"), weightValueField);
		
		generalInfoPane.getChildren().addAll(levelBox, perksBox, healthBox, magickaBox, staminaBox, weightBox);
		
		return generalInfoPane;
	}
	
	private VBox createExtensionPane() {
		extensionPane = new VBox();
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
	
	public void setWightValue(int value) {
		weightValueField.setText(Integer.toString(value));
	}
}
