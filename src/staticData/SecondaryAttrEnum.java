package staticData;

public enum SecondaryAttrEnum {
	STRENGTH(0,"Strength","+20 Carry Weight, +5 Unarmed Damage, Melee attacks do 5% more damage."),
	ENDURANCE(1,"Endurance","Power Attacks require 10% less stamina, Stamina Regen increasesd by 10%, Block 5% more damage."),
	INTELLIGENCE(2,"Intelligence","Spellcost reduced by 5%, Magicka Regen increasesd by 10%, Spells are 5% stronger."),
	WILLPOWER(3,"Willpower","Power Attacks require 10% less stamina, Magicka Regen increasesd by 5%, Stamina Regen increased by 5%, Resist 5% Magicka."),
	AGILITY(4,"Agility","Resist Stagger 10%, Critical hit chance increased by 5%, Ranged attacks deal 5% more damage."),
	SPEED(5,"Speed","Movement speed increased 10%, 5% chance to dodge incoming damage, Attack speed increased by 5%."),
	PERSONALITY(6,"Personality","Persuasion & intimidation chance increased by 10%, Buying & Selling prices improved by 5%, Bribe costs are 10% lower.");
	
	public static final String LABEL = "Secondary Attribute"; 
	
	private final int id;
	private final String label;
	private final String description;
	
	SecondaryAttrEnum(int id, String label, String description) {
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
