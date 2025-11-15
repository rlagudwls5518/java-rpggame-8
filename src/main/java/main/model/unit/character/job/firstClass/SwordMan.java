package main.model.unit.character.job.firstClass;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.Skill;
import main.model.unit.character.job.firstClass.skill.DefensiveStance;
import main.model.unit.character.job.firstClass.skill.PowerStrike;

public class SwordMan implements CharacterJob {
    @Override
    public String getJobName() {
        return "전사";
    }

    @Override
    public List<Skill> getSkillList() {
        return List.of(
                new PowerStrike(),
                new DefensiveStance()
        );
    }

    @Override
    public int getHpBonus() {
        return 50;
    }

    @Override
    public int getAttackBonus() {
        return 10;
    }

    @Override
    public boolean canAdvance(int currentLevel) {
        return false;
    }
}
