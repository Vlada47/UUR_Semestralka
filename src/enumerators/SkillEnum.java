package enumerators;

public enum SkillEnum {
	
	ILLUSION(0,"Illusion","N/A"),
	CONJURATION(1,"Conjuration","N/A"),
	DESTRUCTION(2,"Destruction","N/A"),
	RESTORATION(3,"Restoration","N/A"),
	ALTERATION(4,"Alteration","N/A"),
	ENCHANTING(5,"Enchanting","N/A"),
	SMITHING(6,"Smithing","N/A"),
	HEAVY_ARMOR(7,"Heavy Armor","N/A"),
	BLOCK(8,"Block","N/A"),
	TWO_HANDED(9,"Heavy Weaponry","N/A"),
	ONE_HANDED(10,"Light Weaponry","N/A"),
	ARCHERY(11,"Ranged Weaponry","N/A"),
	LIGHT_ARMOR(12,"Light Armor","N/A"),
	SNEAK(13,"Sneak","N/A"),
	LOCKPICKING(14,"Wayfarer","N/A"),
	PICKPOCKET(15,"Dexterity","N/A"),
	SPEECH(16,"Speechcraft","N/A"),
	ALCHEMY(17,"Alchemy","N/A");
	
	private final int id;
	private final String label;
	private final String description;
	
	SkillEnum(int id, String label, String description) {
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
}
