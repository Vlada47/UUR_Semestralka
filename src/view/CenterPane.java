package view;

import javafx.scene.control.TabPane;

public class CenterPane extends TabPane {
	
	private final GeneralTab generalTab;
	private final SkillTab skillTab;
	private final AttrDistribTab attrDistribTab;
	
	public CenterPane() {
		super();
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);;
		
		generalTab = new GeneralTab();
		skillTab = new SkillTab();
		attrDistribTab = new AttrDistribTab();
		
		this.getTabs().addAll(generalTab, skillTab, attrDistribTab);
	}
	
	

}
