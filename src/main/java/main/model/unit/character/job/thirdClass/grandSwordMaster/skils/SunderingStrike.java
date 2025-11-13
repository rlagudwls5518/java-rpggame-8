package main.model.unit.character.job.thirdClass.grandSwordMaster.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class SunderingStrike implements Skill {
    @Override
    public String getName() {
        return "파쇄격";
    }

    @Override
    public String getDescription() {
        return "대검을 강하게 내리찍어, 적의 방어력을 5초간 30% 감소시킵니다.";
    }

    @Override
    public int getMpCost() {
        return 20;
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * 1.5;
        target.takeDamage(damege);
    }
}
