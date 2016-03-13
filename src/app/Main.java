package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import staticData.PerkConstants;
import view.AppMenuBar;

public class Main extends Application {
	
	private static final String APP_TITLE = "Skyrim Perkus Maximus Character Calculator";
	private static final int STAGE_MIN_WIDTH = 1280;
	private static final int STAGE_MIN_HEIGHT = 720;

	public static void main(String[] args) {
		//launch(args);
		for(String[] labels : PerkConstants.PERK_LABELS) {
			for(int i = 0; i < labels.length; i++) {
				System.out.println(labels[i]+": "+i);
			}
			System.out.println("---");
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(APP_TITLE);
		primaryStage.setMinWidth(STAGE_MIN_WIDTH);
		primaryStage.setMinHeight(STAGE_MIN_HEIGHT);
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, STAGE_MIN_WIDTH, STAGE_MIN_HEIGHT);
		
		root.setTop(new AppMenuBar());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
