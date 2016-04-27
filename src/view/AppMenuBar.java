package view;

import java.io.File;

import app.Controller;
import app.Main;
import javafx.application.Platform;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
	
	public AppMenuBar() {
		super();
		
		this.setPrefHeight(BAR_HEIGHT);
		this.getMenus().addAll(createMainMenu(),createHelpMenu());
	}
	
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
	
	private Menu createHelpMenu() {
		Menu menu = new Menu(HELP_MENU_LABEL);
		
		MenuItem manualItem = new MenuItem(MANUAL_LABEL);
		manualItem.setOnAction(event -> showManual());
		
		menu.getItems().addAll(manualItem);
		
		return menu;
	}
	
	private void newBuildAction() {
		Controller.createCharacter();
		Controller.setInfoFieldsDisable(false);
		Controller.setBuildNotesDisable(false);
		Controller.setGeneralTabDisable(false);
	}
	
	private void saveBuildAction() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(SAVE_BUILD_TEXT);
		
		File file = fileChooser.showSaveDialog(new Stage());
		
		if(file != null) {
			if(Controller.saveBuild(file)) {
				Main.displayAlert(AlertType.INFORMATION, 
						"Save build confirmation", 
						"Success:", 
						"The build was succesfuly saved in the file.");
			}
			else {
				if(Controller.getWarningStatus()) {
					Main.displayAlert(AlertType.ERROR, 
							"Save build error", 
							"Error:", 
							"The build couldn't be saved in the file."
							+ "Make sure you have actually started the creation.");
				}
			}
		}
	}
	
	private void loadBuildAction() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(LOAD_BUILD_TEXT);
		
		File file = fileChooser.showOpenDialog(new Stage());
		
		if(file != null) {
			if(Controller.loadBuild(file)) {
				Main.displayAlert(AlertType.INFORMATION, 
						"Load build confirmation", 
						"Success:", 
						"The build was succesfuly loaded from the file.");
			}
			else {
				if(Controller.getWarningStatus()) {
					Main.displayAlert(AlertType.ERROR, 
							"Load build error", 
							"Error:", 
							"The build wasn't loaded from the file."
							+ "Make sure you're trying to load the correct file (correct format).");
				}
			}
		}
	}
	
	private void showManual() {
		HelpWindow.getInstance();
	}
	
	private void quitApp() {
		Platform.exit();
	}
}
