package view;

import java.util.List;

import app.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.BuildConstants;
import staticData.SkillEnum;
import view.recordObjects.PerkRec;

public class SkillTab extends Tab {
	
	private static final String TAB_LABEL = "SKILLS & PERKS";
	private static final String DEF_SKILL_TITLE = "Skill Title";
	private static final String BUTT_PLUS = "+";
	private static final String BUTT_MINUS = "-";
	private static final String RES_BUTT_LABEL = "Reset";
	private static final String TITLE_COL = "Title";
	private static final String REQ_COL = "Prerequisite perks";
	private static final String CURLVL_COL = "Current level";
	private static final String MAXLVL_COL = "Maximal level";
	private static final String SKILLLVL_COL = "Skill levels";
	
	private Label skillLabel;
	private TextField levelField;
	private TableView<PerkRec> perkTable;
	private ObservableList<PerkRec> perkList;
	private ComboBox<SkillEnum> skillBox;
	
	public SkillTab() {
		super();
		this.setText(TAB_LABEL);
		this.setContent(new HBox(createTableBox(), createButtonBox()));
		this.setDisable(true);
	}
	
	private VBox createTableBox() {
		VBox tableBox = new VBox();
		
		skillLabel = new Label(DEF_SKILL_TITLE);
		levelField = new TextField(Integer.toString(BuildConstants.MIN_SKILL_LEVEL));
		levelField.setEditable(false);
		
		tableBox.getChildren().addAll(skillLabel, levelField, createTable());
		
		return tableBox;
	}
	
	private TableView<PerkRec> createTable() {
		perkList = createDefaultPerkList();
		
		perkTable = new TableView<PerkRec>();
		perkTable.setEditable(false);
		
		perkTable.setRowFactory(value -> {
			TableRow<PerkRec> row = new TableRow<>();
			row.setOnMouseClicked(event -> rowClickAction(event, row));
			return row;
		});
		
		TableColumn<PerkRec, String> titleCol = new TableColumn<PerkRec, String>(TITLE_COL);
		titleCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("title"));
		
		TableColumn<PerkRec, String> reqCol = new TableColumn<PerkRec, String>(REQ_COL);
		reqCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("reqPerks"));
		
		TableColumn<PerkRec, String> curLvlCol = new TableColumn<PerkRec, String>(CURLVL_COL);
		curLvlCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("currLevel"));
		
		TableColumn<PerkRec, String> maxLvlCol = new TableColumn<PerkRec, String>(MAXLVL_COL);
		maxLvlCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("maxLevel"));
		
		TableColumn<PerkRec, String> skillLvlCol = new TableColumn<PerkRec, String>(SKILLLVL_COL);
		skillLvlCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("skillLevels"));
		
		perkTable.getColumns().setAll(titleCol, reqCol, curLvlCol, maxLvlCol, skillLvlCol);
		perkTable.setItems(perkList);
		
		return perkTable;
	}
	
	private ObservableList<PerkRec> createDefaultPerkList() {
		perkList = FXCollections.observableArrayList();
		
		perkList.add(new PerkRec(-1, "Perk 1", "...", 0, 1, "0"));
		perkList.add(new PerkRec(-1, "Perk 2", "...", 0, 1, "0"));
		perkList.add(new PerkRec(-1, "Perk 3", "...", 0, 1, "0"));
		perkList.add(new PerkRec(-1, "Perk 4", "...", 0, 1, "0"));
		perkList.add(new PerkRec(-1, "Perk 5", "...", 0, 1, "0"));
		perkList.add(new PerkRec(-1, "Perk 6", "...", 0, 1, "0"));
		perkList.add(new PerkRec(-1, "Perk 7", "...", 0, 1, "0"));
		perkList.add(new PerkRec(-1, "Perk 8", "...", 0, 1, "0"));
		perkList.add(new PerkRec(-1, "Perk 9", "...", 0, 1, "0"));
		perkList.add(new PerkRec(-1, "Perk 10", "...", 0, 1, "0"));
		
		return perkList;
	}
	
	private VBox createButtonBox() {
		VBox buttonBox = new VBox();
		
		skillBox = new ComboBox<>();
		skillBox.getItems().setAll(SkillEnum.values());
		skillBox.setValue(SkillEnum.ILLUSION);
		skillBox.setOnAction(event -> Controller.changeSkill(skillBox.getValue()));
		
		Button levelPlusButt = new Button(BUTT_PLUS);
		levelPlusButt.setOnAction(event -> Controller.takeSkillLevel());
		
		Button levelMinusButt = new Button(BUTT_MINUS);
		levelMinusButt.setOnAction(event -> Controller.removeSkillLevel());
		
		Button skillResetButt = new Button(RES_BUTT_LABEL);
		skillResetButt.setOnAction(event -> Controller.resetSkill());
		
		buttonBox.getChildren().addAll(skillBox, levelPlusButt, levelMinusButt, skillResetButt);
		return buttonBox;
	}
	
	private void rowClickAction(MouseEvent event, TableRow<PerkRec> row) {
		int perkIndex = row.getItem().getIndex();
		
		if(event.getClickCount() == 2) {
			Controller.takePerkLevel(perkIndex);
		}
		else if(event.getClickCount() == 1 && event.isControlDown()){
			Controller.removePerkLevel(perkIndex);
		}
	}
	
	public void setCurrentSkill(SkillEnum skill) {
		skillBox.setValue(skill);
		skillLabel.setText(skill.getLabel());
	}
	
	public void setCurrentSkillLevel(int level) {
		levelField.setText(Integer.toString(level));
	}
	
	public void setPerkList(List<PerkRec> perkList) {
		this.perkList.setAll(perkList);
	}
}
