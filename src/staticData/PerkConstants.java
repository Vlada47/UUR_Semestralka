package staticData;

/**
 * Static class with constant values for individual perks of all skills.
 * @author Vlada47
 *
 */
public class PerkConstants {
	
	/**
	 * Names of individual perks for all skills. Primary index = skill, secondary index = perk. 
	 */
	public static final String[][] PERK_LABELS = {
			{"Studies: Novice Illusion","Studies: Apprentice Illusion","Studies: Adept Illusion","Studies: Expert Illusion","Studies: Master Illusion","Deep Analysis","Unknowable Horror","Debilitating Terror","Invigorate","Transcendental Mantle","Soothing Voice","Subjugation","Raging Heart","Maniacal Surge","Quiet Casting","Hallucinating Echoes","Waning Presence","Retaliating Echoes","Vessel","Phantom Host","Recursive Insanity","Focus: The Minddweller","Focus: The Puppetmaster"},
			{"Studies: Novice Conjuration","Studies: Apprentice Conjuration","Studies: Adept Conjuration","Studies: Expert Conjuration","Studies: Master Conjuration","Advanced Summoning","Ancient Rites","Harvest","Bone Mastery","Bone Conservation","Great Bone Mastery","Tongues of Old","Gravebound","Recurring Nightmare","Elemental Potency","Oblivion Binding","Chaotic Binding","Reclaim","Daedric Shell","Promise of Power","Elemental Fury","Synergetic Link","Pact","Focus: The Gatekeeper","Focus: The Necromage"},
			{"Studies: Novice Destruction","Studies: Apprentice Destruction","Studies: Adept Destruction","Studies: Expert Destruction","Studies: Master Destruction","Ambitious Methods","Geomancy","Defiant Concentration","Sigil of Flame","Cradle of Fire","Sigil of Ice","Pristine Frost","Sigil of Thunder","Primordial Thunder","Conflagration","Pyromancer's Contract","Raging Inferno","Arcane Conduit","Electromancer's Contract","Battery","Absolute Zero","Cryomancer's Contract","Chill of Death","Focus: The Elementalist","Focus: The Siege Mage"},
			{"Studies: Novice Restoration","Studies: Apprentice Restoration","Studies: Adept Restoration","Studies: Expert Restoration","Studies: Master Restoration","Purification","Regrowth","Respite","Auramancer","Life and Death","Ward Deflect","Ward Absorb","Carrier","Plaguelord","Malediction","Tortured Soul","Meditation","Defy Death","Focus: The Idol","Focus: The Defiler"},
			{"Studies: Novice Alteration","Studies: Apprentice Alteration","Studies: Adept Alteration","Studies: Expert Alteration","Studies: Master Alteration","Mage's Toolbox","Mindforge","Mindcutter","Spellweaver","Spellbinder","Mage Armor","Second Skin","Arcana Body","Sacrificial Casting","Lifelink","Flesh to Power","Kinetic Crush","Blink","Chronokinesis","Focus: The Spherebender","Focus: The Creator","Architect of Magic"},
			{"Enchanter","Basic Scripture","Advanced Scripture","Elaborate Scripture","Sage's Scripture","Split Enchant","Soul Siphon","Soul Squeezer","Arcane Archery","Echanted Quiver","Staffaire","Channeler","Animate Weapon","Combat Enchanter","Spell Surge","Focus: Great Infusion"},
			{"Craftsman","Material: Leather","Material: Moonstone","Material: Corundum","Material: Malachite","Material: Dragons","Material: Steel","Material: Dwarven Metal","Material: Orichalcum","Material: Ebony","Material: Daedra","Material: Gold and Silver","Material: Refined Silver","Copycat","Meltdown","Armorer","Weaponsmith","Animunculi","Mass Prodution","Repair Unit","Hunting Grounds","Inexorable Grip","Legcutter","Mastery: Warforged"},
			{"Conditioning","Exploit Weakness: Heavy","Deflective Cage","Against All Odds","Unbreakable","Monolith","Stalwart Defense","Just Rage","Unshakeable","Bull's Charge","Juggernaut","Stone Wall","Ancient Bulwark","Heavy Lifting","Secure Shell","Mind Cage","Mastery: Unyielding Tower"},
			{"Safeguard","Quick Reflexes","Replenish","Shatter","Shove","Dispel","Overwhelm","Sanctuary","Exhaust","Riposte","Debilitating Bash","Power Bash","Blunt Supremacy","Block Runner","Shield Charge","Mastery: Last Stand"},
			{"Heavy Weapon Combat","Heavy Weapon Handling","Great Critical Charge","Savage Strikes","Beatdown","Sweep","Warbringer","Perfect Precision","Wallbreaker","Crushing Impact","Open Wound","Heart Seeker","Boiling Point","Scarred","Reaper's Verdict","Great Cleave","Final Breaker","Reaper's Gambit","Mastery: Warrior Heart"},
			{"Light Weapon Combat","Light Weapon Handling","Critical Charge","Proficient Strikes","Skilled Slashes","Dual Wield","Elemental Twister","Savage Storm","Counter","Blunt Impact","Clear Cut","Piercing Thrust","Blindside","Penetrate","Dervish","Blood Price","To Black","Rising Wings","Mastery: Combat Sense"},
			{"Eagly Eye","Point Blank","Mobility","Flanking","Prominent Flanker","Arrowhail","Power Draw","Keene's Lance","Baneful Elan","Prey","Takedown","Advanced Missilecraft","Aspiring Engineer","Proficient Engineer","Crossbow Technician","Coup De Grace","Mastery: Skillshot"},
			{"Nimble Warfare","Prodigy: The Wind Walker","Avoidance","Exploit Weakness: Light","Thick Padding","Agility","Clear Mind","Disjunct Dispersion","Swiftness","Free Movement","Endeavor","Reckless Abandon","Secure Grip","Adrenaline Rush","Potential","Adrenaline Overload","Killing Spree"},
			{"Stealth","Prodigy: The Infiltrator","Muffled Movement","Blackjack","Spinebreaker","Light Foot","Infiltrator","Last Breath","Silent Roll","Thief's Toolbox","Chameleon","Shadowbound","Nocturnal's Refuge","Arcane Assassin","Malevolent Touch","Opportunist","Anatomy","Ambush","Assassinate"},
			{"Traveller","Prodigy: The Beastmaster","Gatherer","Green Thumb","Lore: Lesser Creatures","Tracking","Camouflage","Chosen Fiend","Wild Companion","Lore: Predators","Harmony","Lore: Forces of Nature","As One","Forerunner","Lore: Solstheim","Lore: Foreign Armor","Lore: Cavedwellers","Lore: Mountainous Monsters","Lore: Humanoids"},
			{"Sleight of Hand","Prodigy: The Pilferer","Unburdened","Infest","Inventor","Utility Belt","Snatch","Monkey Grip","Removing the Scaffold","Open Sesame","Secrecy","Nose for Coin","Greed","Treasure Hunter","Unarmed","Ace's Mark","Conviction"},
			{"Linguist","Prodigy: The Diplomat","Eloquence","Bribery","Disarming Charisma","Masquerade","Grand Facade","Affection","Battle Anthem","Heroism","Lasting Impression","Leadership","Loyalty","Strength in Numbers","Merchant","Investor","Fence","Master Trader","Fluent Speaker","Ancient Magic"},
			{"Alchemist","Prodigy: The Tinkerer","Adhesive Explosives","Elemental Burst","Fuse","Elemental Bombard","Advanced Eplosives","Skilled Enhancer","Distillation","Poison Burst","Venomous Coercion","Poison Armor","Overdose","Physician","Overstimulation","Mutation","Fast Metabolism","Field Alchemy","Purity"}
	};
	
	/**
	 * Maximum level values for individual perks of all skills. Primary index = skill, secondary index = perk.
	 */
	public static final int[][] PERK_MAX_LEVELS = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
			{ 1, 1, 1, 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1},
			{ 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{ 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1},
			{ 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1},
			{ 2, 1, 1, 1, 1, 1, 2, 1, 1, 3, 1, 2, 1, 1, 2, 1},
			{ 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 2, 2, 1, 1},
			{ 3, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1},
			{ 2, 2, 2, 1, 1, 1, 1, 2, 3, 2, 2, 1, 1, 1, 1, 1},
			{ 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1},
			{ 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1},
			{ 3, 2, 1, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 1},
			{ 3, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2},
			{ 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 2, 2, 2, 2, 1},
			{ 2, 1, 2, 1, 1, 2, 1, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{ 2, 1, 2, 1, 3, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1},
			{ 2, 1, 1, 1, 2, 1, 1, 2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 2, 2},
			{ 3, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1}
	};
	
	/**
	 * Required skill level for individual levels of individual perks of all skills.
	 * Primary index = skill, secondary index = perk, tertiary index = perk level.
	 */
	public static final int[][][] PERK_SKILL_LEVELS = {
			{{0},{20},{40},{65},{90},{20},{15},{40},{15},{55},{35},{65},{55},{75},{70},{30},{50},{40,55},{75},{70},{90},{95},{95}},
			{{0},{20},{40},{65},{90},{35},{50},{15,40},{25,45,65},{40},{90},{50},{45},{75},{20},{40},{50,65},{30,50},{45},{60},{40},{60},{75},{95},{95}},
			{{0},{20},{40},{65},{90},{15},{50,80},{25,55},{30},{45},{30},{45},{30},{45},{70},{75},{85},{70},{75},{85},{70},{75},{85},{95},{95}},
			{{0},{20},{40},{65},{90},{30},{20},{55},{30,50},{50,80},{30,45},{50},{45,65},{50,80},{50,75},{70},{70,80},{95},{95},{95}},
			{{0},{20},{40},{65},{90},{25},{30},{60},{25,45},{40},{30},{60},{95},{45},{65},{85},{50},{45,75},{80,95},{95},{95},{100,100}},
			{{0,50},{15},{30},{45},{70},{40},{25,50},{40},{25},{40,60,80},{40},{50,70},{35},{60},{75,90},{95}},
			{{0,50},{20},{35},{50},{70},{90},{20},{35},{50},{70},{90},{30},{45},{55},{25},{40},{40},{35,55,80},{70},{45},{30,55},{40,70},{70},{50}},
			{{0,30,60},{30},{20,35},{40,55},{60},{80},{20,35},{40,55},{60},{80},{40,75},{30},{50},{40,75},{65},{50},{95}},
			{{0,40},{25,55},{35,70},{50},{55},{50},{55},{20,40},{35,55,75},{45,75},{20,50},{40},{60},{65},{80},{95}},
			{{0,40},{20},{30},{45},{60},{35},{50},{55},{85},{20,45},{25},{20,45},{60},{60},{60},{80},{80},{80,90},{95}},
			{{0,40},{20},{25},{30},{45},{20,40},{35},{55},{70},{25,50},{25,50},{25,50},{45,65},{60},{60},{80},{80},{80},{95}},
			{{0,30,60},{20,45},{40},{50,70},{60},{70,95},{20,40},{30,50},{45,65},{60},{70,85},{20,35},{40,55},{50,65},{80},{90},{95}},
			{{0,30,60},{20},{20,40},{30},{30},{40,75},{45},{45},{50},{55},{55,85},{55,90},{60},{60},{70},{75},{80,95}},
			{{0,50},{20},{30},{40},{65},{30,60},{45},{60},{40},{50,60},{50},{70,95},{85},{60},{70,90},{50,80},{55,75},{70,85},{95}},
			{{0,30},{20},{25,50},{50},{20},{25,45},{45},{30,50,70},{30,50},{35},{70},{40},{60},{70},{55},{60},{60},{80},{90}},
			{{0,40},{20},{25,55},{25},{30,45,60},{40},{40},{60},{80},{30},{45},{35,50},{50},{40,60},{55},{80},{95}},
			{{0,45},{20},{20},{30},{35,55},{50},{95},{40,80},{20},{30,45},{70,85},{35},{45},{60,90},{40},{50},{70},{85},{35,65},{50,75}},
			{{0,30,60},{20},{35},{35},{60},{60},{75},{80,95},{25,65},{40},{50},{35},{70},{25,45},{50},{40},{50},{70},{90}}
	};
	
	/**
	 * Indexes of perks, which counts as predecessors for individual perks of all skills.
	 * Primary index = skill, secondary index = perk, tertiary index = predecessor perk index.
	 */
	public static final int[][][] PERK_REQ_PERKS = {
			{{-1},{0},{1},{2},{3},{0},{0},{6},{0},{8},{1},{10},{2},{12},{3},{1},{2,15},{15},{3,16,17},{17},{18},{19},{7,9,11,13}},
			{{-1},{0},{1},{2},{3},{1},{2},{0},{7},{8},{9},{7},{11},{12},{0},{14},{15},{14},{17},{16,18},{14},{20},{19,21},{22},{10,13}},
			{{-1},{0},{1},{2},{3},{0},{2},{0},{1},{8},{1},{10},{1},{12},{3},{14},{14},{3},{17},{17},{3},{20},{20},{4},{4}},
			{{-1},{0},{1},{2},{3},{0},{0},{6},{1},{8},{1},{10},{2},{12},{2},{14},{3},{4},{7,9},{13,15}},
			{{-1},{0},{1},{2},{3},{0},{1},{6},{1},{8},{0},{10},{11},{2},{13},{14},{2},{2},{16,17},{18},{7,11,15},{4}},
			{{-1},{0},{1},{2},{3},{2},{0},{0},{1},{8},{2},{10},{1},{12},{4,9,11,13},{14}},
			{{-1},{0},{1},{2},{3},{4},{0},{6},{7},{8},{9},{0},{11},{11},{0},{14},{14},{7},{17},{17},{0},{20},{20},{15,16}},
			{{-1},{0},{0},{2},{3},{4},{0},{6},{7},{8},{2,6},{10},{11},{10},{13},{10},{5,9}},
			{{-1},{0},{1},{1},{3},{1},{5},{0},{7},{8},{0},{10},{11},{8,11},{13},{14}},
			{{-1},{0},{1},{1},{2,3},{0},{5},{5},{6,7},{0},{0},{0},{9,10},{10,11},{9,11},{12,13},{12,14},{13,14},{15,16,17}},
			{{-1},{0},{1},{1},{2,3},{0},{5},{5},{6,7},{0},{0},{0},{10,11},{9,10},{9,11},{12,13},{13,14},{12,14},{15,16,17}},
			{{-1},{0},{1},{2},{3},{4},{0},{6},{7},{8},{9},{0},{11},{12},{13},{5,10,14},{15}},
			{{-1},{0},{0},{2},{2},{4},{5},{3,4},{5,7},{6,8},{6},{8},{9,10},{9,11},{12,13},{13},{14,15}},
			{{-1},{0},{0},{2},{3},{0},{5},{6},{2,5},{8},{8},{10},{11},{10},{13},{8},{15},{15},{17}},
			{{-1},{0},{0},{2},{0},{4},{5},{4},{4},{4},{9},{4},{11},{12},{9},{14},{9,11},{16},{16}},
			{{-1},{0},{0},{0},{3},{4},{3},{6},{7},{0},{9},{9},{11},{11},{3,9},{14},{14}},
			{{-1},{0},{0},{2},{3},{4},{5},{3},{0},{8},{9},{8},{11},{12},{3},{14},{15},{16},{0},{18}},
			{{-1},{0},{0},{0},{2,3},{2,3},{4,5},{4,5},{0},{8},{8},{8},{11},{0},{13},{13},{13},{16},{6,7,12,17}}
		};
}
