package view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HelpWindow extends Stage {
	
	public static final int ABOUT_WINDOW = 1;
	public static final int MANUAL_WINDOW = 2;
	
	private static final String TITLE = "About the program";
	private static final int MIN_WIDTH = 480;
	private static final int MIN_HEIGHT = 640;
	private static final String DEFAULT_CONTENT = "<p></p>";
	private static final String ABOUT_CONTENT = "<p>Something unimportant about this weird app...</p>";
	private static final String MANUAL_CONTENT = "<p>Some helpful text that nobody will read...</p>";
	
	private static HelpWindow instance = null;
	
	public static HelpWindow getInstance(int window) {
		
		if(instance == null) {
			instance = new HelpWindow(window);
		}
		
		return instance;
	}
	
	private HelpWindow(int window) {
		this.setTitle(TITLE);
		this.setMinWidth(MIN_WIDTH);
		this.setMinHeight(MIN_HEIGHT);
		this.setOnCloseRequest(event -> emptyInstance());
		
		VBox rootPane = new VBox(createText(window));
		Scene scene = new Scene(rootPane, MIN_WIDTH, MIN_HEIGHT);
		
		this.setScene(scene);
		this.show();
	}
	
	private WebView createText(int window) {
		WebView text = new WebView();
		WebEngine webEngine = text.getEngine();
		
		switch(window) {
			case ABOUT_WINDOW:
				webEngine.loadContent(ABOUT_CONTENT); break;
			case MANUAL_WINDOW:
				webEngine.loadContent(MANUAL_CONTENT); break;
			default:
				webEngine.loadContent(DEFAULT_CONTENT); break;
		}
		
		return text;
	}
	
	private void emptyInstance() {
		instance = null;
	}

}
