package main.model.unit.character.job.secondClass.skills;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class ShieldCrush implements Skill {

    SkillsDamages shieldCrushRate = SkillsDamages.PERCENT_130;
    MpCostRate mpCostRate = MpCostRate.MPCOST_10;

    @Override
    public String getName() {
        return "방패 찍기";
    }

    @Override
    public String getDescription() {
        return "하늘 높이 날아 방패로  가격하여 130% 피해를 입힙니다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * shieldCrushRate.getRate();
        target.takeDamage(damege);
    }
}
