package staticData;

/**
 * Static class with general build constants.
 * @author Vlada47
 *
 */
public class BuildConstants {
	
	/**
	 * Number of playable races.
	 */
	public static final int RACES_COUNT = 10;
	
	/**
	 * Number of character's skills.
	 */
	public static final int SKILLS_COUNT = 18;
	
	/**
	 * Maximum level of the character.
	 */
	public static final int MAX_CHARACTER_LEVEL = 100;
	
	/**
	 * Minimal level of any skill.
	 */
	public static final int MIN_SKILL_LEVEL = 5;
	
	/**
	 * Maximal level of any skill.
	 */
	public static final int MAX_SKILL_LEVEL = 100;
	
	/**
	 * Base (unmodified) value for attributes (health/magicka/stamina).
	 */
	public static final int ATTRIBUTE_BASE = 100;
	
	/**
	 * Bonus for chosen primary attribute during character creation.
	 */
	public static final int PRIMARY_ATTRIBUTE_BONUS = 20;
	
	/**
	 * Health attribute modifiers for individual race and gender choices. Primary index - race, secondary index - gender. 
	 */
	public static final int[][] HEALTH_MODIFIERS = {{0,-5},{-10,-10},{5,5},{-10,-10},{-5,-5},{5,0},{-10,-10},{15,10},{20,15},{5,5}};
	
	/**
	 * Magicka attribute modifiers for individual race and gender choices. Primary index - race, secondary index - gender. 
	 */
	public static final int[][] MAGICKA_MODIFIERS = {{25,25},{0,5},{-5,0},{20,20},{10,10},{-5,0},{0,0},{-25,-25},{-20,-20},{-20,-15}};
	
	/**
	 * Stamina attribute modifiers for individual race and gender choices. Primary index - race, secondary index - gender. 
	 */
	public static final int[][] STAMINA_MODIFIERS = {{-25,-20},{10,5},{0,-5},{-10,-10},{-5,-5},{0,0},{10,10},{10,15},{0,5},{15,10}};
	
	/**
	 * Skill modifiers (which set up skill's starting level) for individual races. Primary index - race, secondary index - skill.
	 */
	public static final int[][] SKILL_MODIFIERS = {{10,5,10,5,5,10,0,0,0,0,0,0,0,0,0,0,0,0},
													{5,0,0,0,5,0,0,0,0,0,0,0,10,5,10,5,0,5},
													{0,0,0,0,0,0,0,0,0,0,0,15,10,5,5,0,0,10},
													{5,10,0,10,10,0,0,0,0,0,0,0,0,0,0,0,5,5},
													{5,0,10,0,0,5,0,0,0,0,10,5,5,5,0,0,0,0},
													{0,0,0,5,0,5,0,10,5,0,5,0,0,0,0,0,15,0},
													{0,0,0,0,0,0,0,0,0,0,0,0,10,15,10,10,0,0},
													{0,0,0,0,0,0,5,10,10,10,5,0,0,0,0,0,0,0},
													{0,0,0,0,0,0,10,15,10,5,5,0,0,0,0,0,0,0},
													{0,0,0,0,0,0,5,0,5,10,15,5,5,0,0,0,0,0}};
	
	/**
	 * Level-up experience multipliers for individual skills.
	 */
	public static final double[] SKILL_XP_MULTS = {0.8, 0.85, 1.0, 0.8, 0.8, 0.8, 0.7, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.6, 0.6, 0.6, 0.75};
	
	/**
	 * Level-up perk points for indicated levels (example - from level 7, the character will get 1.5 perk points per level).
	 */
	public static final double[][] PERK_LEVELUPS = {{2,2},{3,1.75},{7,1.5},{10,1.25},{20,2},{21,1.25},{40,2},{41,1.25},{60,2},{61,1.25},{80,0.5}};
	
	/**
	 * Level-up attribute points for indicated levels (example - from level 7, the character will get 15 attribute points per level).
	 */
	public static final int[][] ATTRIBUTE_LEVELUPS = {{2,20},{7,15},{10,10},{20,20},{21,10},{40,20},{41,8},{2,20},{60,20},{61,7},{81,5}};
}
