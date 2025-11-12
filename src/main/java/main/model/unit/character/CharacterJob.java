package main.model.unit.character;

import java.util.List;

public interface CharacterJob {
    String getJobName();
    List<SkillInfo> getSkillList();
    int getHpBonus();
    int getAttackBonus();

}
