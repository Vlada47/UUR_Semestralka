package view;

public class HelpTexts {
	
	public static final String ROOT_CONTENT = "<h2>Choose the topic from the menu...</h2>";
	
	public static final String ABOUT_CONTENT = "<p>This application was made as a semestral project for KIV/UUR subject</p>"
												+ "<p><b>Author: Vladimír Láznièka</b> (laznickav@hotmail.cz)</p>";
	
	public static final String GUIDE_CONTENT = "<p>This sub-menu contains a guide to both character building rules and application manual.</p>";
	
	public static final String BUILDING_RULES_CONTENT = "<p>This sub-menu contains information about individual sections of character building process. "
															+ "Its topics should give you necessary pieces of information about background rules "
															+ "that are used in <b><i>The Elder Scrolls: Skyrim</i> modded with <i>Perkus Maximus</i> perk overhaul "
															+ "and <i>Disparity</i> character creation overhaul</b>.</p>"
															+ "<h3>Perkus Maximus:</h3>"
															+ "<p>This mod overhauls individual skill trees, perks and some combat mechanics. "
															+ "This application is made with all <i>PerMa</i> modules in mind. You can find the mod "
															+ "<a href=\"http://www.nexusmods.com/skyrim/mods/59849/?\">here</a>.</p>"
															+ "<h3>Disparity:</h3>"
															+ "<p>This mod overhauls races, their abilities and character creation in general. "
															+ "This application currently counts with all <i>disparity</i> (race, gender...) options on "
															+ "and with initial skill bonuses set to <i>modifiers</i> option. "
															+ "You can find the mod <a href=\"http://www.nexusmods.com/skyrim/mods/63354/?\">here</a>.</p>";
	
	public static final String TERMS_CONTENT = "<h2>Character building - terms</h2>"
												+ "<p>This part contains information about certain terms that are used in character building and the application.</p> "
												+ "<h3>Attribute</h3>"
												+ "<p>Attributes are the main character properties. There are 3 primary attributes: "
												+ "<ul>"
												+ "<li><b>Health</b> - tells us, how much damage can character take before dying.</li>"
												+ "<li><b>Magicka</b> - is being used during spellcasting and character can't cast aby magicka-cost spells without its sufficient amount.</li>"
												+ "<li><b>Stamina</b> - is being used during certain physical activities like attacking or sprinting. Character can't use <i>power attacks</i> or sprint "
												+ "without some stamina left and can be severly slowed down.</li>"
												+ "</ul>"
												+ "Secondary attributes consist of properites like <i>strength</i> or <i>intelligence</i>, which offers small bonuses to the character and can reinforce certain playstyle.</p>"
												+ "<h3>Race</h3>"
												+ "<p>There are 10 playable races in total and each has different starting amount of attributes and affinity to certain skills. "
												+ "Each race also comes with its signature abilities and other bonuses. Character's race can greatly reinforce chosen playstyle, "
												+ "for example - Altmers are usually great spellcasters, while Nords are suitable for a warrior.</p>"
												+ "<h3>Gender</h3>"
												+ "<p>Gender of the character (male or female) can bring different bonuses and maluses. "
												+ "Males usually have more health and are more physically adept, while females have more magicka and offer better persuation chances.</p>"
												+ "<h3>Specialization</h3>"
												+ "<p>There are 3 specialization in the game - <i>combat</i>, <i>magic</i> and <i>stealth</i>. "
												+ "Choosing a specialization makes related skills level faster.</p>"
												+ "<h3>Birthsign</h3>"
												+ "<p>Character can have one of the 13 possible birthsigns. They can offer bonuses to certain properties of the character "
												+ "or give some special powers, while having some negative effects as well.</p>"
												+ "<h3>Skill</h3>"
												+ "<p>The term skill denotes one of the 18 skills, which every Skyrim character can develop. "
												+ "A skill is linked with one or more gaming activities - like <i>Heavy Weaponry</i> skill is being linked to usage of two-handed melee weapons. "
												+ "Improvement of the skill is made by doing relevant activity and is being shown as current level of that skill.</p>"
												+ "<h3>Perk</h3>"
												+ "<p>Each skill offers certain amount of perks, which give some extra bonuses and properties to the usage of those skills. "
												+ "Perks are organized into tree structures, which creates dependencies of stronger perks on related weaker perks. "
												+ "Character can also take more than one level of certain perks, taking more levels into the same perk makes it stronger. "
												+ "Each level in perk costs one <i>perk point</i>.</p>";
	
	public static final String BUILD_BASE_CONTENT = "<h2>Character building - creation</h2>"
													+ "<p>This part contains information about initial build creation, which practically takes place during the game's beginning.</p>"
													+ "<p>Player has to choose the <i>race</i>, <i>gender</i>, <i>primary and secondary attributes</i>, <i>specialization</i> and <i>birthsign</i>. "
													+ "These choices are final and can't be normally changed later during the game.</p>"
													+ "<p>Player also chooses bonuses to picked skills (100 points can distributed in +5/+10/+15/+20 points of bonus), "
													+ "which basically ups their effectiveness, but it doesn't affect the leveling (in the current application settings).</p>";
	
	public static final String BUILD_LEVELING_CONTENT = "<h2>Character building - leveling</h2>"
														+ "<p>This part informs about the process of build leveling, which is being done troughout the whole game.</p>"
														+ "<p>Character main level is being raised by increasing the level of individual skills. "
														+ "Leveling the skill by a certain amount cuases the main level to increment, while the amount of experience points (hidden number in the game) "
														+ "gained for increasing the skill level is greater for higher skill levels (character gets more XP from <i>Illusion</i> skill on level 80 than on level 50). "
														+ "Amount of XP gained is also multiplied by a set factor of individual skills (combat skills like <i>Heavy Weaponry</i> have this multiplier greater than non-combat ones like <i>Alchemy</i>) "
														+ "Also the amount of XP needed for the main level to increment grows with each gained level, so the leveling gradually slows down in generall.</p>"
														+ "<p>By gaining up more main levels, the character earns perk points, which can used for perk investment. "
														+ "The character can invest only in the perks, which has he the skill level big enough for. "
														+ "The amount of perk points gained per level can vary (with minimum of 1) depending on the actuall main level.</p>"
														+ "<p>For each main level gained, the player has to choose in what main attribute will he distribute some attribute points. "
														+ "The amount of those points also vary from level to level, but it is the same for all three attributes.</p>";
	
	public static final String APPLICATION_CONTENT = "<p>This sub-menu contains information about the usage of this application. "
													+ "Its topics are describing individual panes, tabs and control components and how to use them for application's purpose.</p>";
	
	public static final String MAIN_MENU_CONTENT = "<h2>Description of the Main Menu</h2>"
													+ "<p>The Main Menu is placed at the top of the application window. It contains following options:"
													+ "<ul>"
													+ "<li><b>New Build</b> - this serves as a starting point of the application, it creates a new instance of the character build and unlocks <i>Left Pane</i> and <i>General Tab</i> for initial character creation. It can be also use for \"deletion\" of the current build and start of a new one.</li>"
													+ "<li><b>Save Build</b> - allows to save the current state of the build as a serialization of the character build instance.</li>"
													+ "<li><b>Load Build</b> - allows to load saved state of the build from the file (object serialization).</li>"
													+ "<li><b>Warning Mode</b> - this check option signalizes, whether the application should use <i>alerts</i> to inform user about certain limitations throughout its usage.</li>"
													+ "<li><b>Exit Application</b> - this option will shut down the application.</li>"
													+ "</ul></p>";
	
	public static final String LEFT_PANE_CONTENT = "<h2>Description of the Left Pane</h2>"
													+ "<p>The Left Pane consits of two main parts - basic build numbers and notes. This component doesn't change during the switching of tabs so user can keep some overview on the build state.</p>"
													+ "<h3>Basic build numbers</h3>"
													+ "<p>This part of the pane consists of text fields displaying the current number of the build parameter labeled by the text on the left. The fields are not editable and are for display purposes only.</p>"
													+ "<h3>Notes</h3>"
													+ "<p>This section consits of one text area, which serves as place for any potentional notes of the user. Notes are saved by clicking the <b>Save notes</b> button under the text area.</p>";
	
	public static final String GENERAL_TAB_CONTENT = "<h2>Description of the General Tab</h2>"
														+ "<p>The General Tab is used for the basic setup of the build - it basically suplements the initial character creation in the game.</p>"
														+ "<h3>Properties</h3>"
														+ "<p>This section constists of combo boxes, in which the user can choose all the build initial properties like <i>race</i> or <i>specialization</i>. There two control buttons under combo boxes - <b>Confirm</b>, which saves the chosen values, locks the combo boxes plus itself and unlocks other tabs, and <b>Reset</b>, which does the opposite in the case user wants to start over.</p>"
														+ "<h3>Details</h3>"
														+ "<p>This part consists of one text area, which is for displaying of information (what bonuses the character gets) about individual properties in combo boxes. It displays current information, when user chnages the value in some combo box.</p>";
	
	public static final String SKILL_TAB_CONTENT = "<h2>Description of the Skills & Perks Tab</h2>"
													+ "<p>The Skills & Perks Tab services most of the leveling functionality of the application. It allows user to inrease the level of skills (thus increasing the main level) and then invest gained perk points into perks. The tab always displays status of one skill, which can be switched with control components.</p>"
													+ "<h3>Skill data section</h3>"
													+ "<p>This section consits of text field (not editable) displayed current skill level and most importantly - the table with perks, which has following columns:"
													+ "<ul>"
													+ "<li><b>Title</b> - labels the perk.</li>"
													+ "<li><b>Prerequisite perks</b> - lists all prerequisite perks (the player has to invest into at least one of those perks to access this one).</li>"
													+ "<li><b>Current level</b> - displays how many perk points were invested into this perk.</li>"
													+ "<li><b>Maximal level</b> - displays how many perk points can be invested into this perk.</li>"
													+ "<li><b>Skill level</b> - required skill level to be able to take this perk. For perks with multiple levels it lists the skill level requirement for each level.</li>"
													+ "</ul>"
													+ "To invest perk point into the perk, user has to <b>double-click with primary mouse button</b> on the row. To take the perk point from the perk, user has to <b>click with secondary mouse button</b> on the row. User can invest perk points even if the current number available is 0 (the count will negative in that case).</p>"
													+ "<h3>Control section</h3>"
													+ "<p>This section allows the user to switch to another skill with the combo box, increase skill level with <b>+</b> button, decrease skill level with <b>-</b> button and reset the whole skill (set level to starting value after confirming the build creation and remove all invested perk points from perks) with <b>Reset</b> button.</p>";
	
	public static final String ATTR_TAB_CONTENT = "<h2>Description of the Attributes Distribution Tab</h2>"
												+ "<p>The Attributes Distribution and its components take care of assigning attribute points given at each level up to chosen attributes.</p>"
												+ "<h3>Control section</h3>"
												+ "<p>This section consits of <b>+</b> and <b>-</b> buttons, which service points distribution to each of the main attributes. User can add points to specific attribute in case his character still has some from leveling up. When removing the distributed points from selected attribute, its last occurence in the table is removed (it works like a stack) and any newly added attribute distribution will be placed there instead.</p>"
												+ "<h3>Distribution table</h3>"
												+ "<p>This table displays information about how many attribute points went into which skill on each level.</p>";

}
