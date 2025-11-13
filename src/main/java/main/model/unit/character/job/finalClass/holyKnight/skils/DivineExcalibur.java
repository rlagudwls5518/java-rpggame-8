package main.model.unit.character.job.finalClass.holyKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class DivineExcalibur implements Skill{
    @Override
    public String getName() {
        return "궁극기 - 신성 엑스칼리버";
    }

    @Override
    public String getDescription() {
        return "엑스칼리버를 소환해 현재 방어력의 300% 데미지의 방어무시 피해를 준다 ";
    }

    @Override
    public int getMpCost() {
        return 50;
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * 3;
        target.takeIgnoreDefenseDamage(damege);
    }
}
