package main.model.unit.character.job.thirdClass.paladin;

import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.Skill;
import main.model.unit.character.job.thirdClass.paladin.skills.HolySword;
import main.model.unit.character.job.thirdClass.paladin.skills.ShieldBash;

public class Paladin implements CharacterJob {
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
}
