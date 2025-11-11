package main.model.unit.character.job.finalClass.dragonKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class DragonHeart implements SkillInfo {
    @Override
    public String getName() {
        return "패시브 - 용의 심장";
    }

    @Override
    public String getDescription() {
        return "HP가 30% 이하일 때, 2턴간 공격력가과 방어력이 폭발적으로 증가합니다.";
    }

    @Override
    public int getMpCost() {
        return 0;
    }

    @Override
    public void use(Unit user, Unit target) {

    }
}
