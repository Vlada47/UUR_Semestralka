package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.BuildConstants;
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
	
	private Label skillLabel;
	private TextField levelField;
	private TableView<PerkRec> perkTable;
	private ObservableList<PerkRec> perkList;
	
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
		
		tableBox.getChildren().addAll(skillLabel, levelField, createTable());
		
		return tableBox;
	}
	
	private TableView<PerkRec> createTable() {
		perkList = createDefaultPerkList();
		
		perkTable = new TableView<PerkRec>();
		perkTable.setEditable(false);
		
		TableColumn<PerkRec, String> titleCol = new TableColumn<PerkRec, String>(TITLE_COL);
		titleCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("title"));
		
		TableColumn<PerkRec, String> reqCol = new TableColumn<PerkRec, String>(REQ_COL);
		reqCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("reqPerks"));
		
		TableColumn<PerkRec, String> curLvlCol = new TableColumn<PerkRec, String>(CURLVL_COL);
		curLvlCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("currLevel"));
		
		TableColumn<PerkRec, String> maxLvlCol = new TableColumn<PerkRec, String>(MAXLVL_COL);
		maxLvlCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("maxLevel"));
		
		perkTable.getColumns().setAll(titleCol, reqCol, curLvlCol, maxLvlCol);
		perkTable.setItems(perkList);
		
		return perkTable;
	}
	
	private ObservableList<PerkRec> createDefaultPerkList() {
		perkList = FXCollections.observableArrayList();
		
		perkList.add(new PerkRec("Perk 1", "...", 0, 2));
		perkList.add(new PerkRec("Perk 2", "...", 0, 1));
		perkList.add(new PerkRec("Perk 3", "...", 0, 1));
		perkList.add(new PerkRec("Perk 4", "...", 0, 3));
		perkList.add(new PerkRec("Perk 5", "...", 0, 2));
		perkList.add(new PerkRec("Perk 6", "...", 0, 1));
		perkList.add(new PerkRec("Perk 7", "...", 0, 2));
		perkList.add(new PerkRec("Perk 8", "...", 0, 2));
		perkList.add(new PerkRec("Perk 9", "...", 0, 3));
		perkList.add(new PerkRec("Perk 10", "...", 0, 1));
		
		return perkList;
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
