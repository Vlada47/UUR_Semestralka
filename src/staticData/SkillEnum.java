package staticData;

public enum SkillEnum {
	
	ILLUSION(0,"Illusion"),
	CONJURATION(1,"Conjuration"),
	DESTRUCTION(2,"Destruction"),
	RESTORATION(3,"Restoration"),
	ALTERATION(4,"Alteration"),
	ENCHANTING(5,"Enchanting"),
	SMITHING(6,"Smithing"),
	HEAVY_ARMOR(7,"Heavy Armor"),
	BLOCK(8,"Block"),
	TWO_HANDED(9,"Heavy Weaponry"),
	ONE_HANDED(10,"Light Weaponry"),
	ARCHERY(11,"Ranged Weaponry"),
	LIGHT_ARMOR(12,"Light Armor"),
	SNEAK(13,"Sneak"),
	LOCKPICKING(14,"Wayfarer"),
	PICKPOCKET(15,"Dexterity"),
	SPEECH(16,"Speechcraft"),
	ALCHEMY(17,"Alchemy");
	
	private final int id;
	private final String label;
	
	SkillEnum(int id, String label) {
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
