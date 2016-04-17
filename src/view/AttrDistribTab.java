package view;

import java.util.List;

import controller.Controller;
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
	
	private TableView<AttributeRec> attributeTable;
	private ObservableList<AttributeRec> attributeList;

	public AttrDistribTab() {
		super();
		this.setText(TAB_LABEL);
		this.setContent(new HBox(createButtonBox(), createTable()));
		this.setDisable(true);
	}
	
	private VBox createButtonBox() {
		VBox buttonBox = new VBox();
		
		HBox healthBox = new HBox();
		Label healthLabel = new Label(PrimaryAttrEnum.HEALTH.getLabel());
		Button healthPlusButt = new Button(BUTT_PLUS);
		healthPlusButt.setOnAction(event -> Controller.increaseAttribute(PrimaryAttrEnum.HEALTH));
		Button healthMinusButt = new Button(BUTT_MINUS);
		healthMinusButt.setOnAction(event -> Controller.decreaseAttribute(PrimaryAttrEnum.HEALTH));
		healthBox.getChildren().addAll(healthLabel, healthPlusButt, healthMinusButt);
		
		HBox magickaBox = new HBox();
		Label magickaLabel = new Label(PrimaryAttrEnum.MAGICKA.getLabel());
		Button magickaPlusButt = new Button(BUTT_PLUS);
		magickaPlusButt.setOnAction(event -> Controller.increaseAttribute(PrimaryAttrEnum.MAGICKA));
		Button magickaMinusButt = new Button(BUTT_MINUS);
		magickaMinusButt.setOnAction(event -> Controller.decreaseAttribute(PrimaryAttrEnum.MAGICKA));
		magickaBox.getChildren().addAll(magickaLabel, magickaPlusButt, magickaMinusButt);
		
		HBox staminaBox = new HBox();
		Label staminaLabel = new Label(PrimaryAttrEnum.STAMINA.getLabel());
		Button staminaPlusButt = new Button(BUTT_PLUS);
		staminaPlusButt.setOnAction(event -> Controller.increaseAttribute(PrimaryAttrEnum.STAMINA));
		Button staminaMinusButt = new Button(BUTT_MINUS);
		staminaMinusButt.setOnAction(event -> Controller.decreaseAttribute(PrimaryAttrEnum.STAMINA));
		staminaBox.getChildren().addAll(staminaLabel, staminaPlusButt, staminaMinusButt);
		
		buttonBox.getChildren().addAll(healthBox, magickaBox, staminaBox);
		
		return buttonBox;
	}
	
	private TableView<AttributeRec> createTable() {
		attributeList = FXCollections.observableArrayList();
		attributeList.add(new AttributeRec(1, PrimaryAttrEnum.HEALTH.getLabel(), 0));
		
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
	
	public void setAttributeList(List<AttributeRec> attributeList) {
		this.attributeList.setAll(attributeList);
	}
}
