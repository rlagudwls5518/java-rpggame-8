package main.model.unit.character.job.thirdClass.paladin.skills;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class ShieldBash implements Skill {

    SkillsDamages shieldBashRate = SkillsDamages.PERCENT_100;
    MpCostRate mpCostRate = MpCostRate.MPCOST_10;

    @Override
    public String getName() {
        return "방패 강타";
    }

    @Override
    public String getDescription() {
        return "방패로 적을 공격력의 100% 데미지를 입힙니다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * shieldBashRate.getRate();
        target.takeDamage(damege);
    }
}
