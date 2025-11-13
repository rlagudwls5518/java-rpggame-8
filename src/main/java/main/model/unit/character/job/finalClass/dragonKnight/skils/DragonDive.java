package main.model.unit.character.job.finalClass.dragonKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class DragonDive implements Skill {
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
        double damege = user.getAd() * 2;
        target.takeDamage(damege);
    }
}
