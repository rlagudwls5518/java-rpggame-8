package main.model.unit.character.job.thirdClass.grandSwordMaster.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class BattleStance implements Skill {
    @Override
    public String getName() {
        return "전투 태세";
    }

    @Override
    public String getDescription() {
        return "2턴간 방어력이 10% 감소하지만, 공격력이 30% 증가하는 태세로 전환합니다.";
    }

    @Override
    public int getMpCost() {
        return 20;
    }

    @Override
    public void use(Unit user, Unit target) {

    }
}
