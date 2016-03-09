package enumerators;

public enum RaceEnum {
	ALTMER(0,"Altmer"),
	ARGONIAN(1,"Argonian"),
	BOSMER(2,"Bosmer"),
	BRETON(3,"Breton"),
	DUNMER(4,"Dunmer"),
	IMPERIAL(5,"Imperial"),
	KHAJIIT(6,"Khajiit"),
	NORD(7,"Nord"),
	ORC(8,"Orc"),
	REDGUARD(9,"Redguard");
	
	private final int id;
	private final String label;
	
	RaceEnum(int id, String label) {
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
