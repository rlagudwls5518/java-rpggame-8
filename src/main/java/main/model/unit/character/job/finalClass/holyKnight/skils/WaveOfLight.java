package main.model.unit.character.job.finalClass.holyKnight.skils;

import main.model.unit.Unit;
import main.model.unit.character.Skill;

public class WaveOfLight implements Skill{
    @Override
    public String getName() {
        return "빛의 파동";
    }

    @Override
    public String getDescription() {
        return "전방으로 신성한 파동을 발사합니다. 적중한 적에게는 피해를 줍니다.";
    }

    @Override
    public int getMpCost() {
        return 0;
    }

    @Override
    public void use(Unit user, Unit target) {
        double damege = user.getAd() * 2;
        target.takeDamage(damege);
    }
}
