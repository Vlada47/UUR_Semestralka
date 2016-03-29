package view.recordObjects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AttributeRec {
	
	private IntegerProperty level;
	private StringProperty attribute;
	private IntegerProperty gain;
	
	public AttributeRec(int level, String attribute, int gain) {
		this.level = new SimpleIntegerProperty(level);
		this.attribute = new SimpleStringProperty(attribute);
		this.gain = new SimpleIntegerProperty(gain);
	}

	public int getLevel() {
		return level.get();
	}
	
	public IntegerProperty levelProperty() {
		return level;
	}

	public String getAttribute() {
		return attribute.get();
	}
	
	public StringProperty attributeProperty() {
		return attribute;
	}

	public int getGain() {
		return gain.get();
	}
	
	public IntegerProperty gainProperty() {
		return gain;
	}
}