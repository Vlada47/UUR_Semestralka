package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.AppMenuBar;
import view.CenterPane;
import view.LeftPane;

public class Main extends Application {
	
	public static final String MAIN_PANE_BORDER_STYLE = "-fx-border-style: solid;"
														+ "-fx-border-width: 2;"
														+ "-fx-border-radius: 10;"
														+ "-fx-border-color: black";
	
	public static final String INNER_PANE_BORDER_STYLE = "-fx-border-style: solid;"
														+ "-fx-border-width: 1;"
														+ "-fx-border-radius: 5;"
														+ "-fx-border-color: black";
	
	public static final String TAB_LABEL_STYLE = "-fx-font-size: 14pt;"
												+ "-fx-font-style: italic;";	
	public static final String PRIMARY_LABEL_STYLE = "-fx-font-size: 16pt;"
													+ "-fx-font-style: oblique;";
	public static final String SECONDARY_LABEL_STYLE = "-fx-font-size: 12pt;"
													+ "-fx-font-style: oblique;";
	public static final String BUTTON_LABEL_STYLE = "-fx-font-size: 12pt;"
													+ "-fx-font-weight: bold;";
	
	private static final String APP_TITLE = "Skyrim Perkus Maximus Character Calculator";
	
	private static final int STAGE_MIN_WIDTH = 1280;
	private static final int STAGE_MIN_HEIGHT = 600;
	private static final int NODE_MARGIN = 10;
	
	private AppMenuBar appMenuBar;
	private LeftPane leftPane;
	private CenterPane centerPane;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(APP_TITLE);
		primaryStage.setMinWidth(STAGE_MIN_WIDTH);
		primaryStage.setMinHeight(STAGE_MIN_HEIGHT);
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, STAGE_MIN_WIDTH, STAGE_MIN_HEIGHT);
		
		appMenuBar = new AppMenuBar();
		leftPane = new LeftPane();
		centerPane = new CenterPane();
		Controller.setGuiReferences(leftPane, centerPane);
		
		root.setTop(appMenuBar);
		root.setLeft(leftPane);
		root.setCenter(centerPane);
		BorderPane.setMargin(leftPane, new Insets(NODE_MARGIN));
		BorderPane.setMargin(centerPane, new Insets(NODE_MARGIN));
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
