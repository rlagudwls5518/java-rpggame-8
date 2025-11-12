package main.model.unit.character.job.secondClass;

import java.util.ArrayList;
import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.SkillInfo;
import main.model.unit.character.job.firstClass.skill.PowerStrike;

public class Knight implements CharacterJob {
    @Override
    public String getJobName() {
        return "기사";
    }

    @Override
    public List<SkillInfo> getSkillList() {
        List<SkillInfo> skills = new ArrayList<>();
        skills.add(new PowerStrike());
        return skills;
    }

    @Override
    public int getHpBonus() {
        return 50;
    }

    @Override
    public int getAttackBonus() {
        return 5;
    }
}
