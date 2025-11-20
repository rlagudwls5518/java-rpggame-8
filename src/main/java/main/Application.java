package main;

import main.controller.GameController;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.MonsterDatabase;
import main.model.world.StageDatabase;
import main.service.GameService;
import main.view.OutputView.ConsoleBattleView;
import main.view.OutputView.GameView;

public class Application {
    public static void main(String[] args) {
        PlayerCharacter player = new PlayerCharacter("형진");
        StageDatabase stageDatabase = new StageDatabase();
        MonsterDatabase monsterDatabase = new MonsterDatabase();
        GameView gameView = new GameView();
        ConsoleBattleView battleView = new ConsoleBattleView();
        GameService gameService = new GameService(monsterDatabase, battleView);
        GameController gameController = new GameController(player, stageDatabase, monsterDatabase, gameView, battleView,
                gameService);
        gameController.run();
    }
}
