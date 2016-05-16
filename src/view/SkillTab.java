package view;

import java.util.List;

import app.Controller;
import app.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.BuildConstants;
import staticData.SkillEnum;
import view.recordObjects.PerkRec;

/**
 * Instance of this class represents a tab handling skill leveling and perk points distribution functionality.
 * @author Vlada47
 *
 */
public class SkillTab extends Tab {
	
	private static final int COMPONENT_PADDING = 10;
	
	private static final int TABLE_BOX_SPACING = 20;
	private static final int TABLE_BOX_WIDTH = 700;
	private static final int TABLE_BOX_HEIGHT = 600;
	private static final int PERK_LABEL_COL_WIDTH = 200;
	private static final int PERK_REQ_COL_WIDTH = 250;
	private static final int PERK_CURLVL_COL_WIDTH = 50;
	private static final int PERK_MAXLVL_COL_WIDTH = 50;
	private static final int PERK_LEVELS_COL_WIDTH = 75;
	
	private static final int GRID_HGAP = 10;
	private static final int GRID_VGAP = 20;
	private static final int SKILL_COMBOBOX_WIDTH = 200;
	private static final int SKILL_LEVEL_BTTN_SIZE = 35;
	private static final int SKILL_RESET_BTTN_WIDTH = 150;
	private static final int SKILL_RESET_BTTN_HEIGHT = 35;
	
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
	
	/**
	 * {@code Label} with the name of currently chosen skill.
	 */
	private Label skillLabel;
	
	/**
	 * {@code TextField} with the level of currently chosen skill.
	 */
	private TextField levelField;
	
	/**
	 * {@code TableView} with perks of the currently chosen skill.
	 */
	private TableView<PerkRec> perkTable;
	
	/**
	 * A list with {@code PerkRec} instances representing individual perks in the table.
	 */
	private ObservableList<PerkRec> perkList;
	
	/**
	 * {@code ComboBox} for selection of currently displayed skill.
	 */
	private ComboBox<SkillEnum> skillBox;
	
	/**
	 * Constructor of the {@code SkillTab} class. It calls the constructor of the {@code Tab} class,
	 * sets its label and then adds elements via respective methods. The tab starts as disabled.
	 */
	public SkillTab() {
		super();
		this.setText(TAB_LABEL);
		this.setContent(new HBox(createTableBox(), createButtonPane()));
		this.setDisable(true);
	}
	
	/**
	 * Method creating a node with skill label, current skill level and the perk table (via {@code createTable} method).
	 * @return	a node with elements of the pane
	 */
	private Node createTableBox() {
		VBox tableBox = new VBox();
		tableBox.setPrefSize(TABLE_BOX_WIDTH, TABLE_BOX_HEIGHT);
		tableBox.setPadding(new Insets(COMPONENT_PADDING));
		tableBox.setSpacing(TABLE_BOX_SPACING);
		
		skillLabel = new Label(DEF_SKILL_TITLE);
		skillLabel.setStyle(Main.PRIMARY_LABEL_STYLE);
		
		levelField = new TextField(Integer.toString(BuildConstants.MIN_SKILL_LEVEL));
		levelField.setEditable(false);
		
		tableBox.getChildren().addAll(skillLabel, levelField, createTable());
		
		return tableBox;
	}
	
	/**
	 * Method creating the table with perks. It displays the strings from {@code PerkRec} class.
	 * @return	a table of perks
	 */
	private TableView<PerkRec> createTable() {
		perkList = FXCollections.observableArrayList();
		perkList.add(new PerkRec(-1, "Perk 1", "...", 0, 1, "0"));
		
		perkTable = new TableView<PerkRec>();
		perkTable.setEditable(false);
		
		perkTable.setRowFactory(value -> {
			TableRow<PerkRec> row = new TableRow<>();
			row.setOnMouseClicked(event -> rowClickAction(event, row));
			return row;
		});
		
		TableColumn<PerkRec, String> titleCol = new TableColumn<PerkRec, String>(TITLE_COL);
		titleCol.setPrefWidth(PERK_LABEL_COL_WIDTH);
		titleCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("title"));
		
		TableColumn<PerkRec, String> reqCol = new TableColumn<PerkRec, String>(REQ_COL);
		reqCol.setPrefWidth(PERK_REQ_COL_WIDTH);
		reqCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("reqPerks"));
		
		TableColumn<PerkRec, String> curLvlCol = new TableColumn<PerkRec, String>(CURLVL_COL);
		curLvlCol.setPrefWidth(PERK_CURLVL_COL_WIDTH);
		curLvlCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("currLevel"));
		
		TableColumn<PerkRec, String> maxLvlCol = new TableColumn<PerkRec, String>(MAXLVL_COL);
		maxLvlCol.setPrefWidth(PERK_MAXLVL_COL_WIDTH);
		maxLvlCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("maxLevel"));
		
		TableColumn<PerkRec, String> skillLvlCol = new TableColumn<PerkRec, String>(SKILLLVL_COL);
		skillLvlCol.setPrefWidth(PERK_LEVELS_COL_WIDTH);
		skillLvlCol.setCellValueFactory(new PropertyValueFactory<PerkRec, String>("skillLevels"));
		
		perkTable.getColumns().setAll(titleCol, reqCol, curLvlCol, maxLvlCol, skillLvlCol);
		perkTable.setItems(perkList);
		
		return perkTable;
	}
	
	/**
	 * Creates the node with control elements of this tab - {@code ComboBox} for skill selection,
	 * buttons for increasing/decreasing current skill level and button for reseting the skill to the starting state.
	 * @return	a node with control elements
	 */
	private Node createButtonPane() {
		GridPane buttonPane = new GridPane();
		buttonPane.setPadding(new Insets(COMPONENT_PADDING));
		buttonPane.setHgap(GRID_HGAP);
		buttonPane.setVgap(GRID_VGAP);
		
		skillBox = new ComboBox<>();
		skillBox.setPrefWidth(SKILL_COMBOBOX_WIDTH);
		skillBox.getItems().setAll(SkillEnum.values());
		skillBox.setValue(SkillEnum.ILLUSION);
		skillBox.setOnAction(event -> Controller.changeSkill(skillBox.getValue()));
		
		Button levelPlusButt = new Button(BUTT_PLUS);
		levelPlusButt.setPrefSize(SKILL_LEVEL_BTTN_SIZE, SKILL_LEVEL_BTTN_SIZE);
		levelPlusButt.setStyle(Main.BUTTON_LABEL_STYLE);
		levelPlusButt.setOnAction(event -> Controller.takeSkillLevel());
		
		Button levelMinusButt = new Button(BUTT_MINUS);
		levelMinusButt.setPrefSize(SKILL_LEVEL_BTTN_SIZE, SKILL_LEVEL_BTTN_SIZE);
		levelMinusButt.setStyle(Main.BUTTON_LABEL_STYLE);
		levelMinusButt.setOnAction(event -> Controller.removeSkillLevel());
		
		Button skillResetButt = new Button(RES_BUTT_LABEL);
		skillResetButt.setPrefSize(SKILL_RESET_BTTN_WIDTH, SKILL_RESET_BTTN_HEIGHT);
		skillResetButt.setStyle(Main.BUTTON_LABEL_STYLE);
		skillResetButt.setOnAction(event -> Controller.resetSkill());
		
		buttonPane.add(skillBox, 0, 0, 2, 1);
		buttonPane.add(levelPlusButt, 0, 1, 1, 1);
		buttonPane.add(levelMinusButt, 1, 1, 1, 1);
		buttonPane.add(skillResetButt, 0, 2, 2, 1);
		return buttonPane;
	}
	
	/**
	 * Method handling the event of clicking on perk table row. When the primary mouse button is pressed twice,
	 * the {@code takePerkLevel} method is called. When the secondary mouse button is pressed once,
	 * the {@code removePerkLevel} method is called. The respective perk ID is passed to those methods.
	 * @param event	mouse event
	 * @param row	the row, which was mouse event registered on
	 */
	private void rowClickAction(MouseEvent event, TableRow<PerkRec> row) {
		int perkIndex = row.getItem().getIndex();
		
		if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
			Controller.takePerkLevel(perkIndex);
		}
		else if(event.getButton() == MouseButton.SECONDARY && event.getClickCount() == 1){
			Controller.removePerkLevel(perkIndex);
		}
	}
	
	/**
	 * Method setting the currently displayed skill.
	 * @param skill	currently displayed skill
	 */
	public void setCurrentSkill(SkillEnum skill) {
		skillBox.setValue(skill);
		skillLabel.setText(skill.getLabel());
	}
	
	/**
	 * Method setting the level of currently displayed skill.
	 * @param level	level of the skill
	 */
	public void setCurrentSkillLevel(int level) {
		levelField.setText(Integer.toString(level));
	}
	
	/**
	 * Method setting new instances to list of perks for the perk table.
	 * @param perkList	list with new instances
	 */
	public void setPerkList(List<PerkRec> perkList) {
		this.perkList.setAll(perkList);
	}
}
