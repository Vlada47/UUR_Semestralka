package model;

import staticData.PrimaryAttrEnum;

public class Attribute {
	
	private int level;
	private PrimaryAttrEnum attribute;
	private int gain;
	
	public Attribute(int level, PrimaryAttrEnum attribute, int gain) {
		this.level = level;
		this.attribute = attribute;
		this.gain = gain;
	}

	public int getLevel() {
		return level;
	}

	public PrimaryAttrEnum getAttribute() {
		return attribute;
	}

	public int getGain() {
		return gain;
	}
}
