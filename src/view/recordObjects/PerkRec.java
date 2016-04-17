package view.recordObjects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PerkRec {
	
	private int index;
	private StringProperty title;
	private StringProperty reqPerks;
	private IntegerProperty currlevel;
	private IntegerProperty maxLevel;
	private StringProperty skillLevels;
	
	public PerkRec(int index, String title, String reqPerks, int currLevel, int maxLevel, String skillLevels) {
		this.index = index;
		this.title = new SimpleStringProperty(title);
		this.reqPerks = new SimpleStringProperty(reqPerks);
		this.currlevel = new SimpleIntegerProperty(currLevel);
		this.maxLevel = new SimpleIntegerProperty(maxLevel);
		this.skillLevels = new SimpleStringProperty(skillLevels);
	}
	
	public int getIndex() {
		return index;
	}
	
	public String getTitle() {
		return title.get();
	}
	
	public StringProperty propertyTitle() {
		return title;
	}
	
	public String getReqPerks() {
		return reqPerks.get();
	}
	
	public StringProperty propertyReqPerks() {
		return reqPerks;
	}
	
	public int getCurrLevel() {
		return currlevel.get();
	}
	
	public IntegerProperty propertyCurrLevel() {
		return currlevel;
	}
	
	public int getMaxLevel() {
		return maxLevel.get();
	}
	
	public IntegerProperty propertyMaxLevel() {
		return maxLevel;
	}
	
	public String getSkillLevels() {
		return skillLevels.get();
	}
	
	public StringProperty propertySkillLevels() {
		return skillLevels;
	}
}
