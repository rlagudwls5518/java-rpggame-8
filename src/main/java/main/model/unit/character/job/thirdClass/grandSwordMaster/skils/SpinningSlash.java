package main.model.unit.character.job.thirdClass.grandSwordMaster.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class SpinningSlash implements Skill {
    @Override
    public String getName() {
        return "연속베기";
    }

    @Override
    public String getDescription() {
        return "대검을 두번 휘둘러 적을 공격합니다.";
    }

    @Override
    public int getMpCost() {
        return 25;
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * 1.8;
        target.takeDamage(damege);
    }
}
