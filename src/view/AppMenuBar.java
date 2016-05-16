package view;

import java.io.File;

import app.Controller;
import javafx.application.Platform;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Instance of this class represents a main menu bar with respective menu options and defines individual events. 
 * @author Vlada47
 *
 */
public class AppMenuBar extends MenuBar {
	
	private static final int BAR_HEIGHT = 30;
	
	private static final String MAIN_MENU_LABEL = "Main Menu";
	private static final String HELP_MENU_LABEL = "Help";
	private static final String NEW_BUILD_LABEL = "New Build";
	private static final String SAVE_BUILD_LABEL = "Save Build";
	private static final String LOAD_BUILD_LABEL = "Load Build";
	private static final String WARNING_MODE_LABEL = "Warning Mode";
	private static final String EXIT_APP_LABEL = "Exit Application";
	private static final String MANUAL_LABEL = "Usage manual";
	private static final String SAVE_BUILD_TEXT = "Save build to file";
	private static final String LOAD_BUILD_TEXT = "Load build from file";
	
	/**
	 * Constructor of the {@code AppMenuBar} class. It calls the constructor of {@code MenuBar} class,
	 * sets height of the bar and add individual menus created in their respective methods.
	 */
	public AppMenuBar() {
		super();
		
		this.setPrefHeight(BAR_HEIGHT);
		this.getMenus().addAll(createMainMenu(),createHelpMenu());
	}
	
	/**
	 * Method for creating the main menu and its options and setting their action events.
	 * @return	main menu with options
	 */
	private Menu createMainMenu() {
		Menu menu = new Menu(MAIN_MENU_LABEL);
		
		MenuItem newBuildItem = new MenuItem(NEW_BUILD_LABEL);
		newBuildItem.setOnAction(event -> newBuildAction());
		
		MenuItem saveBuildItem = new MenuItem(SAVE_BUILD_LABEL);
		saveBuildItem.setOnAction(event -> saveBuildAction());
		
		MenuItem loadBuildItem = new MenuItem(LOAD_BUILD_LABEL);
		loadBuildItem.setOnAction(event -> loadBuildAction());
		
		CheckMenuItem warningModeItem = new CheckMenuItem(WARNING_MODE_LABEL);
		warningModeItem.setSelected(Controller.getWarningStatus());
		warningModeItem.setOnAction(event -> Controller.setWarningStatus(!Controller.getWarningStatus()));
		
		MenuItem exitAppItem = new MenuItem(EXIT_APP_LABEL);
		exitAppItem.setOnAction(event -> quitApp());
		
		menu.getItems().addAll(newBuildItem, saveBuildItem, loadBuildItem, new SeparatorMenuItem(), warningModeItem, new SeparatorMenuItem(), exitAppItem);
		
		return menu;
	}
	
	/**
	 * Method for creating the help menu with an option to display a help window.
	 * @return	help menu
	 */
	private Menu createHelpMenu() {
		Menu menu = new Menu(HELP_MENU_LABEL);
		MenuItem manualItem = new MenuItem(MANUAL_LABEL);
		manualItem.setOnAction(event -> showManual());
		menu.getItems().addAll(manualItem);
		
		return menu;
	}
	
	/**
	 * Event of "New Build" menu option. It first checks, if there's some build already in progress by calling {@code confirmNewBuild}.
	 * If not, then {@code createCharacter} method is called and left pane along with general tab are enabled and other tabs disabled.
	 */
	private void newBuildAction() {
		if(Controller.confirmNewBuild()) {
			Controller.createCharacter();
			Controller.setInfoFieldsDisable(false);
			Controller.setBuildNotesDisable(false);
			Controller.setGeneralTabDisable(false);
			Controller.setGeneralTabControlDisable(false);
			Controller.setDevelopmentTabsDisable(true);
		}
	}
	
	/**
	 * Event of "Save Build" menu option. It displays a {@code FileChooser} in save dialog
	 * and passes selected file to {@code saveBuild} method.
	 */
	private void saveBuildAction() {
		if(Controller.characterBuildInstanceExists()) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle(SAVE_BUILD_TEXT);
			File file = fileChooser.showSaveDialog(new Stage());
			
			if(file != null) {
				Controller.saveBuild(file);
			}
		}
	}
	
	/**
	 * Event of "Load Build" menu option. It displays a {@code FileChooser} in open dialog
	 * and passes selected file to {@code loadBuild} method.
	 */
	private void loadBuildAction() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(LOAD_BUILD_TEXT);
		File file = fileChooser.showOpenDialog(new Stage());
		
		if(file != null) {
			Controller.loadBuild(file);
		}
	}
	
	/**
	 * Event of "Usage Manual" menu option for displaying a window with the guide. 
	 */
	private void showManual() {
		HelpWindow.getInstance();
	}
	
	/**
	 * Event of "Exit Application" menu option. It shuts down the application.
	 */
	private void quitApp() {
		if(Controller.endAppConfirmed()) {
			Platform.exit();
		}
	}
}
