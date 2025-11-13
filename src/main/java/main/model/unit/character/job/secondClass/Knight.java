package main.model.unit.character.job.secondClass;

import java.util.ArrayList;
import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.Skill;
import main.model.unit.character.job.secondClass.skills.Charge;
import main.model.unit.character.job.secondClass.skills.Endure;
import main.model.unit.character.job.secondClass.skills.WeaponMastery;

public class Knight implements CharacterJob {
    @Override
    public String getJobName() {
        return "기사";
    }

    @Override
    public List<Skill> getSkillList() {
        return List.of(
                new Charge(),
                new Endure(),
                new WeaponMastery()
        );
    }

    @Override
    public int getHpBonus() {
        return 50;
    }

    @Override
    public int getAttackBonus() {
        return 5;
    }
}
