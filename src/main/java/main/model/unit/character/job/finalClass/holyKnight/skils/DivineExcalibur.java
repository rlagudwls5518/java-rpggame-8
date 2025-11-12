package main.model.unit.character.job.finalClass.holyKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class DivineExcalibur implements SkillInfo{
    @Override
    public String getName() {
        return "궁극기 - 신성 엑스칼리버";
    }

    @Override
    public String getDescription() {
        return "엑스칼리버를 소환해 현재 방어력의 200% 데미지의 방어무시 피해를 준다 ";
    }

    @Override
    public int getMpCost() {
        return 50;
    }

    @Override
    public void use(Unit user, Unit target) {
        if(user.getMp() <= getMpCost()){ // 일단 공통 로직 나중에 수정
            System.out.println("마나가 부족합니다");
        }
        user.decreaseMp(getMpCost());
        double damege = user.getAd() * 2;
        target.takeIgnoreDefenseDamage(damege);
    }
}
