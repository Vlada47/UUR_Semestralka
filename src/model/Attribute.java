package model;

import java.io.Serializable;

import staticData.PrimaryAttrEnum;

/**
 * Instances of this class function as holders for primary attribute distribution.
 * It serializes along with the {@code CharacterBuild} class.
 * @author Vlada47
 *
 */
public class Attribute implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Type of the primary attribute.
	 */
	private final PrimaryAttrEnum attribute;
	
	/**
	 * The gain for this primary attribute distribution.
	 */
	private final int gain;
	
	/**
	 * Constructor for the {@code Attribute} class.
	 * @param attribute	
	 * @param gain
	 */
	public Attribute(PrimaryAttrEnum attribute, int gain) {
		this.attribute = attribute;
		this.gain = gain;
	}
	
	/**
	 * Getter for the {@code attribute}.
	 * @return	attribute
	 */
	public PrimaryAttrEnum getAttribute() {
		return attribute;
	}
	
	/**
	 * Getter for the {@code gain}.
	 * @return	gain
	 */
	public int getGain() {
		return gain;
	}
}
