package main.service;

import static main.util.Clear.clearScreen;
import static main.util.EnterExplantion.pressEnterToContinue;

import main.model.battle.BattleLog;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.view.OutputView.ConsoleBattleView;


public class BattleService {

    private final PlayerCharacter player;
    private final Monster monster;
    private final ConsoleBattleView battleView;


    public BattleService(PlayerCharacter player, Monster monster, ConsoleBattleView battleView) {
        this.player = player;
        this.monster = monster;
        this.battleView = battleView;
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
        battleView.skillView(player, skillNum);
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
