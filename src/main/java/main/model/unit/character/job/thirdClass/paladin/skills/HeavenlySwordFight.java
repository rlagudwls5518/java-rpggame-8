package main.model.unit.character.job.thirdClass.paladin.skills;

import main.model.unit.Unit;
import main.model.unit.character.Skill;
import main.util.MpCostRate;
import main.util.SkillsDamages;

public class HeavenlySwordFight implements Skill {

    SkillsDamages heavenlySwordFightRate = SkillsDamages.PERCENT_150;
    MpCostRate mpCostRate = MpCostRate.MPCOST_20;

    @Override
    public String getName() {
        return "천상대검격";
    }

    @Override
    public String getDescription() {
        return "전투태세로 돌입하고 하늘로 뛰어올라 공격력의 150% 피해를 입힌다";
    }

    @Override
    public int getMpCost() {
        return mpCostRate.getmpCost();
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * heavenlySwordFightRate.getRate();
        target.takeDamage(damege);

    }
}
