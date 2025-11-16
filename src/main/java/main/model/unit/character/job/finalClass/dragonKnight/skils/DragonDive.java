package main.model.unit.character.job.finalClass.dragonKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class DragonDive implements Skill {

    SkillsDamages dragonDiveRate = SkillsDamages.PERCENT_200;
    MpCostRate mpCostRate = MpCostRate.MPCOST_30;

    @Override
    public String getName() {
        return "드래곤 다이브";
    }

    @Override
    public String getDescription() {
        return "하늘 높이 점프했다가 지정 위치로 낙하하며, "
                + "중심부의 적들을 공격력의 200% 피해를 줍니다.";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * dragonDiveRate.getRate();
        target.takeDamage(damege);
    }
}
