package model;

import staticData.PrimaryAttrEnum;

public class Attribute {
	
	private PrimaryAttrEnum attribute;
	private int gain;
	
	public Attribute(PrimaryAttrEnum attribute, int gain) {
		this.attribute = attribute;
		this.gain = gain;
	}

	public PrimaryAttrEnum getAttribute() {
		return attribute;
	}

	public int getGain() {
		return gain;
	}
}
