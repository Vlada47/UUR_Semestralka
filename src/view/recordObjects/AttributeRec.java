package view.recordObjects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Instances of this class represents records for the attribute distribution table.
 * @author Vlada47
 *
 */
public class AttributeRec {
	
	/**
	 * Character level of the distribution.
	 */
	private final IntegerProperty level;
	
	/**
	 * Chosen attribute of the distribution.
	 */
	private final StringProperty attribute;
	
	/**
	 * Number of points distributed to chosen attribute.
	 */
	private final IntegerProperty gain;
	
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