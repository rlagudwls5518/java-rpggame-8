package main.model.unit.character.job.finalClass.dragonKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class DragonStrike implements Skill {

    SkillsDamages dragonStrikeRate = SkillsDamages.PERCENT_200;
    MpCostRate mpCostRate = MpCostRate.MPCOST_30;

    @Override
    public String getName() {
        return "용의 일격";
    }

    @Override
    public String getDescription() {
        return "전방으로 도약하며 대검을 내리찍습니다. "
                + "적중 시 붉은 용의 형상이 폭발하며 강력한 화염의 공격력의 200% 피해를 줍니다.";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * dragonStrikeRate.getRate();
        target.takeDamage(damege);
    }
}
