package main.model.unit.character.job.secondClass.skills;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class WeaponMastery implements SkillInfo {
    @Override
    public String getName() {
        return "패시브 - 무기연마";
    }

    @Override
    public String getDescription() {
        return " 기본 공격력을 영구히 증가시킵니다.";
    }

    @Override
    public int getMpCost() {
        return 0;
    }

    @Override
    public void use(Unit user, Unit target) {

    }
}
