package main.model.unit.character.job.firstClass.skill;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class DefensiveStance implements Skill {
    @Override
    public String getName() {
        return "방어 태세";
    }

    @Override
    public String getDescription() {
        return "한턴 동안 자신의 방어력을 두배 증가시킵니다.";
    }

    @Override
    public int getMpCost() {
        return 5;
    }

    @Override
    public void use(Unit user, Unit target) {
    }
}
