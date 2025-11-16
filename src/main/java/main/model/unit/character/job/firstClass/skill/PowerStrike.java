package main.model.unit.character.job.firstClass.skill;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class PowerStrike implements Skill {

    SkillsDamages powerStrikeRate = SkillsDamages.PERCENT_120;
    MpCostRate mpCostRate = MpCostRate.MPCOST_10;

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
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * powerStrikeRate.getRate();
        target.takeDamage(damege);
    }
}
