package main.model.unit.character.job.finalClass.dragonKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class DragonScale implements Skill {
    @Override
    public String getName() {
        return "용의 비늘";
    }

    @Override
    public String getDescription() {
        return "2턴간 용의 비늘이 몸을 감싸, 받는 모든 피해의 50%를 반사합니다. (반사 피해는 자신의 공격력에 비례)";
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
