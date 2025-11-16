package main.model.unit.character.job.finalClass.dragonKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class BahamutDescent implements Skill {

    SkillsDamages bahamutDescentRate = SkillsDamages.PERCENT_300;
    MpCostRate mpCostRate = MpCostRate.MPCOST_50;

    @Override
    public String getName() {
        return "궁극기 - 종말의 강림";
    }

    @Override
    public String getDescription() {
        return "거대한 용의 환영을 소환하여 전방의 모든 것을 불태우는 브레스를 발사해 "
                + "공격력의 300% 피해를 입힙니다 ";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * bahamutDescentRate.getRate();
        target.takeDamage(damege);
    }
}
