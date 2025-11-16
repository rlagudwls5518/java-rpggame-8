package main.model.unit.character.job.thirdClass.paladin.skills;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class HolySword implements Skill {

    SkillsDamages holySwordRate = SkillsDamages.PERCENT_150;
    MpCostRate mpCostRate = MpCostRate.MPCOST_10;

    @Override
    public String getName() {
        return "신성의 검";
    }

    @Override
    public String getDescription() {
        return "자신의 무기에 신성한 힘을 부여하여, 공격력의 150% 피해를 입힙니다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * holySwordRate.getRate();
        target.takeDamage(damege);
    }
}
