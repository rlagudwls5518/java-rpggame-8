package main.model.unit.character.job.finalClass.holyKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class DivineExcalibur implements Skill{

    SkillsDamages divineExcaliburRate = SkillsDamages.PERCENT_300;
    MpCostRate mpCostRate = MpCostRate.MPCOST_50;

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
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * divineExcaliburRate.getRate();
        target.takeIgnoreDefenseDamage(damege);
    }
}
