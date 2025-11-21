package main.service;

import static main.util.Clear.clearScreen;
import static main.view.OutputView.EnterExplantion.pressEnterToContinue;

import main.model.battle.BattleLog;
import main.model.battle.PlayerActionResult;
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

    public PlayerActionResult handleTurnSequence(boolean isPlayerTurn, int actionNum) {
        if (isPlayerTurn) {
            boolean firstPlayerTurn = processPlayerTurn(actionNum);
            if (!firstPlayerTurn) return PlayerActionResult.RETRY_ACTION;
            if (!monster.isAlive()) return PlayerActionResult.TURN_END;

            processMonsterTurn();
        } else {
            processMonsterTurn();
            if (!player.isAlive()) return PlayerActionResult.TURN_END;

            boolean secondPlayerTurn = processPlayerTurn(actionNum);
            if (!secondPlayerTurn) return PlayerActionResult.RETRY_ACTION;
        }

        return PlayerActionResult.TURN_END;
    }

    private boolean processPlayerTurn(int actionNum) {
        while (true) {

            if (actionNum == 1) { // 스킬
                boolean used = processPlayerSkill();
                if (!used) {
                    return false;
                }
                return true;
            }
            if (actionNum == 2) { // 기본 공격
                player.attack(monster);
                String log = BattleLog.getPlayerAttackLog(player);
                BattleLog.addLog(log);
                return  true;
            }
            return true;
        }
    }

    private void processMonsterTurn() {
        monster.attack(player);
        String monsterLog = BattleLog.getMonsterLog(player, monster);
        BattleLog.addLog(monsterLog);
    }

    private boolean processPlayerSkill() {
        int skillNum;

        while (true) {
            skillNum = battleView.skillView(player);

            if (skillNum == -1) {
                return false;
            }

            boolean skillUsedSuccess = player.useSkill(monster, skillNum);

            if (skillUsedSuccess) {
                String log = BattleLog.getPlayerSkillLog(player, skillNum);
                BattleLog.addLog(log);
                break;
            } else {
                pressEnterToContinue();
                clearScreen();
                break;
            }
        }
        return true;
    }
}
