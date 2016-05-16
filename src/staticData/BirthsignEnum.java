package staticData;

/**
 * Enumerator for individual birthsigns.
 * @author Vlada47
 *
 */
public enum BirthsignEnum {
	APPRENTICE(0,"The Apprentice","Regenerate Magicka (100%), Weakness to Magicka (50%)."),
	ATRONACH(1,"The Atronach","Fortify Magicka (+150), Spell Absorption (50%), No Magicka Regeneration."),
	LADY(2,"The Lady","Regenerate Health (15%), Regenerate Stamina (25%), Regenerate Magicka (25%)."),
	LORD(3,"The Lord","Armor Rating (+75), Resist Magic (15%)."),
	LOVER(4,"The Lover","Fortify Speech (+20), Critical Hit Chance (+10%), Absorb Stamina from combat targets."),
	MAGE(5,"The Mage","Spells are 10% more effective."),
	RITUAL(6,"The Ritual","Ritual power changed to Lesser Power, duration decreased, and it now costs 100 health to cast."),
	SERPENT(7,"The Serpent","Resist Poison (50%), Created poisons are 10% stronger, and Poisons applied to weapons last for 1 additional hit."),
	SHADOW(8,"The Shadow","10% harder to detect when sneaking, Muffle 10%, plus original once daily invisibility power."),
	STEED(9,"The Steed","Movement speed (10%), Carry weight (+100)."),
	THIEF(10,"The Thief","Luck (10%)."),
	TOWER(11,"The Tower","Reduce stagger (20%), automatically unlock all Novice or Apprentice locks, once daily unlock one Expert or Adept lock."),
	WARRIOR(12,"The Warrior","Physical damage increased by 10%.");
	
	public static final String LABEL = "Birthsign"; 
	
	/**
	 * ID of the birthsign.
	 */
	private final int id;
	
	/**
	 * Name of the birthsign.
	 */
	private final String label;
	
	/**
	 * Description of the birthsign.
	 */
	private final String description;
	
	BirthsignEnum(int id, String label, String description) {
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
