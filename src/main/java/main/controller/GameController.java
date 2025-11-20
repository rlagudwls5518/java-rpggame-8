package main.controller;

import static main.util.Clear.clearScreen;
import static main.util.EnterExplantion.choicePressNumber;
import static main.util.EnterExplantion.pressEnterToContinue;

import main.dto.WorldData;
import main.service.GameService;
import main.model.world.StageDatabase;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.MonsterDatabase;
import main.view.OutputView.ConsoleBattleView;
import main.view.OutputView.GameView;
import main.view.OutputView.StartOutputView;
import java.util.List;

public class GameController {
    private final PlayerCharacter player;
    private final StageDatabase stageDatabase;
    private final MonsterDatabase monsterDatabase;
    private final GameView gameView;
    private final ConsoleBattleView battleView;
    private final GameService gameService;

    public GameController(PlayerCharacter player, StageDatabase stageDatabase,
                          MonsterDatabase monsterDatabase,
                          GameView gameView,
                          ConsoleBattleView battleView,
                          GameService gameService) {
        this.player = player;
        this.stageDatabase = stageDatabase;
        this.monsterDatabase = monsterDatabase;
        this.gameView = gameView;
        this.battleView = battleView;
        this.gameService = gameService;
    }

    public void run() {
        prollog();
        playAllWorlds(player);
    }

    private void prollog() {
        StartOutputView.showSplashScreen();
        clearScreen();
        StartOutputView.showPrologue();
        pressEnterToContinue();
        clearScreen();
        StartOutputView.showStartView();
        choicePressNumber();
        clearScreen();
    }

    private void playAllWorlds(PlayerCharacter player) {
        for (WorldData world : stageDatabase.getAllWorlds()) {
            gameView.worldStartView(world);
            gameService.runWorld(player, world);
            if (!player.isAlive()) {
                return;
            }
        }
    }
}