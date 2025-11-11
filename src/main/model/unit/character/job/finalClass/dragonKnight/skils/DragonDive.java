package main.model.unit.character.job.finalClass.dragonKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class DragonDive implements SkillInfo {
    @Override
    public String getName() {
        return "드래곤 다이브";
    }

    @Override
    public String getDescription() {
        return "하늘 높이 점프했다가 지정 위치로 낙하하며, 중심부의 적들을 1턴간 기절시키고 넓은 범위에 피해를 줍니다.";
    }

    @Override
    public int getMpCost() {
        return 30;
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
