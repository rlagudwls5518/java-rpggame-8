package main.model.unit.character.job.finalClass.dragonKnight;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.SkillInfo;

public class DragonKnight implements CharacterJob {
    @Override
    public String getJobName() {
        return "용기사";
    }

    @Override
    public List<SkillInfo> getSkillList() {
        return List.of();
    }

    @Override
    public int getHpBonus() {
        return 150;
    }

    @Override
    public int getAttackBonus() {
        return 30;
    }
}
