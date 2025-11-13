package main.model.unit.character.job.thirdClass.grandSwordMaster.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class SunderingStrike implements Skill {
    @Override
    public String getName() {
        return "파쇄격";
    }

    @Override
    public String getDescription() {
        return "대검을 강하게 내리찍어, 적의 방어력을 5초간 30% 감소시킵니다.";
    }

    @Override
    public int getMpCost() {
        return 20;
    }

    @Override
    public void use(Unit user, Unit target) {
        if(user.getMp() <= getMpCost()){ // 일단 공통 로직 나중에 수정
            System.out.println("마나가 부족합니다");
        }
        user.decreaseMp(getMpCost());
        double damege = user.getAd() * 1.5;
        target.takeDamage(damege);
    }
}
