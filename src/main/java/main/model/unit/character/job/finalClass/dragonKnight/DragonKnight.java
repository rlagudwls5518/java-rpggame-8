package main.model.unit.character.job.finalClass.dragonKnight;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.Skill;
import main.model.unit.character.job.finalClass.dragonKnight.skils.BahamutDescent;
import main.model.unit.character.job.finalClass.dragonKnight.skils.DragonDive;
import main.model.unit.character.job.finalClass.dragonKnight.skils.DragonScale;
import main.model.unit.character.job.finalClass.dragonKnight.skils.DragonStrike;


public class DragonKnight implements CharacterJob {

    private static final int ADVANCE_LEVEL = 40;

    @Override
    public String getJobName() {
        return "용기사";
    }

    @Override
    public List<Skill> getSkillList() {
        return List.of(
                new BahamutDescent(),
                new DragonDive(),
                new DragonScale(),
                new DragonStrike()
        );
    }

    @Override
    public int getHpBonus() {
        return 150;
    }

    @Override
    public int getAttackBonus() {
        return 30;
    }

    @Override
    public boolean canAdvance(int currentLevel) {
        return currentLevel >= ADVANCE_LEVEL;
    }

    @Override
    public CharacterJob advance(int choice) {
        return null;
    }

    @Override
    public List<CharacterJob> getAdvancementOptions() {
        return List.of();
    }

    @Override
    public int getJobAdvancementTier() {
        return 3;
    }
}
