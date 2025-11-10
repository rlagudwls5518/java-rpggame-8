package main.model.unit.character.job.firstClass;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.skill.SkillInfo;

public class SwordMan implements CharacterJob {
    @Override
    public String getJobName() {
        return "";
    }

    @Override
    public List<SkillInfo> getSkillList() {
        return null;
    }

    @Override
    public int getHpBonus() {
        return 0;
    }

    @Override
    public int getAttackBonus() {
        return 0;
    }
}
