package view;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import view.recordObjects.HelpRec;

public class HelpWindow extends Stage {
	
	private static final String DEFAULT_CONTENT = "";
	
	private static final String ROOT_LABEL = "HELP MENU";
	private static final String ROOT_CONTENT = "Choose the topic from the menu...";
	
	private static final String ABOUT_LABEL = "About the application";
	private static final String ABOUT_CONTENT = "There's supposed to be something.";
	
	private static final String GUIDE_LABEL = "Builder guide";
	private static final String GUIDE_CONTENT = "There's supposed to be something.";
	
	private static final String BUILDING_RULES_LABEL = "Character building rules";
	private static final String BUILDING_RULES_CONTENT = "There's supposed to be something.";
	
	private static final String TERMS_LABEL = "Explanation terms";
	private static final String TERMS_CONTENT = "There's supposed to be something.";
	
	private static final String BUILD_BASE_LABEL = "Build base";
	private static final String BUILD_BASE_CONTENT = "There's supposed to be something.";
	
	private static final String BUILD_LEVELING_LABEL = "Build leveling";
	private static final String BUILD_LEVELING_CONTENT = "There's supposed to be something.";
	
	private static final String APPLICATION_LABEL = "Application usage";
	private static final String APPLICATION_CONTENT = "There's supposed to be something.";
	
	private static final String MAIN_MENU_LABEL = "Main Menu description";
	private static final String MAIN_MENU_CONTENT = "There's supposed to be something.";
	
	private static final String LEFT_PANE_LABEL = "Left Pane description";
	private static final String LEFT_PANE_CONTENT = "There's supposed to be something.";
	
	private static final String GENERAL_TAB_LABEL = "General Tab description";
	private static final String GENERAL_TAB_CONTENT = "There's supposed to be something.";
	
	private static final String SKILL_TAB_LABEL = "Skills & Perks Tab description";
	private static final String SKILL_TAB_CONTENT = "There's supposed to be something.";
	
	private static final String ATTR_TAB_LABEL = "Attributes Distribution Tab description";
	private static final String ATTR_TAB_CONTENT = "There's supposed to be something.";
	
	private static final String TITLE = "Application guide";
	private static final int MIN_WIDTH = 480;
	private static final int MIN_HEIGHT = 640;
	
	private static HelpWindow instance = null;
	
	private TreeView<HelpRec> helpMenu;
	private WebEngine webEngine;
	
	public static HelpWindow getInstance() {
		
		if(instance == null) {
			instance = new HelpWindow();
		}
		
		return instance;
	}
	
	private HelpWindow() {
		this.setTitle(TITLE);
		this.setMinWidth(MIN_WIDTH);
		this.setMinHeight(MIN_HEIGHT);
		this.setOnCloseRequest(event -> emptyInstance());
		
		HBox rootPane = new HBox(createTreeMenu(), createText());
		Scene scene = new Scene(rootPane, MIN_WIDTH, MIN_HEIGHT);
		
		this.setScene(scene);
		this.show();
	}
	
	private Node createTreeMenu() {
		VBox treeBox = new VBox();
		helpMenu = new TreeView<>();
		helpMenu.setEditable(false);
		helpMenu.getSelectionModel().getSelectedItems().addListener((ListChangeListener.Change<? extends TreeItem<HelpRec>> change) -> setHelpContent());
		
		TreeItem<HelpRec> rootItem = new TreeItem<HelpRec>(new HelpRec(ROOT_LABEL, ROOT_CONTENT));
		TreeItem<HelpRec> aboutItem = new TreeItem<HelpRec>(new HelpRec(ABOUT_LABEL, ABOUT_CONTENT));
		TreeItem<HelpRec> guideItem = new TreeItem<HelpRec>(new HelpRec(GUIDE_LABEL, GUIDE_CONTENT));
		TreeItem<HelpRec> buildingRulesItem = new TreeItem<HelpRec>(new HelpRec(BUILDING_RULES_LABEL, BUILDING_RULES_CONTENT));
		TreeItem<HelpRec> termsItem = new TreeItem<HelpRec>(new HelpRec(TERMS_LABEL, TERMS_CONTENT));
		TreeItem<HelpRec> buildBaseItem = new TreeItem<HelpRec>(new HelpRec(BUILD_BASE_LABEL, BUILD_BASE_CONTENT));
		TreeItem<HelpRec> buildLevelingItem = new TreeItem<HelpRec>(new HelpRec(BUILD_LEVELING_LABEL, BUILD_LEVELING_CONTENT));
		TreeItem<HelpRec> applicationItem = new TreeItem<HelpRec>(new HelpRec(APPLICATION_LABEL, APPLICATION_CONTENT));
		TreeItem<HelpRec> mainMenuItem = new TreeItem<HelpRec>(new HelpRec(MAIN_MENU_LABEL, MAIN_MENU_CONTENT));
		TreeItem<HelpRec> leftPaneItem = new TreeItem<HelpRec>(new HelpRec(LEFT_PANE_LABEL, LEFT_PANE_CONTENT));
		TreeItem<HelpRec> generalTabItem = new TreeItem<HelpRec>(new HelpRec(GENERAL_TAB_LABEL, GENERAL_TAB_CONTENT));
		TreeItem<HelpRec> skillTabItem = new TreeItem<HelpRec>(new HelpRec(SKILL_TAB_LABEL, SKILL_TAB_CONTENT));
		TreeItem<HelpRec> attrTabItem = new TreeItem<HelpRec>(new HelpRec(ATTR_TAB_LABEL, ATTR_TAB_CONTENT));
		
		applicationItem.getChildren().addAll(mainMenuItem, leftPaneItem, generalTabItem, skillTabItem, attrTabItem);
		buildingRulesItem.getChildren().addAll(termsItem, buildBaseItem, buildLevelingItem);
		guideItem.getChildren().addAll(buildingRulesItem, applicationItem);
		rootItem.getChildren().addAll(aboutItem, guideItem);
		helpMenu.setRoot(rootItem);
		
		treeBox.getChildren().add(helpMenu);
		return treeBox;
	}
	
	private Node createText() {
		VBox contentBox = new VBox();
		WebView text = new WebView();
		webEngine = text.getEngine();
		webEngine.loadContent(DEFAULT_CONTENT);
		contentBox.getChildren().add(text);
		return contentBox;
	}
	
	private void setHelpContent() {
		TreeItem<HelpRec> item = helpMenu.getSelectionModel().getSelectedItem();
		String content = item.getValue().getHtmlText();
		webEngine.loadContent(content);
	}
	
	private void emptyInstance() {
		instance = null;
	}

}
