package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.PrimaryAttrEnum;

public class AttrDistribTab extends Tab {
	
	private static final String TAB_LABEL = "ATTRIBUTES DISTRIBUTION";
	private static final String BUTT_PLUS = "+";
	private static final String BUTT_MINUS = "-";
	
	public AttrDistribTab() {
		super();
		this.setText(TAB_LABEL);
		this.setContent(new HBox(createButtonBox()));
	}
	
	private VBox createButtonBox() {
		VBox buttonBox = new VBox();
		
		HBox healthBox = new HBox();
		Label healthLabel = new Label(PrimaryAttrEnum.HEALTH.getLabel());
		Button healthPlusButt = new Button(BUTT_PLUS);
		Button healthMinusButt = new Button(BUTT_MINUS);
		healthBox.getChildren().addAll(healthLabel, healthPlusButt, healthMinusButt);
		
		HBox magickaBox = new HBox();
		Label magickaLabel = new Label(PrimaryAttrEnum.MAGICKA.getLabel());
		Button magickaPlusButt = new Button(BUTT_PLUS);
		Button magickaMinusButt = new Button(BUTT_MINUS);
		magickaBox.getChildren().addAll(magickaLabel, magickaPlusButt, magickaMinusButt);
		
		HBox staminaBox = new HBox();
		Label staminaLabel = new Label(PrimaryAttrEnum.STAMINA.getLabel());
		Button staminaPlusButt = new Button(BUTT_PLUS);
		Button staminaMinusButt = new Button(BUTT_MINUS);
		staminaBox.getChildren().addAll(staminaLabel, staminaPlusButt, staminaMinusButt);
		
		buttonBox.getChildren().addAll(healthBox, magickaBox, staminaBox);
		
		return buttonBox;
	}
}
