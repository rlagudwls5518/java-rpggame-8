package main.service;

import static main.util.Clear.clearScreen;
import static main.util.EnterExplantion.pressEnterRetry;
import static main.util.EnterExplantion.pressEnterToContinue;

import main.controller.BattleController;
import main.controller.TownController;
import main.dto.StageData;
import main.dto.WorldData;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.model.unit.monster.MonsterDatabase;
import main.model.unit.monster.MonsterType;
import main.view.OutputView.BattleResultOutView;

public class GameService {

    private final MonsterDatabase monsterDatabase;
    private final MonsterType worldBoss = MonsterType.FINAL_BOSS;
    private final MonsterType midBoss = MonsterType.MID_BOSS;
    private final MonsterType finalBoss = MonsterType.TRUE_FINAL_BOSS;

    public GameService(MonsterDatabase monsterDatabase) {
        this.monsterDatabase = monsterDatabase;
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

        monsterExeption(monster,monsterName);

        int expGained = monster.giveExp();
        int goldGained = monster.giveGold();
        BattleService battleService = new BattleService(player,monster);

        while(true){
            player.refillHpMp();
            startBattle(player, monster, battleService, stage, world);
            endBattleView(player,monsterName,expGained,goldGained);
        }
    }

    private void endBattleView(PlayerCharacter player, String monsterName,
                               int expGained, int goldGained) {
        if (!player.isAlive()) {
            clearScreen();
            BattleResultOutView.showGameOverScreen(monsterName);
            pressEnterRetry();
        }

        else{
            clearScreen();
            BattleResultOutView.showVictoryScreen(monsterName, player, expGained, goldGained);
            pressEnterToContinue();
            clearScreen();
            player.ProcessAdvancement();
        }
    }

    private void monsterExeption(Monster monster, String monsterName) {
        if (monster == null) {
            System.err.println("오류: " + monsterName + " 몬스터 데이터를 로드할 수 없습니다.");
        }
    }

    private void startBattle(PlayerCharacter player, Monster monster,
                             BattleService battleService, StageData stage, WorldData world) {
        if (monster.getName() == null) {
            System.err.println("오류: 몬스터 이름이 null입니다. ");
            return;
        }

        BattleController battleController = new BattleController(player, monster, battleService,world, stage);
        battleController.battleStart();
    }
}
