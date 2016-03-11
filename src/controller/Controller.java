package controller;

import model.CharacterBuild;
import model.Perk;
import model.Skill;
import staticData.BuildConstants;
import staticData.PerkConstants;
import staticData.SkillEnum;

public class Controller {
	
	private static CharacterBuild characterBuild;
	
	public static void createBuild() {
		characterBuild = null;
		characterBuild = new CharacterBuild(createCharacterSkills());
	}
	
	private static Skill[] createCharacterSkills() {
		Skill[] skills = new Skill[BuildConstants.SKILLS_COUNT];
		
		for(SkillEnum skill : SkillEnum.values()) {
			skills[skill.getId()] = new Skill(skill);
		}
		
		return skills;
	}
	
	public static void createCharacterPerks() {
		Skill[] skills = characterBuild.getSkills();
		
		for(Skill skill : skills) {
			skill.setPerks(createSkillPerks(skill.getSkillInstance().getId()));
		}
	}
	
	private static Perk[] createSkillPerks(int skillIndex) {
		Perk[] perks = new Perk[PerkConstants.PERK_LABELS[skillIndex].length];
		
		for(int i = 0; i < perks.length; i++) {
			perks[i] = new Perk(PerkConstants.PERK_LABELS[skillIndex][i], PerkConstants.PERK_MAX_LEVELS[skillIndex][i], PerkConstants.PERK_SKILL_LEVELS[skillIndex][i], PerkConstants.PERK_REQ_PERKS[skillIndex][i]);
		}
		
		return perks;
	}
	
	public static void setBuild(CharacterBuild charBuild) {
		characterBuild = null;
		characterBuild = charBuild;
	}

}
