package staticData;

public class BuildConstants {
	
	//general constants
	public static final int RACES_COUNT = 10;
	public static final int SKILLS_COUNT = 18;
	public static final int MAX_CHARACTER_LEVEL = 100;
	public static final int MIN_SKILL_LEVEL = 5;
	public static final int MAX_SKILL_LEVEL = 100;
	public static final int ATTRIBUTE_BASE = 100;
	public static final int PRIMARY_ATTRIBUTE_BONUS = 20;
	
	//races (males/females) attributes modifiers
	public static final int[][] HEALTH_MODIFIERS = {{0,-5},{-10,-10},{5,5},{-10,-10},{-5,-5},{5,0},{-10,-10},{15,10},{20,15},{5,5}};
	public static final int[][] MAGICKA_MODIFIERS = {{25,25},{0,5},{-5,0},{20,20},{10,10},{-5,0},{0,0},{-25,-25},{-20,-20},{-20,-15}};
	public static final int[][] STAMINA_MODIFIERS = {{-25,-20},{10,5},{0,-5},{-10,-10},{-5,-5},{0,0},{10,10},{10,15},{0,5},{15,10}};
	public static final int[][] CARRY_WEIGHT_MODIFIERS = {{-15,-20},{5,-10},{-20,-25},{-15,-30},{0,-20},{0,-20},{-10,-30},{20,5},{25,15},{5,-20}};
	
	//races skill bonuses
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
	
	public static final double[] SKILL_XP_MULTS = {0.8, 0.85, 1.0, 0.8, 0.8, 0.8, 0.7, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.6, 0.6, 0.6, 0.75};
	
	public static final double[][] PERK_LEVELUPS = {{2,2},{3,1.75},{7,1.5},{10,1.25},{20,2},{21,1.25},{40,2},{41,1.25},{60,2},{61,1.25},{80,0.5}};
	public static final int[][] ATTRIBUTE_LEVELUPS = {{2,20},{7,15},{10,10},{20,20},{21,10},{40,20},{41,8},{2,20},{60,20},{61,7},{81,5}};
}
