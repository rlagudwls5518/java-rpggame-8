package main.service;

import static main.util.Clear.clearScreen;
import static main.util.EnterExplantion.pressEnterToContinue;
import static main.view.OutputView.BattleOutView.skillView;

import main.model.battle.BattleLog;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;


public class BattleService {

    private final PlayerCharacter player;
    private final Monster monster;


    public BattleService(PlayerCharacter player,Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public boolean handleTurnSequence(boolean isPlayerTurn, int num) {
        if (isPlayerTurn) {
            processPlayerTurn(num);
            if (!monster.isAlive()) {
                return false;
            }
            processMonsterTurn();
        } else {
            processMonsterTurn();
            if (!player.isAlive()) {
                return false;
            }
            processPlayerTurn(num);
        }
        return true;
    }

    private void processPlayerTurn(int num) {
        while (true) {
            if (num == 1) { // 스킬 사용
                processPlayerSkill(num);
                break;
            } else { // 기본공격 사용
                player.attack(monster);
                String playerLog = BattleLog.getPlayerAttackLog(player);
                BattleLog.addLog(playerLog);
                break;
            }
        }
    }

    private void processMonsterTurn() {
        monster.attack(player);
        String monsterLog = BattleLog.getMonsterLog(player, monster);
        BattleLog.addLog(monsterLog);
    }

    private void processPlayerSkill(int skillNum) {
        skillView(player, skillNum);
        boolean skillUsedSuccess = player.useSkill(monster, skillNum);
        if (skillUsedSuccess) {
            String playerLog = BattleLog.getPlayerSkillLog(player, skillNum);
            BattleLog.addLog(playerLog);
        } else {
            pressEnterToContinue();
            clearScreen();
        }

    }
}
