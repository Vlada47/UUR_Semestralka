package staticData;

public enum GenderEnum {
	MALE(0,"Male"),
	FEMALE(1,"Female");
	
	private final int id;
	private final String label;
	
	GenderEnum(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return label;
	}
}
