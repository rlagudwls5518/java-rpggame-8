package main.model.unit.character.job.thirdClass.paladin.skills;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class ShieldBash implements SkillInfo {
    @Override
    public String getName() {
        return "방패 강타";
    }

    @Override
    public String getDescription() {
        return "방패로 적을 가격하여 높은 어그로(적개심)를 획득하고 1턴간 기절시킵니다";
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
        double damege = user.getAd();
        target.takeDamage(damege);
    }
}
