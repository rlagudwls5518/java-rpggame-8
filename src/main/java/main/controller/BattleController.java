package main.controller;

import static main.view.OutputView.EnterExplantion.pressEnterNextTurn;

import main.dto.StageData;
import main.dto.WorldData;
import main.model.battle.BattleLog;
import main.model.battle.EndBattle;
import main.model.battle.PlayerActionResult;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.service.BattleService;
import main.view.OutputView.BattleView;
import main.view.OutputView.ConsoleBattleView;

public class BattleController {

    private final PlayerCharacter player;
    private final Monster monster;
    private final BattleService battleService;
    private final WorldData world;
    private final StageData stage;
    private final BattleView battleView;


    public BattleController(PlayerCharacter player, Monster monster, BattleService battleService, WorldData world,
                            StageData stage, ConsoleBattleView battleView) {
        this.player = player;
        this.monster = monster;
        this.battleService = battleService;
        this.world = world;
        this.stage = stage;
        this.battleView = battleView;
    }

    public void battleStart() {
        boolean isPlayerTurn = player.getAd() > monster.getAd();

        while (player.isAlive() && monster.isAlive()) {
            BattleLog.clearLog();

            int actionNum = battleView.showCombatUI(player, monster, stage.stageName, stage.stageNumber, world);
            PlayerActionResult actionResult = battleService.handleTurnSequence(isPlayerTurn, actionNum);
            if (actionResult == PlayerActionResult.TURN_END) {
                break;
            }
            if (actionResult == PlayerActionResult.RETRY_ACTION) {
                continue;
            }
            battleView.showAfterCombatUI(player, monster, stage.stageName, stage.stageNumber, world);
            pressEnterNextTurn();
            isPlayerTurn = !isPlayerTurn;
        }
        endBattle(monster.giveGold(), monster.giveExp(), stage.monsterName);
    }

    private void endBattle(int goldGained, int expGained, String monsterName) {

        if (!monster.isAlive()) {
            endBattleWinPlayer(monsterName, goldGained, expGained);
        }
        if (!player.isAlive()) {
            endBattleLosePlayer(monsterName);
        }
    }

    private void endBattleLosePlayer(String monsterName) {
        EndBattle.deadPlayerEndBattle(player);
        battleView.showGameOverScreen(monsterName);
    }

    private void endBattleWinPlayer(String monsterName, int goldGained, int expGained) {
        EndBattle.endBattleReword(player, monster);
        battleView.showVictoryScreen(monsterName, player, expGained, goldGained);
        player.ProcessAdvancement();
    }
}
