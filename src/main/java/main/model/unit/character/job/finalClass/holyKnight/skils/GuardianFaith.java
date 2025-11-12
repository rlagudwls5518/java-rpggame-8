package main.model.unit.character.job.finalClass.holyKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class GuardianFaith implements SkillInfo {
    @Override
    public String getName() {
        return "패시브 - 수호자의 신념";
    }

    @Override
    public String getDescription() {
        return "자신의 방어력이 10% 증가할 때마다, 자신의 공격력도 1%씩 증가합니다.";
    }

    @Override
    public int getMpCost() {
        return 0;
    }

    @Override
    public void use(Unit user, Unit target) {

    }
}
