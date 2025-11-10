package main.model.unit.character;


import java.util.List;
import main.model.unit.character.skill.SkillInfo;

public interface CharacterJob {
    String getJobName();
    List<SkillInfo> getSkillList();
    int getHpBonus();
    int getAttackBonus();       

}
