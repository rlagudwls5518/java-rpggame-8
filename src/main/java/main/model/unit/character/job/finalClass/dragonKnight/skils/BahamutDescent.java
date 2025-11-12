package main.model.unit.character.job.finalClass.dragonKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class BahamutDescent implements SkillInfo {
    @Override
    public String getName() {
        return "궁극기 - 종말의 강림";
    }

    @Override
    public String getDescription() {
        return "거대한 용의 환영을 소환하여 전방의 모든 것을 불태우는 브레스를 발사합니다. 맵의 지형 일부를 10초간 '불타는 지대'로 변경합니다.";
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
        double damege = user.getAd() * 3;
        target.takeDamage(damege);
    }
}
