package main.model.unit.character.job.firstClass;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.Skill;
import main.model.unit.character.job.firstClass.skill.DummFist;
import main.model.unit.character.job.firstClass.skill.PowerStrike;
import main.model.unit.character.job.secondClass.Knight;

public class SwordMan implements CharacterJob {
    private static final int ADVANCE_LEVEL = 10;

    @Override
    public String getJobName() {
        return "전사";
    }

    @Override
    public List<Skill> getSkillList() {
        return List.of(
                new PowerStrike(),
                new DummFist()
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
        return currentLevel >= ADVANCE_LEVEL;
    }

    @Override
    public CharacterJob advance(int choice) {
        if (choice == 1) {
            return new Knight();
        }
        return null;
    }

    @Override
    public List<CharacterJob> getAdvancementOptions() {
        return List.of(new Knight());
    }

    @Override
    public int getJobAdvancementTier() {
        return 0;
    }
}
