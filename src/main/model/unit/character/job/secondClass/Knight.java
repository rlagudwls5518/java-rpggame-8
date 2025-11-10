package main.model.unit.character.job.secondClass;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.skill.SkillInfo;

public class Knight implements CharacterJob {
    @Override
    public String getJobName() {
        return "기사";
    }

    @Override
    public List<SkillInfo> getSkillList() {
        return List.of();
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
