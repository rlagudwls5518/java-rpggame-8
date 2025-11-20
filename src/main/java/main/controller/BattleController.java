package main.controller;

import static main.util.Clear.clearScreen;
import static main.util.EnterExplantion.pressEnterNextTurn;

import main.dto.StageData;
import main.dto.WorldData;
import main.model.battle.BattleLog;
import main.model.battle.EndBattle;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.service.BattleService;
import main.view.OutputView.BattleOutView;
import main.view.inputView.Input;

public class BattleController {

    private final PlayerCharacter player;
    private final Monster monster;
    private final BattleService battleService;
    private final Input input;

    public BattleController(PlayerCharacter player, Monster monster, BattleService battleService, Input input) {
        this.player = player;
        this.monster = monster;
        this.battleService = battleService;
        this.input = input;

    }

    public void battleStart(StageData stage,WorldData worldData) {
        if (monster == null) {
            System.err.println("치명적 오류: 몬스터를 찾지 못해 전투를 시작할 수 없습니다.");
            return;
        }

        boolean isPlayerTurn = player.getAd() > monster.getAd();

        while (player.isAlive() && monster.isAlive()) {
            BattleLog.clearLog();
            updateBattleView(stage, worldData);
            int num = input.inputNumber();
            if (!battleService.handleTurnSequence(isPlayerTurn, num)) {
                break;
            }
            updateBattleView(stage, worldData);
            isPlayerTurn = !isPlayerTurn;
            pressEnterNextTurn();
        }
        endBattle();
    }

    private void endBattle() {

        if (player.isAlive()) {
            EndBattle.endBattleReword(player, monster);

        } else {
            EndBattle.deadPlayerEndBattle(player, monster);
        }
    }



    private void updateBattleView(StageData stage,WorldData worldData) {
        clearScreen();
        BattleOutView.showCombatUI(player, monster, stage.stageName, stage.stageNumber, worldData);
    }
}
