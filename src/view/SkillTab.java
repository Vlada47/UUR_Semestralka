package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.BuildConstants;

public class SkillTab extends Tab {
	
	private static final String TAB_LABEL = "SKILLS & PERKS";
	private static final String DEF_SKILL_TITLE = "Skill Title";
	private static final String BUTT_PLUS = "+";
	private static final String BUTT_MINUS = "-";
	private static final String RES_BUTT_LABEL = "Reset";
	
	private Label skillLabel;
	private TextField levelField;
	
	public SkillTab() {
		super();
		this.setText(TAB_LABEL);
		this.setContent(new HBox(createTableBox(), createButtonBox()));
	}
	
	private VBox createTableBox() {
		VBox tableBox = new VBox();
		
		skillLabel = new Label(DEF_SKILL_TITLE);
		levelField = new TextField(Integer.toString(BuildConstants.MIN_SKILL_LEVEL));
		levelField.setDisable(true);
		
		tableBox.getChildren().addAll(skillLabel, levelField);
		
		return tableBox;
	}
	
	private VBox createButtonBox() {
		VBox buttonBox = new VBox();
		
		Button levelPlusButt = new Button(BUTT_PLUS);
		Button levelMinusButt = new Button(BUTT_MINUS);
		Button skillResetButt = new Button(RES_BUTT_LABEL);
		buttonBox.getChildren().addAll(levelPlusButt, levelMinusButt, skillResetButt);
		
		return buttonBox;
	}
}
