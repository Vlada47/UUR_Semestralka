package staticData;

public enum PrimaryAttrEnum {
	HEALTH(0,"Health"),
	MAGICKA(1,"Magicka"),
	STAMINA(2,"Stamina");
	
	private final int id;
	private final String label;
	
	PrimaryAttrEnum(int id, String label) {
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
