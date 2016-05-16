package app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.AppMenuBar;
import view.CenterPane;
import view.LeftPane;

/**
 * Main class of the applications serving as an entry point for the GUI.
 * Also defines some styles, which are used in multiple other classes.
 * @author Vlada47
 *
 */
public class Main extends Application {
	
	/**
	 * String with CSS style for main panes throughout the application.
	 */
	public static final String MAIN_PANE_BORDER_STYLE = "-fx-border-style: solid;"
														+ "-fx-border-width: 2;"
														+ "-fx-border-radius: 10;"
														+ "-fx-border-color: black";
	/**
	 * String with CSS style for inner panes throughout the application.
	 */
	public static final String INNER_PANE_BORDER_STYLE = "-fx-border-style: solid;"
														+ "-fx-border-width: 1;"
														+ "-fx-border-radius: 5;"
														+ "-fx-border-color: black";
	
	/**
	 * String with CSS style for the tabs of the application.
	 */
	public static final String TAB_LABEL_STYLE = "-fx-font-size: 14pt;"
												+ "-fx-font-style: italic;";
	
	/**
	 * String with CSS style for primary labels.
	 */
	public static final String PRIMARY_LABEL_STYLE = "-fx-font-size: 16pt;"
													+ "-fx-font-style: oblique;";
	
	/**
	 * String with CSS style for secondary labels.
	 */
	public static final String SECONDARY_LABEL_STYLE = "-fx-font-size: 12pt;"
													+ "-fx-font-style: oblique;";
	
	/**
	 * String with CSS style for buttons throughout the application.
	 */
	public static final String BUTTON_LABEL_STYLE = "-fx-font-size: 12pt;"
													+ "-fx-font-weight: bold;";
	
	private static final String APP_TITLE = "Skyrim Perkus Maximus Character Calculator";
	
	private static final int STAGE_MIN_WIDTH = 1280;
	private static final int STAGE_MIN_HEIGHT = 600;
	private static final int NODE_MARGIN = 10;
	
	/**
	 * Instance of the application's top menu bar.
	 */
	private AppMenuBar appMenuBar;
	
	/**
	 * Instance of the application's left pane, which can used regardless of the chosen content on the center pane. 
	 */
	private LeftPane leftPane;
	
	/**
	 * Instance of the application's center pane, which contains individual tabs.
	 */
	private CenterPane centerPane;
	
	/**
	 * Main method of the applications.
	 * @param args	input arguments of the application. As this is exclusively a GUI application, they are not used.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//setting up attributes of primary stage
		primaryStage.setTitle(APP_TITLE);
		primaryStage.setMinWidth(STAGE_MIN_WIDTH);
		primaryStage.setMinHeight(STAGE_MIN_HEIGHT);
		primaryStage.setOnCloseRequest(event -> Platform.exit());
		
		//creating the scene and its root node
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, STAGE_MIN_WIDTH, STAGE_MIN_HEIGHT);
		
		//initializing main parts of the application and passing GUI references to the controller
		appMenuBar = new AppMenuBar();
		leftPane = new LeftPane();
		centerPane = new CenterPane();
		Controller.setGuiReferences(leftPane, centerPane);
		
		//setting main parts to the root node and setting up margin
		root.setTop(appMenuBar);
		root.setLeft(leftPane);
		root.setCenter(centerPane);
		BorderPane.setMargin(leftPane, new Insets(NODE_MARGIN));
		BorderPane.setMargin(centerPane, new Insets(NODE_MARGIN));
			
		//displaying the scene
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
