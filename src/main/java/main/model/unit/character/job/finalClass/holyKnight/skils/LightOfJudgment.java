package main.model.unit.character.job.finalClass.holyKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class LightOfJudgment implements Skill {

    SkillsDamages lightOfJudgmentRate = SkillsDamages.PERCENT_250;
    MpCostRate mpCostRate = MpCostRate.MPCOST_30;

    @Override
    public String getName() {
        return "심판의 빛";
    }

    @Override
    public String getDescription() {
        return "하늘에서 거대한 빛의 검을 소환하여 대상의 머리 위로 떨어뜨려 공격력의 250% 피해를 입힌다 ";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * lightOfJudgmentRate.getRate();
        target.takeDamage(damege);
    }
}
