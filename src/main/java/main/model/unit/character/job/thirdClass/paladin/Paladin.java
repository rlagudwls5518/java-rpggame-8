package main.model.unit.character.job.thirdClass.paladin;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.Skill;
import main.model.unit.character.job.finalClass.holyKnight.HolyKnight;
import main.model.unit.character.job.thirdClass.paladin.skills.HolySword;
import main.model.unit.character.job.thirdClass.paladin.skills.ShieldBash;

public class Paladin implements CharacterJob {

    private static final int ADVANCE_LEVEL = 30;

    @Override
    public String getJobName() {
        return "성기사";
    }

    @Override
    public List<Skill> getSkillList() {
        return List.of(
                new HolySword(),
                new ShieldBash()
        );
    }

    @Override
    public int getHpBonus() {
        return 150;
    }

    @Override
    public int getAttackBonus() {
        return 5;
    }

    @Override
    public boolean canAdvance(int currentLevel) {
        return currentLevel >= ADVANCE_LEVEL;
    }

    @Override
    public CharacterJob advance(int choice) {
        return new HolyKnight();
    }

    @Override
    public List<CharacterJob> getAdvancementOptions() {
        return List.of(new HolyKnight());
    }

    @Override
    public int getJobAdvancementTier() {
        return 2;
    }
}
