package staticData;

public enum SpecializationEnum {
	COMBAT(0,"Combat","Combat skills level 20% faster."),
	MAGIC(1,"Magic","Magic skills level 20% faster."),
	STEALTH(2,"Stealth","Stealth skills level 20% faster.");
	
	public static final String LABEL = "Specialization";
	
	private final int id;
	private final String label;
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
