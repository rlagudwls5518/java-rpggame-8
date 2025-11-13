package main.model.unit.character.job.secondClass.skills;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class Endure implements Skill {
    @Override
    public String getName() {
        return "방어태세";
    }

    @Override
    public String getDescription() {
        return "2턴간 자신의 물리 방어력을 20% 증가시킵니다.";
    }

    @Override
    public int getMpCost() {
        return 10;
    }

    @Override
    public void use(Unit user, Unit target) {

    }
}
