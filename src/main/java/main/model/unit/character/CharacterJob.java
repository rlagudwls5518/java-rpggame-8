package main.model.unit.character;

import java.util.List;

public interface CharacterJob {
    String getJobName();

    List<Skill> getSkillList();

    int getHpBonus();

    int getAttackBonus();

    boolean canAdvance(int currentLevel);

    CharacterJob advance(int choice); //선택에 따라 확정된 다음 직업을 반환

    List<CharacterJob> getAdvancementOptions();//전직 가능한 다음 직업 목록을 반환

    int getJobAdvancementTier();

}
