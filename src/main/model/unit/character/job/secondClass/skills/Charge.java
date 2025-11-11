package main.model.unit.character.job.secondClass.skills;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class Charge implements SkillInfo {
    @Override
    public String getName() {
        return "돌진";
    }

    @Override
    public String getDescription() {
        return "적에게 빠르게 돌진하여 데미지를주고, 1턴간 기절시킵니다.";
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
