package model;

import java.io.Serializable;

import staticData.PrimaryAttrEnum;

public class Attribute implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final PrimaryAttrEnum attribute;
	private final int gain;
	
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
