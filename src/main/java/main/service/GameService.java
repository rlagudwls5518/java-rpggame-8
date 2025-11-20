package main.service;


import main.controller.BattleController;
import main.controller.TownController;
import main.dto.StageData;
import main.dto.WorldData;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.model.unit.monster.MonsterDatabase;
import main.model.unit.monster.MonsterType;
import main.view.OutputView.ConsoleBattleView;

public class GameService {

    private final MonsterDatabase monsterDatabase;
    private final MonsterType worldBoss = MonsterType.FINAL_BOSS;
    private final MonsterType midBoss = MonsterType.MID_BOSS;
    private final MonsterType finalBoss = MonsterType.TRUE_FINAL_BOSS;
    private final ConsoleBattleView battleView;

    public GameService(MonsterDatabase monsterDatabase, ConsoleBattleView battleView) {
        this.monsterDatabase = monsterDatabase;

        this.battleView = battleView;
    }

    public void runWorld(PlayerCharacter player, WorldData world) {
        for (StageData stage : world.stages) {
            runStage(player, world, stage);
        }
    }

    private void runStage(PlayerCharacter player, WorldData world, StageData stage) {
        String stageType = stage.stageType;
        TownController townController = new TownController(player, world, stage);

        if (midBoss.toString().equals(stageType) || worldBoss.toString().equals(stageType) || finalBoss.toString().equals(stageType)) {
            townController.runTownLoop();
        }

        String monsterName = stage.monsterName;
        Monster monster = monsterDatabase.createMonster(monsterName);

        BattleService battleService = new BattleService(player, monster, battleView);
        BattleController battleController = new BattleController(player, monster, battleService, world, stage, battleView);

        while(true){
            player.refillHpMp();
            battleController.battleStart();
        }
    }
}
