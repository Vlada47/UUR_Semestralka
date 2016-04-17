package staticData;

public enum GenderEnum {
	MALE(0,"Male","MALE"),
	FEMALE(1,"Female","FEMALE");
	
	public static final String LABEL = "Gender"; 
	
	private final int id;
	private final String label;
	private final String description;
	
	GenderEnum(int id, String label, String description) {
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
