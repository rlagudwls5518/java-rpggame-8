package main.model.unit.character.job.finalClass.dragonKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class DragonScale implements Skill {

    SkillsDamages dragonScaleRate = SkillsDamages.PERCENT_130;
    MpCostRate mpCostRate = MpCostRate.MPCOST_20;

    @Override
    public String getName() {
        return "용의 비늘검격";
    }

    @Override
    public String getDescription() {
        return "검에 용의 비늘을 둘러 공격력의 130% 피해를 입힙니다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * dragonScaleRate.getRate();
        target.takeDamage(damege);
    }
}
