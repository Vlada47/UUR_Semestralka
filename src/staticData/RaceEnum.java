package staticData;

public enum RaceEnum {		
	ALTMER(0,"Altmer",
			"Fortify Magicka +50; magicka regenerates up to 50% faster at the expense of stamina regeneration.  The higher your stamina, the faster your magicka regenerates (and the slower your stamina regeneration is).  As your stamina is depleted, more 'energy' goes into regenerating stamina and your magicka regen bonus decreases."),
	ARGONIAN(1,"Argonian",
			"Regenerate an additional 0.5% health per second; Waterbreathing; Swim 30% faster; 50% Resist Poison & Disease; Scales (base armor +50)."),
	BOSMER(2,"Bosmer",
			"Resist Disease (50%); Draw bow 10% faster, Tame any animal to make it a permanent follower (uses animal follower slot)."),
	BRETON(3,"Breton", 
			"Resist Magic 15%, Absorb 10% of magic from hostile spells."),
	DUNMER(4,"Dunmer",
			"Resist Fire: 50%, Ancestral Guardian: cast automatically in combat when health is less than 25%."),
	IMPERIAL(5,"Imperial",
			"Bribes cost 25% less, Prices are 10% better, Call to Arms: when in combat nearby Allies receive +10 points to their combat skills and to their health, stamina, and magicka."),
	KHAJIIT(6,"Khajiit",
			"Nightvision (now permanent/toggleable), Claws (increased unarmed damage), and Tred Softly (constant 50% muffle effect)."),
	NORD(7,"Nord",
			"Increased Armor Rating 5%, Resist Frost 50%."),
	ORC(8,"Orc",
			"Fortify Health +50, Melee damage increased by 5%, Berserk: auto casts at start of combat when not sneaking and lasts for 20 seconds (increases melee damage by 20% for 20sec, reduces incoming damage by 20%, and resist magic 10%)."),
	REDGUARD(9,"Redguard",
			"Resist Poison 25%, Weapon speed +10% faster, Adrenaline Rush: triggers in combat when health is below 25% (stamina regenerates 100% faster for 30 sec).");
	
	public static final String LABEL = "Race"; 
	
	private final int id;
	private final String label;
	private final String description;
	
	RaceEnum(int id, String label, String description) {
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