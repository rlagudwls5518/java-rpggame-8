package main.model.unit.character.job.finalClass.holyKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class LightOfJudgment implements SkillInfo {
    @Override
    public String getName() {
        return "심판의 빛";
    }

    @Override
    public String getDescription() {
        return "하늘에서 거대한 빛의 검을 소환하여 대상의 머리 위로 떨어뜨립니다. 언데드/악마형 적에게 2배의 피해를 줍니다.";
    }

    @Override
    public int getMpCost() {
        return 0;
    }

    @Override
    public void use(Unit user, Unit target) {
        if(user.getMp() <= getMpCost()){ // 일단 공통 로직 나중에 수정
            System.out.println("마나가 부족합니다");
        }
        user.decreaseMp(getMpCost());
        double damege = user.getAd() * 2;
        target.takeDamage(damege);
    }
}
