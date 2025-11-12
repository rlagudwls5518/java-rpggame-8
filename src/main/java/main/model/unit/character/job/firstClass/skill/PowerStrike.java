package main.model.unit.character.job.firstClass.skill;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class PowerStrike implements SkillInfo {
    @Override
    public String getName() {
        return "강타";
    }

    @Override
    public String getDescription() {
        return "마나를 소모하여 적 하나에게 강력한 일격(공격력의 120%)을 날립니다.";
    }

    @Override
    public int getMpCost() {
        return 10;
    }

    @Override
    public void use(Unit user, Unit target) {
        if(user.getMp() <= getMpCost()){ // 일단 공통 로직 나중에 수정
            System.out.println("마나가 부족합니다");
        }
        user.decreaseMp(getMpCost());
        double damege = user.getAd() * 1.2;
        target.takeDamage(damege);
    }
}
