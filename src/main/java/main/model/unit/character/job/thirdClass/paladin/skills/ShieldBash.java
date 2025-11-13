package main.model.unit.character.job.thirdClass.paladin.skills;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class ShieldBash implements Skill {
    @Override
    public String getName() {
        return "방패 강타";
    }

    @Override
    public String getDescription() {
        return "방패로 적을 공격력의 100% 데미지로 가격하여 높은 어그로를 획득하고 1턴간 기절시킵니다";
    }

    @Override
    public int getMpCost() {
        return 10;
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd();
        target.takeDamage(damege);
    }
}
