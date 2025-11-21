package main.view.OutputView;

import main.dto.WorldData;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;

public interface BattleView {
    int showCombatUI(PlayerCharacter player, Monster monster,
                    String stageName, int stageNumber, WorldData world);
    void showAfterCombatUI(PlayerCharacter player, Monster monster,
                     String stageName, int stageNumber, WorldData world);
    void showPlayerHealthBar(PlayerCharacter player);
    void monsterHealthBar(Monster currentMonster, String stageName,
                          int stageNumber,  WorldData worldData);
    void monsterAsciArt(Monster currentMonster);
    String drawHealthBar(int hp, int maxHp, int totalLength);
    int skillView(PlayerCharacter player);
    void showVictoryScreen(String monsterName, PlayerCharacter player, int expGained, int goldGained);
    void showGameOverScreen(String monsterName);

}
