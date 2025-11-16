package main.model.unit.character.job.firstClass.skill;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class DummFist implements Skill {

    SkillsDamages dummFistRate = SkillsDamages.PERCENT_120;
    MpCostRate mpCostRate = MpCostRate.MPCOST_10;

    @Override
    public String getName() {
        return "주먹 다짐";
    }

    @Override
    public String getDescription() {
        return "맨주먹으로 공격력의 100%의 피해를 입힙니다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * dummFistRate.getRate();
        target.takeDamage(damege);
    }
}
