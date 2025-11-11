package main.model.unit.character.job.finalClass.dragonKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.SkillInfo;

public class DragonStrike implements SkillInfo {
    @Override
    public String getName() {
        return "용의 일격";
    }

    @Override
    public String getDescription() {
        return "전방으로 도약하며 대검을 내리찍습니다. 적중 시 붉은 용의 형상이 폭발하며 강력한 화염 범위 피해를 줍니다.";
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
