package staticData;

/**
 * Enumerator for individual specializations.
 * @author Vlada47
 *
 */
public enum SpecializationEnum {
	COMBAT(0,"Combat","Combat skills level 20% faster."),
	MAGIC(1,"Magic","Magic skills level 20% faster."),
	STEALTH(2,"Stealth","Stealth skills level 20% faster.");
	
	public static final String LABEL = "Specialization";
	
	/**
	 * ID of the specialization.
	 */
	private final int id;
	
	/**
	 * Name of the specialization.
	 */
	private final String label;
	
	/**
	 * Description of the race.
	 */
	private final String description;
	
	SpecializationEnum(int id, String label, String description) {
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
