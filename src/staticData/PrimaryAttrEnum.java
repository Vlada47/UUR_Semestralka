package staticData;

/**
 * Enumerator for individual primary attributes.
 * @author Vlada47
 *
 */
public enum PrimaryAttrEnum {
	HEALTH(0,"Health","+20 points to Health."),
	MAGICKA(1,"Magicka","+20 points to Magicka."),
	STAMINA(2,"Stamina","+20 points to Stamina.");
	
	public static final String LABEL = "Primary Attribute"; 
	
	/**
	 * ID of the primary attribute.
	 */
	private final int id;
	
	/**
	 * Name of the primary attribute.
	 */
	private final String label;
	
	/**
	 * Description of the primary attribute.
	 */
	private final String description;
	
	PrimaryAttrEnum(int id, String label, String description) {
		this.id = id;
		this.label = label;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return label;
	}
}
