package main.model.unit.character.job.thirdClass.grandSwordMaster.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class GreatswordExpertise implements Skill {
    @Override
    public String getName() {
        return "패시브 - 양손검 숙련";
    }

    @Override
    public String getDescription() {
        return "치명타 확률과 치명타 피해량이 영구히 증가합니다.";
    }

    @Override
    public int getMpCost() {
        return 0;
    }

    @Override
    public void use(Unit user, Unit target) {

    }
}
