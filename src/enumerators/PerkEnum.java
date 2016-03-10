package enumerators;

public enum PerkEnum {
	
	TEST_PERK_0001(0,"Test Perk","N/A",3, SkillEnum.ILLUSION, new int[]{20,40,60},null),
	TEST_PERK_0002(0,"Test Perk","N/A",1, SkillEnum.ILLUSION, new int[]{45},new PerkEnum[]{TEST_PERK_0001});
	
	private final int id;
	private final String label;
	private final String description;
	private final int maxLevel;
	private final SkillEnum skill;
	private final int[] skillLevels;
	private final PerkEnum[] requieredPerks;
	
	
	PerkEnum(int id, String label, String description, int maxLevel, SkillEnum skill, int[] skillLevels, PerkEnum[] requieredPerks) {
		this.id = id;
		this.label = label;
		this.description = description;
		this.maxLevel = maxLevel;
		this.skill = skill;
		this.skillLevels = skillLevels;
		this.requieredPerks = requieredPerks;
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

	public int getMaxLevel() {
		return maxLevel;
	}
	
	public SkillEnum getSkill() {
		return this.skill;
	}

	public int[] getSkillLevels() {
		return skillLevels;
	}
	
	public PerkEnum[] getRequieredPerks() {
		return requieredPerks;
	}
}
