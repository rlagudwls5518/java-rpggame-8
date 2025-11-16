package main.model.unit.character.job.finalClass.holyKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class DivineProtection implements Skill {

    SkillsDamages divineProtectionRate = SkillsDamages.PERCENT_200;
    MpCostRate mpCostRate = MpCostRate.MPCOST_30;

    @Override
    public String getName() {
        return "신의 검격";
    }

    @Override
    public String getDescription() {
        return "신의 힘이 검에 깃들어  하늘을 높게 들면 "
                + "하늘에서 수많은 검이 내리 꽃히며 공격력의 200% 피해를 입힌다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * divineProtectionRate.getRate();
        target.takeDamage(damege);

    }
}
