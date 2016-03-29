package view;

import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.PrimaryAttrEnum;
import view.recordObjects.AttributeRec;

public class AttrDistribTab extends Tab {
	
	private static final String TAB_LABEL = "ATTRIBUTES DISTRIBUTION";
	private static final String BUTT_PLUS = "+";
	private static final String BUTT_MINUS = "-";
	private static final String LEVEL_COL = "Level";
	private static final String ATTR_COL = "Attribute";
	private static final String GAIN_COL = "Gain";
	
	private int level;
	private TableView<AttributeRec> attributeTable;
	private ObservableList<AttributeRec> attributeList;
	private final Stack<AttributeRec> lastHealth;
	private final Stack<AttributeRec> lastMagicka;
	private final Stack<AttributeRec> lastStamina;
	
	public AttrDistribTab() {
		super();
		this.level = 1;
		this.lastHealth = new Stack<AttributeRec>();
		this.lastMagicka = new Stack<AttributeRec>();
		this.lastStamina = new Stack<AttributeRec>();
		this.setText(TAB_LABEL);
		this.setContent(new HBox(createButtonBox(), createTable()));
	}
	
	private VBox createButtonBox() {
		VBox buttonBox = new VBox();
		
		HBox healthBox = new HBox();
		Label healthLabel = new Label(PrimaryAttrEnum.HEALTH.getLabel());
		Button healthPlusButt = new Button(BUTT_PLUS);
		healthPlusButt.setOnAction(event -> plusHealth());
		Button healthMinusButt = new Button(BUTT_MINUS);
		healthMinusButt.setOnAction(event -> minusHealth());
		healthBox.getChildren().addAll(healthLabel, healthPlusButt, healthMinusButt);
		
		HBox magickaBox = new HBox();
		Label magickaLabel = new Label(PrimaryAttrEnum.MAGICKA.getLabel());
		Button magickaPlusButt = new Button(BUTT_PLUS);
		magickaPlusButt.setOnAction(event -> plusMagicka());
		Button magickaMinusButt = new Button(BUTT_MINUS);
		magickaMinusButt.setOnAction(event -> minusMagicka());
		magickaBox.getChildren().addAll(magickaLabel, magickaPlusButt, magickaMinusButt);
		
		HBox staminaBox = new HBox();
		Label staminaLabel = new Label(PrimaryAttrEnum.STAMINA.getLabel());
		Button staminaPlusButt = new Button(BUTT_PLUS);
		staminaPlusButt.setOnAction(event -> plusStamina());
		Button staminaMinusButt = new Button(BUTT_MINUS);
		staminaMinusButt.setOnAction(event -> minusStamina());
		staminaBox.getChildren().addAll(staminaLabel, staminaPlusButt, staminaMinusButt);
		
		buttonBox.getChildren().addAll(healthBox, magickaBox, staminaBox);
		
		return buttonBox;
	}
	
	private TableView<AttributeRec> createTable() {
		attributeList = FXCollections.observableArrayList();
		attributeList.add(new AttributeRec(1, "-", 0));
		
		attributeTable = new TableView<AttributeRec>();
		attributeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		attributeTable.setEditable(false);
		
		TableColumn<AttributeRec, Integer> levelCol = new TableColumn<AttributeRec, Integer>(LEVEL_COL);
		levelCol.setCellValueFactory(new PropertyValueFactory<AttributeRec, Integer>("level"));
		
		TableColumn<AttributeRec, Integer> attributeCol = new TableColumn<AttributeRec, Integer>(ATTR_COL);
		attributeCol.setCellValueFactory(new PropertyValueFactory<AttributeRec, Integer>("attribute"));
		
		TableColumn<AttributeRec, Integer> gainCol = new TableColumn<AttributeRec, Integer>(GAIN_COL);
		gainCol.setCellValueFactory(new PropertyValueFactory<AttributeRec, Integer>("gain"));
		
		attributeTable.getColumns().setAll(levelCol, attributeCol, gainCol);
		attributeTable.setItems(attributeList);
		
		return attributeTable;
	}
	
	private void plusHealth() {
		level++;
		lastHealth.push(new AttributeRec(level, PrimaryAttrEnum.HEALTH.getLabel(), 10));
		attributeList.add(lastHealth.peek());
	}
	
	private void plusMagicka() {
		level++;
		lastMagicka.push(new AttributeRec(level, PrimaryAttrEnum.MAGICKA.getLabel(), 10));
		attributeList.add(lastMagicka.peek());
	}
	
	private void plusStamina() {
		level++;
		lastStamina.push(new AttributeRec(level, PrimaryAttrEnum.STAMINA.getLabel(), 10));
		attributeList.add(lastStamina.peek());
	}
	
	private void minusHealth() {
		if(!lastHealth.isEmpty()) {
			attributeList.remove(lastHealth.pop());
			level--;
		}
	}
	
	private void minusMagicka() {
		if(!lastMagicka.isEmpty()) {
			attributeList.remove(lastMagicka.pop());
			level--;
		}
	}
	
	private void minusStamina() {
		if(!lastStamina.isEmpty()) {
			attributeList.remove(lastStamina.pop());
			level--;
		}
	}
}
