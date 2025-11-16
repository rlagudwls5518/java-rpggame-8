package main.model.unit.character.job.secondClass.skills;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class WeaponMastery implements Skill {

    SkillsDamages weaponMasteryRate = SkillsDamages.PERCENT_120;
    MpCostRate mpCostRate = MpCostRate.MPCOST_10;

    @Override
    public String getName() {
        return "무기연마";
    }

    @Override
    public String getDescription() {
        return " 무기 연마를 하면서 상대 급소를 130%피해를 입힌다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * weaponMasteryRate.getRate();
        target.takeDamage(damege);
    }
}
