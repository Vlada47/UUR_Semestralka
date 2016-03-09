package enumerators;

public enum SpecializationEnum {
	COMBAT(0,"Combat"),
	MAGIC(1,"Magic"),
	STEALTH(2,"Stealth");
	
	private final int id;
	private final String label;
	
	SpecializationEnum(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
}
