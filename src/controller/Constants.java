package controller;

public class Constants {
	
	//general constants
	public static final int RACES_COUNT = 10;
	public static final int SKILLS_COUNT = 18;
	public static final int MAX_CHARACTER_LEVEL = 100;
	public static final int MIN_SKILL_LEVEL = 5;
	public static final int MAX_SKILL_LEVEL = 100;
	public static final int ATTRIBUTE_MINIMUM = 100;
	public static final int CARRY_WEIGHT_MINIMUM = 300;
	public static final int PRIMARY_ATTRIBUTE_BONUS = 20;
	
	//points level distribution constants
	public static final int[] ATTRIBUTE_POINTS = new int[MAX_CHARACTER_LEVEL];
	public static final int[] CARRY_WEIGHT_POINTS = new int[MAX_CHARACTER_LEVEL];
	public static final int[] PERK_POINTS = new int[MAX_CHARACTER_LEVEL];
	
	//races (males/females) attributes modifiers
	public static final int[][] HEALTH_MODIIFIERS = new int[2][RACES_COUNT];
	public static final int[][] STAMINA_MODIIFIERS = new int[2][RACES_COUNT];
	public static final int[][] MAGICKA_MODIIFIERS = new int[2][RACES_COUNT];
	public static final int[][] CARRY_WEIGHT_MODIIFIERS = new int[2][RACES_COUNT];
	
	//races skill bonuses
	public static final int[][] RACE_SKILL_BONUSES = new int[10][18];
}
