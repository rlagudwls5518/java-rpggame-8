package main.model.unit.character.job.thirdClass.paladin.skills;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class ShieldExpertise implements SkillInfo {
    @Override
    public String getName() {
        return "패시브 - 방패 숙련";
    }

    @Override
    public String getDescription() {
        return "방어력이 영구히 증가하며, 최대 HP가 증가합니다.";
    }

    @Override
    public int getMpCost() {
        return 0;
    }

    @Override
    public void use(Unit user, Unit target) {

    }
}
