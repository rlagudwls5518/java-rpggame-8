package main.model.unit.character.job.secondClass.skills;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class Charge implements Skill {
    @Override
    public String getName() {
        return "돌진";
    }

    @Override
    public String getDescription() {
        return "적에게 빠르게 돌진하여 공격력의 120% 데미지를 주고, 1턴간 기절시킵니다.";
    }

    @Override
    public int getMpCost() {
        return 10;
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * 1.2;
        target.takeDamage(damege);
    }
}
