package main.model.unit.character.job.firstClass.skill;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class PowerStrike implements Skill {
    @Override
    public String getName() {
        return "강타";
    }

    @Override
    public String getDescription() {
        return "마나를 소모하여 적 하나에게 강력한 일격(공격력의 120%)을 날립니다.";
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
