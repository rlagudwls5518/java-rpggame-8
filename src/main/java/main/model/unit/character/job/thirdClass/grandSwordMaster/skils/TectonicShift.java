package main.model.unit.character.job.thirdClass.grandSwordMaster.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class TectonicShift implements Skill {

    SkillsDamages tectonicShiftRate = SkillsDamages.PERCENT_150;
    MpCostRate mpCostRate = MpCostRate.MPCOST_25;

    @Override
    public String getName() {
        return "지각 변동";
    }

    @Override
    public String getDescription() {
        return "대검을 바닥에 꽂아 지각을 움직여 공격력의 150%피해를 입힌다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * tectonicShiftRate.getRate();
        target.takeDamage(damege);
    }
}
