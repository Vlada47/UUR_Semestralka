package view;

import app.Main;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
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

/**
 * Instance of this class represents a window containing a guide to the application.
 * @author Vlada47
 *
 */
public class HelpWindow extends Stage {
	
	private static final String TITLE = "Application guide";
	private static final String ROOT_LABEL = "HELP MENU";
	private static final String ABOUT_LABEL = "About the application";
	private static final String GUIDE_LABEL = "Builder guide";
	private static final String BUILDING_RULES_LABEL = "Character building rules";
	private static final String TERMS_LABEL = "Terms explanation";
	private static final String BUILD_BASE_LABEL = "Build base";
	private static final String BUILD_LEVELING_LABEL = "Build leveling";
	private static final String APPLICATION_LABEL = "Application usage";
	private static final String MAIN_MENU_LABEL = "Main Menu description";
	private static final String LEFT_PANE_LABEL = "Left Pane description";
	private static final String GENERAL_TAB_LABEL = "General Tab description";
	private static final String SKILL_TAB_LABEL = "Skills & Perks Tab description";
	private static final String ATTR_TAB_LABEL = "Attributes Distribution Tab description";
	
	private static final int MIN_WIDTH = 800;
	private static final int MIN_HEIGHT = 600;
	private static final int ROOT_PANE_SPACING = 10;
	private static final int ROOT_PANE_PADDING = 10;
	private static final int CONTENT_PANE_PADDING = 5;
	private static final int HELP_MENU_WIDTH = 350;
	private static final int HELP_TREE_HEIGHT = 550;
	private static final int HTML_VIEW_WIDTH = 450;
	
	/**
	 * Singleton instance of this class.
	 */
	private static HelpWindow instance = null;
	
	/**
	 * {@code TreeView} with navigation to guide's individual topics.
	 */
	private TreeView<HelpRec> helpMenu;
	
	/**
	 * {@code WebEngine} instance for the ability to display a text formatted by HTML tags.
	 */
	private WebEngine webEngine;
	
	/**
	 * Method for getting the singleton instance.
	 * @return	instance of this class
	 */
	public static HelpWindow getInstance() {
		
		if(instance == null) {
			instance = new HelpWindow();
		}
		
		return instance;
	}
	
	/**
	 * Private constructor of this class. It sets basic attributes of the {@code Stage}, adds visible elements via respective methods
	 * and then it displays the window.
	 */
	private HelpWindow() {
		this.setTitle(TITLE);
		this.setMinWidth(MIN_WIDTH);
		this.setMinHeight(MIN_HEIGHT);
		this.setOnCloseRequest(event -> emptyInstance());
		
		HBox rootPane = new HBox(createTreeMenu(), createText());
		rootPane.setPadding(new Insets(ROOT_PANE_PADDING));
		rootPane.setSpacing(ROOT_PANE_SPACING);
		
		Scene scene = new Scene(rootPane, MIN_WIDTH, MIN_HEIGHT);
		
		this.setScene(scene);
		this.show();
	}
	
	/**
	 * Method creating a component (node) with {@code TreeView} style topic navigation. It creates individual {@code TreeItem} instances
	 * and adds them to the tree.
	 * @return	a node with navigation tree
	 */
	private Node createTreeMenu() {
		VBox treeBox = new VBox();
		treeBox.setPrefWidth(HELP_MENU_WIDTH);
		treeBox.setPadding(new Insets(CONTENT_PANE_PADDING));
		treeBox.setStyle(Main.INNER_PANE_BORDER_STYLE);
		
		helpMenu = new TreeView<>();
		helpMenu.setEditable(false);
		helpMenu.setPrefHeight(HELP_TREE_HEIGHT);
		helpMenu.setStyle(Main.SECONDARY_LABEL_STYLE);
		helpMenu.getSelectionModel().getSelectedItems().addListener((ListChangeListener.Change<? extends TreeItem<HelpRec>> change) -> setHelpContent());
		
		TreeItem<HelpRec> rootItem = new TreeItem<HelpRec>(new HelpRec(ROOT_LABEL, HelpTexts.ROOT_CONTENT));
		TreeItem<HelpRec> aboutItem = new TreeItem<HelpRec>(new HelpRec(ABOUT_LABEL, HelpTexts.ABOUT_CONTENT));
		TreeItem<HelpRec> guideItem = new TreeItem<HelpRec>(new HelpRec(GUIDE_LABEL, HelpTexts.GUIDE_CONTENT));
		TreeItem<HelpRec> buildingRulesItem = new TreeItem<HelpRec>(new HelpRec(BUILDING_RULES_LABEL, HelpTexts.BUILDING_RULES_CONTENT));
		TreeItem<HelpRec> termsItem = new TreeItem<HelpRec>(new HelpRec(TERMS_LABEL, HelpTexts.TERMS_CONTENT));
		TreeItem<HelpRec> buildBaseItem = new TreeItem<HelpRec>(new HelpRec(BUILD_BASE_LABEL, HelpTexts.BUILD_BASE_CONTENT));
		TreeItem<HelpRec> buildLevelingItem = new TreeItem<HelpRec>(new HelpRec(BUILD_LEVELING_LABEL, HelpTexts.BUILD_LEVELING_CONTENT));
		TreeItem<HelpRec> applicationItem = new TreeItem<HelpRec>(new HelpRec(APPLICATION_LABEL, HelpTexts.APPLICATION_CONTENT));
		TreeItem<HelpRec> mainMenuItem = new TreeItem<HelpRec>(new HelpRec(MAIN_MENU_LABEL, HelpTexts.MAIN_MENU_CONTENT));
		TreeItem<HelpRec> leftPaneItem = new TreeItem<HelpRec>(new HelpRec(LEFT_PANE_LABEL, HelpTexts.LEFT_PANE_CONTENT));
		TreeItem<HelpRec> generalTabItem = new TreeItem<HelpRec>(new HelpRec(GENERAL_TAB_LABEL, HelpTexts.GENERAL_TAB_CONTENT));
		TreeItem<HelpRec> skillTabItem = new TreeItem<HelpRec>(new HelpRec(SKILL_TAB_LABEL, HelpTexts.SKILL_TAB_CONTENT));
		TreeItem<HelpRec> attrTabItem = new TreeItem<HelpRec>(new HelpRec(ATTR_TAB_LABEL, HelpTexts.ATTR_TAB_CONTENT));
		
		applicationItem.getChildren().addAll(mainMenuItem, leftPaneItem, generalTabItem, skillTabItem, attrTabItem);
		buildingRulesItem.getChildren().addAll(termsItem, buildBaseItem, buildLevelingItem);
		guideItem.getChildren().addAll(buildingRulesItem, applicationItem);
		rootItem.getChildren().addAll(aboutItem, guideItem);
		helpMenu.setRoot(rootItem);

		treeBox.getChildren().add(helpMenu);
		return treeBox;
	}
	
	/**
	 * Method creating a component (node) containing a {@code WebView} with HTML formated text.
	 * @return	a node with {@code WebView} instance
	 */
	private Node createText() {
		VBox contentBox = new VBox();
		contentBox.setPrefWidth(HTML_VIEW_WIDTH);
		contentBox.setPadding(new Insets(CONTENT_PANE_PADDING));
		contentBox.setStyle(Main.INNER_PANE_BORDER_STYLE);
		
		WebView text = new WebView();
		webEngine = text.getEngine();
		
		contentBox.getChildren().add(text);
		return contentBox;
	}
	
	/**
	 * Method handling the event, when selecting individual topics from navigation tree.
	 * It gets the HTML text from selected tree record and pass it to a content of the {@code WebEngine} instance. 
	 */
	private void setHelpContent() {
		TreeItem<HelpRec> item = helpMenu.getSelectionModel().getSelectedItem();
		String content = item.getValue().getHtmlText();
		webEngine.loadContent(content);
	}
	
	/**
	 * Method handling exiting the help window, it destroys the instance of this class.
	 */
	private void emptyInstance() {
		instance = null;
	}
}