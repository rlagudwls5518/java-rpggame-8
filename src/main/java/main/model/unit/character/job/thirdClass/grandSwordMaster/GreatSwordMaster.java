package main.model.unit.character.job.thirdClass.grandSwordMaster;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.Skill;
import main.model.unit.character.job.finalClass.dragonKnight.DragonKnight;
import main.model.unit.character.job.thirdClass.grandSwordMaster.skils.SpinningSlash;
import main.model.unit.character.job.thirdClass.grandSwordMaster.skils.SunderingStrike;
import main.model.unit.character.job.thirdClass.grandSwordMaster.skils.TectonicShift;

public class GreatSwordMaster implements CharacterJob {

    private static final int ADVANCE_LEVEL = 30;

    @Override
    public String getJobName() {
        return "대검사";
    }

    @Override
    public List<Skill> getSkillList() {
        return List.of(
                new TectonicShift(),
                new SpinningSlash(),
                new SunderingStrike()
        );
    }

    @Override
    public int getHpBonus() {
        return 100;
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
        return new DragonKnight();
    }

    @Override
    public List<CharacterJob> getAdvancementOptions() {
        return List.of(new DragonKnight());
    }

    @Override
    public int getJobAdvancementTier() {
        return 2;
    }
}
