package main.controller;

import static main.util.Clear.clearScreen;
import static main.view.OutputView.EnterExplantion.choicePressNumber;

import main.dto.WorldData;
import main.service.GameService;
import main.model.world.StageDatabase;
import main.model.unit.character.PlayerCharacter;
import main.view.OutputView.GameView;
import main.view.OutputView.StartOutputView;

public class GameController {
    private final PlayerCharacter player;
    private final StageDatabase stageDatabase;
    private final GameView gameView;
    private final GameService gameService;

    public GameController(PlayerCharacter player, StageDatabase stageDatabase,
                          GameView gameView,
                          GameService gameService) {
        this.player = player;
        this.stageDatabase = stageDatabase;
        this.gameView = gameView;
        this.gameService = gameService;
    }

    public void run() {
        prollog();
        playAllWorlds(player);
    }

    private void prollog() {
        StartOutputView.showSplashScreen();
        StartOutputView.showPrologue();
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