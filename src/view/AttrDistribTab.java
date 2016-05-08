package view;

import java.util.List;

import app.Controller;
import app.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import staticData.PrimaryAttrEnum;
import view.recordObjects.AttributeRec;

public class AttrDistribTab extends Tab {
	
	private static final int COMPONENT_PADDING = 20;
	
	private static final int GRID_HGAP = 10;
	private static final int GRID_VGAP = 20;
	private static final int ATTR_BTTN_SIZE = 35;
	
	private static final int TABLE_BOX_WIDTH = 300;
	private static final int TABLE_BOX_HEIGHT = 600;
	private static final int LEVEL_COL_WIDTH = 75;
	private static final int ATTR_COL_WIDTH = 150;
	private static final int GAIN_COL_WIDTH = 75;
	
	private static final String TAB_LABEL = "ATTRIBUTES DISTRIBUTION";
	private static final String BUTT_PLUS = "+";
	private static final String BUTT_MINUS = "-";
	private static final String LEVEL_COL = "Level";
	private static final String ATTR_COL = "Attribute";
	private static final String GAIN_COL = "Gain";
	
	private TableView<AttributeRec> attributeTable;
	private ObservableList<AttributeRec> attributeList;

	public AttrDistribTab() {
		super();
		this.setText(TAB_LABEL);
		this.setContent(new HBox(createButtonPane(), createTable()));
		this.setDisable(true);
	}
	
	private Node createButtonPane() {
		GridPane buttonPane = new GridPane();
		buttonPane.setPadding(new Insets(COMPONENT_PADDING));
		buttonPane.setHgap(GRID_HGAP);
		buttonPane.setVgap(GRID_VGAP);
		
		Label healthLabel = new Label(PrimaryAttrEnum.HEALTH.getLabel());
		healthLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		
		Button healthPlusButt = new Button(BUTT_PLUS);
		healthPlusButt.setPrefSize(ATTR_BTTN_SIZE, ATTR_BTTN_SIZE);
		healthPlusButt.setStyle(Main.BUTTON_LABEL_STYLE);
		healthPlusButt.setOnAction(event -> Controller.increaseAttribute(PrimaryAttrEnum.HEALTH));
		
		Button healthMinusButt = new Button(BUTT_MINUS);
		healthMinusButt.setPrefSize(ATTR_BTTN_SIZE, ATTR_BTTN_SIZE);
		healthMinusButt.setStyle(Main.BUTTON_LABEL_STYLE);
		healthMinusButt.setOnAction(event -> Controller.decreaseAttribute(PrimaryAttrEnum.HEALTH));
		
		Label magickaLabel = new Label(PrimaryAttrEnum.MAGICKA.getLabel());
		magickaLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		Button magickaPlusButt = new Button(BUTT_PLUS);
		
		magickaPlusButt.setPrefSize(ATTR_BTTN_SIZE, ATTR_BTTN_SIZE);
		magickaPlusButt.setStyle(Main.BUTTON_LABEL_STYLE);
		magickaPlusButt.setOnAction(event -> Controller.increaseAttribute(PrimaryAttrEnum.MAGICKA));
		
		Button magickaMinusButt = new Button(BUTT_MINUS);
		magickaMinusButt.setStyle(Main.BUTTON_LABEL_STYLE);
		magickaMinusButt.setPrefSize(ATTR_BTTN_SIZE, ATTR_BTTN_SIZE);
		magickaMinusButt.setOnAction(event -> Controller.decreaseAttribute(PrimaryAttrEnum.MAGICKA));
		
		Label staminaLabel = new Label(PrimaryAttrEnum.STAMINA.getLabel());
		staminaLabel.setStyle(Main.SECONDARY_LABEL_STYLE);
		
		Button staminaPlusButt = new Button(BUTT_PLUS);
		staminaPlusButt.setPrefSize(ATTR_BTTN_SIZE, ATTR_BTTN_SIZE);
		staminaPlusButt.setStyle(Main.BUTTON_LABEL_STYLE);
		staminaPlusButt.setOnAction(event -> Controller.increaseAttribute(PrimaryAttrEnum.STAMINA));
		
		Button staminaMinusButt = new Button(BUTT_MINUS);
		staminaMinusButt.setPrefSize(ATTR_BTTN_SIZE, ATTR_BTTN_SIZE);
		staminaMinusButt.setStyle(Main.BUTTON_LABEL_STYLE);
		staminaMinusButt.setOnAction(event -> Controller.decreaseAttribute(PrimaryAttrEnum.STAMINA));
		
		buttonPane.add(healthLabel, 0, 0);
		buttonPane.add(healthPlusButt, 1, 0);
		buttonPane.add(healthMinusButt, 2, 0);
		buttonPane.add(magickaLabel, 0, 1);
		buttonPane.add(magickaPlusButt, 1, 1);
		buttonPane.add(magickaMinusButt, 2, 1);
		buttonPane.add(staminaLabel, 0, 2);
		buttonPane.add(staminaPlusButt, 1, 2);
		buttonPane.add(staminaMinusButt, 2, 2);
		
		return buttonPane;
	}
	
	private Node createTable() {
		VBox tableBox = new VBox();
		tableBox.setPadding(new Insets(COMPONENT_PADDING));
		tableBox.setPrefSize(TABLE_BOX_WIDTH, TABLE_BOX_HEIGHT);
		
		attributeList = FXCollections.observableArrayList();
		attributeList.add(new AttributeRec(1, PrimaryAttrEnum.HEALTH.getLabel(), 0));
		
		attributeTable = new TableView<AttributeRec>();
		attributeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		attributeTable.setEditable(false);
		
		TableColumn<AttributeRec, Integer> levelCol = new TableColumn<AttributeRec, Integer>(LEVEL_COL);
		levelCol.setPrefWidth(LEVEL_COL_WIDTH);
		levelCol.setCellValueFactory(new PropertyValueFactory<AttributeRec, Integer>("level"));
		
		TableColumn<AttributeRec, Integer> attributeCol = new TableColumn<AttributeRec, Integer>(ATTR_COL);
		attributeCol.setPrefWidth(ATTR_COL_WIDTH);
		attributeCol.setCellValueFactory(new PropertyValueFactory<AttributeRec, Integer>("attribute"));
		
		TableColumn<AttributeRec, Integer> gainCol = new TableColumn<AttributeRec, Integer>(GAIN_COL);
		gainCol.setPrefWidth(GAIN_COL_WIDTH);
		gainCol.setCellValueFactory(new PropertyValueFactory<AttributeRec, Integer>("gain"));
		
		attributeTable.getColumns().setAll(levelCol, attributeCol, gainCol);
		attributeTable.setItems(attributeList);
		
		tableBox.getChildren().addAll(attributeTable);
		return tableBox;
	}
	
	public void setAttributeList(List<AttributeRec> attributeList) {
		this.attributeList.setAll(attributeList);
	}
}
