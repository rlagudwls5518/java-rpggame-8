package main.model.unit.character.job.secondClass.skills;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class Charge implements Skill {

    SkillsDamages chargeRate = SkillsDamages.PERCENT_120;
    MpCostRate mpCostRate = MpCostRate.MPCOST_10;

    @Override
    public String getName() {
        return "돌진";
    }

    @Override
    public String getDescription() {
        return "적에게 빠르게 돌진하여 공격력의 120% 데미지를 줍니다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * chargeRate.getRate();
        target.takeDamage(damege);
    }
}
