package main.controller;

import static main.util.Clear.clearScreen;
import static main.util.EnterExplantion.pressEnterNextTurn;
import static main.util.EnterExplantion.pressEnterRetry;
import static main.util.EnterExplantion.pressEnterToContinue;

import main.dto.StageData;
import main.dto.WorldData;
import main.model.battle.BattleLog;
import main.model.battle.EndBattle;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.service.BattleService;
import main.view.OutputView.BattleOutView;
import main.view.OutputView.BattleResultOutView;
import main.view.inputView.Input;

public class BattleController {

    private final PlayerCharacter player;
    private final Monster monster;
    private final BattleService battleService;
    private final WorldData world;
    private final StageData stage;


    public BattleController(PlayerCharacter player, Monster monster, BattleService battleService, WorldData world,
                            StageData stage) {
        this.player = player;
        this.monster = monster;
        this.battleService = battleService;
        this.world = world;
        this.stage = stage;
    }

    public void battleStart() {
        Input input = new Input();

        boolean isPlayerTurn = player.getAd() > monster.getAd();

        while (player.isAlive() && monster.isAlive()) {
            BattleLog.clearLog();
            updateBattleView(stage, world);
            int num = input.inputNumber();
            if (!battleService.handleTurnSequence(isPlayerTurn, num)) {
                break;
            }
            updateBattleView(stage, world);
            isPlayerTurn = !isPlayerTurn;
            pressEnterNextTurn();
        }
        endBattle(monster.giveGold(), monster.giveExp(), stage.monsterName);
    }

    private void endBattle(int goldGained, int expGained, String monsterName) {

        if (player.isAlive()) {
            EndBattle.endBattleReword(player, monster);
            clearScreen();
            BattleResultOutView.showGameOverScreen(monsterName);
            pressEnterRetry();

        } else {
            EndBattle.deadPlayerEndBattle(player);
            clearScreen();
            BattleResultOutView.showVictoryScreen(monsterName, player, expGained, goldGained);
            pressEnterToContinue();
            clearScreen();
            player.ProcessAdvancement();
        }
    }

    private void updateBattleView(StageData stage,WorldData worldData) {
        clearScreen();
        BattleOutView.showCombatUI(player, monster, stage.stageName, stage.stageNumber, worldData);
    }
}
