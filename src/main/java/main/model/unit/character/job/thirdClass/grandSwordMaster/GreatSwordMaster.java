package main.model.unit.character.job.thirdClass.grandSwordMaster;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.Skill;

public class GreatSwordMaster implements CharacterJob {
    @Override
    public String getJobName() {
        return "대검사";
    }

    @Override
    public List<Skill> getSkillList() {
        return List.of();
    }

    @Override
    public int getHpBonus() {
        return 100;
    }

    @Override
    public int getAttackBonus() {
        return 10;
    }
}
