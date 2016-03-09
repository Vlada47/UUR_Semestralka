package enumerators;

public enum SecondaryAttrEnum {
	STRENGTH(0,"Strength"),
	ENDURANCE(1,"Endurance"),
	INTELLIGENCE(2,"Intelligence"),
	WILLPOWER(3,"Willpower"),
	AGILITY(4,"Agility"),
	SPEED(5,"Speed"),
	PERSONALITY(6,"Personality");
	
	private final int id;
	private final String label;
	
	SecondaryAttrEnum(int id, String label) {
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
