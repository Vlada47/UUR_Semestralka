package staticData;

public enum BirthsignEnum {
	APPRENTICE(0,"The Apprentice"),
	ATRONACH(1,"The Atronach"),
	LADY(2,"The Lady"),
	LORD(3,"The Lord"),
	LOVER(4,"The Lover"),
	MAGE(5,"The Mage"),
	SERPENT(6,"The Serpent"),
	STEED(6,"The Steed"),
	THIEF(6,"The Thief"),
	TOWER(6,"The Tower"),
	WARRIOR(6,"The Warrior");
	
	private final int id;
	private final String label;
	
	BirthsignEnum(int id, String label) {
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
