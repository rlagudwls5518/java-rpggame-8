package main.model.unit.character.job.firstClass.skill;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class DefensiveStance implements Skill {
    @Override
    public String getName() {
        return "방어 태세";
    }

    @Override
    public String getDescription() {
        return "일정 턴 동안 자신의 물리 방어력과 마법 방어력을 크게 증가시킵니다.";
    }

    @Override
    public int getMpCost() {
        return 5;
    }

    @Override
    public void use(Unit user, Unit target) {
        if(user.getMp() <= getMpCost()){ // 일단 공통 로직 나중에 수정
            System.out.println("마나가 부족합니다");
        }
        user.decreaseMp(getMpCost());
//        double damege = user.getAd() * 1.2;
//        target.takeDamage(damege);
    }
}
