package main.model.unit.character.job.finalClass.holyKnight;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.Skill;

public class HolyKnight implements CharacterJob {
    @Override
    public String getJobName() {
        return "성검사";
    }

    @Override
    public List<Skill> getSkillList() {
        return List.of();
    }

    @Override
    public int getHpBonus() {
        return 300;
    }

    @Override
    public int getAttackBonus() {
        return 15;
    }
}
