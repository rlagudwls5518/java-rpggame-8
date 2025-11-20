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
import main.view.OutputView.StartOutputView;
import java.util.List;

public class GameController {
    private final StageDatabase stageDatabase;

    public GameController() {
        this.stageDatabase = new StageDatabase();
    }

    public void run() {
        prollog();
        PlayerCharacter player = new PlayerCharacter("형진");
        List<WorldData> allWorlds = stageDatabase.getAllWorlds();
        MonsterDatabase monsterDatabase = new MonsterDatabase();
        ConsoleBattleView battleView = new ConsoleBattleView();
        GameService gameService = new GameService(monsterDatabase, battleView);

        for (WorldData world : allWorlds) {
            clearScreen();
            System.out.println("\n\n=============== [ " + world.worldName + " 진입 ] ===============");
            pressEnterToContinue();
            gameService.runWorld(player, world);
            if (!player.isAlive()) {
                return;
            }
        }
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
}