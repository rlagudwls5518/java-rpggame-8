package main.model.unit.character.job.finalClass.holyKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class DivineProtection implements SkillInfo {
    @Override
    public String getName() {
        return "신의 가호";
    }

    @Override
    public String getDescription() {
        return "자신에게 2턴간 모든 피해를 흡수하는 신성한 보호막을 부여합니다. (보호막은 자신의 최대 HP에 비례)";
    }

    @Override
    public int getMpCost() {
        return 30;
    }

    @Override
    public void use(Unit user, Unit target) {

    }
}
