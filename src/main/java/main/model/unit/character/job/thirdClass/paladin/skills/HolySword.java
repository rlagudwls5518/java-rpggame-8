package main.model.unit.character.job.thirdClass.paladin.skills;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class HolySword implements Skill {
    @Override
    public String getName() {
        return "신성의 검";
    }

    @Override
    public String getDescription() {
        return "3턴간 자신의 무기에 신성한 힘을 부여하여, 공격 시마다 자신의 HP를 소량 회복합니다.";
    }

    @Override
    public int getMpCost() {
        return 10;
    }

    @Override
    public void use(Unit user, Unit target) {

    }
}
