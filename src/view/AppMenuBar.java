package view;

import controller.Controller;
import javafx.application.Platform;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class AppMenuBar extends MenuBar {
	
	private static final String MAIN_MENU_LABEL = "Main Menu";
	private static final String HELP_MENU_LABEL = "Help";
	private static final String NEW_BUILD_LABEL = "New Build";
	private static final String SAVE_BUILD_LABEL = "Save Build";
	private static final String LOAD_BUILD_LABEL = "Load Build";
	private static final String WARNING_MODE_LABEL = "Warning Mode";
	private static final String EXIT_APP_LABEL = "Exit Application";
	private static final String ABOUT_LABEL = "About application";
	private static final String MANUAL_LABEL = "Usage manual";
	
	public AppMenuBar() {
		super();
		
		this.getMenus().addAll(createMainMenu(),createHelpMenu());
	}
	
	private Menu createMainMenu() {
		Menu menu = new Menu(MAIN_MENU_LABEL);
		
		MenuItem newBuildItem = new MenuItem(NEW_BUILD_LABEL);
		newBuildItem.setOnAction(event -> Controller.createBuild());
		
		MenuItem saveBuildItem = new MenuItem(SAVE_BUILD_LABEL);
		saveBuildItem.setOnAction(null);
		
		MenuItem loadBuildItem = new MenuItem(LOAD_BUILD_LABEL);
		loadBuildItem.setOnAction(null);
		
		CheckMenuItem warningModeItem = new CheckMenuItem(WARNING_MODE_LABEL);
		warningModeItem.setSelected(Controller.getWarningStatus());
		warningModeItem.setOnAction(event -> Controller.setWarningStatus(!Controller.getWarningStatus()));
		
		MenuItem exitAppItem = new MenuItem(EXIT_APP_LABEL);
		exitAppItem.setOnAction(event -> quitApp());
		
		menu.getItems().addAll(newBuildItem, saveBuildItem, loadBuildItem, new SeparatorMenuItem(), warningModeItem, new SeparatorMenuItem(), exitAppItem);
		
		return menu;
	}
	
	private Menu createHelpMenu() {
		Menu menu = new Menu(HELP_MENU_LABEL);
		
		MenuItem aboutItem = new MenuItem(ABOUT_LABEL);
		aboutItem.setOnAction(event -> showAbout());
		
		MenuItem manualItem = new MenuItem(MANUAL_LABEL);
		manualItem.setOnAction(event -> showManual());
		
		menu.getItems().addAll(aboutItem, manualItem);
		
		return menu;
	}
	
	private void quitApp() {
		Platform.exit();
	}
	
	private void showAbout() {
		HelpWindow.getInstance(HelpWindow.ABOUT_WINDOW);
	}
	
	private void showManual() {
		HelpWindow.getInstance(HelpWindow.MANUAL_WINDOW);
	}
}
