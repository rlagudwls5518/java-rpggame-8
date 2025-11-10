package main.model.unit.character.job.firstClass;

import java.util.ArrayList;
import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.skill.SkillInfo;
import main.model.unit.character.skill.passive.PassiveSkill;

public class SwordMan implements CharacterJob {
    @Override
    public String getJobName() {
        return "전사";
    }

    @Override
    public List<SkillInfo> getSkillList() {
        List<SkillInfo> skills = new ArrayList<>();
        skills.add(new PassiveSkill());

        return skills;
    }

    @Override
    public int getHpBonus() {
        return 50;
    }

    @Override
    public int getAttackBonus() {
        return 10;
    }
}
