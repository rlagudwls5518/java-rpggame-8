package main.model.unit.character.job.thirdClass.grandSwordMaster.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class SunderingStrike implements Skill {

    SkillsDamages sunderingStrikeRate = SkillsDamages.PERCENT_120;
    MpCostRate mpCostRate = MpCostRate.MPCOST_20;

    @Override
    public String getName() {
        return "파쇄격";
    }

    @Override
    public String getDescription() {
        return "대검을 강하게 내리찍어 공격력의 120% 피해를 입힌다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * sunderingStrikeRate.getRate();
        target.takeDamage(damege);
    }
}
