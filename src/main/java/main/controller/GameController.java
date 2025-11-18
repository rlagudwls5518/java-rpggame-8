package main.controller;

import static main.util.EnterExplantion.choicePressNumber;
import static main.util.EnterExplantion.pressEnterToContinue;
import static main.util.EnterExplantion.pressEnterTown;

import main.dto.StageData;
import main.dto.WorldData;
import main.view.CharacterStateView;
import main.view.TownOutputView;
import main.model.world.StageDatabase;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.model.unit.monster.MonsterDatabase;
import main.util.Clear;
import main.view.BattleResultOutView;
import main.view.StartOutputView;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private final MonsterDatabase monsterDatabase;
    private final Scanner scanner;
    private final StageDatabase stageDatabase;

    public GameController() {
        this.monsterDatabase = new MonsterDatabase();
        this.scanner = new Scanner(System.in);
        this.stageDatabase = new StageDatabase();
    }

    public void run() {
        prollog();
        PlayerCharacter player = new PlayerCharacter("형진");
        List<WorldData> allWorlds = stageDatabase.getAllWorlds();
        for (WorldData world : allWorlds) {
            Clear.clearScreen();
            System.out.println("\n\n=============== [ " + world.worldName + " 진입 ] ===============");
            pressEnterToContinue();
            runWorld(player, world);
            if (!player.isAlive()) {
                return;
            }
        }
    }

    private void runWorld(PlayerCharacter player, WorldData world) {
        for (StageData stage : world.stages) {
            String stageType = stage.stageType;
            if ("MID_BOSS".equals(stageType) || "FINAL_BOSS".equals(stageType) || "TRUE_FINAL_BOSS".equals(stageType)) {
                while(true){
                    Clear.clearScreen();
                    TownOutputView.showTownMenu(player, world, stage);
                    int choice = scanner.nextInt();
                    if(choice == 1){
                        break;
                    }
                    else if(choice == 2) {
                        Clear.clearScreen();
                        CharacterStateView.CharacterState(player);
                        pressEnterToContinue();
                    }
                }
            }
            String monsterName = stage.monsterName;

            Monster monsterData = monsterDatabase.createMonster(monsterName);
            if (monsterData == null) {
                System.err.println("오류: " + monsterName + " 몬스터 데이터를 로드할 수 없습니다.");
                continue;
            }
            int expGained = monsterData.giveExp();
            int goldGained = monsterData.giveGold();
            player.refillHpMp();
            startBattle(player, monsterName, stage, world);

            if (!player.isAlive()) {
                Clear.clearScreen();
                BattleResultOutView.showGameOverScreen(monsterName);
                pressEnterTown();
            }

            else{
                Clear.clearScreen();
                BattleResultOutView.showVictoryScreen(monsterName, player, expGained, goldGained);
                pressEnterToContinue();
                Clear.clearScreen();
                player.ProcessAdvancement();
            }
        }
    }

    private void startBattle(PlayerCharacter player, String monsterName, StageData stage, WorldData world) {
        if (monsterName == null) {
            System.err.println("오류: 몬스터 이름이 null입니다. ");
            return;
        }

        BattleController battleController = new BattleController(
                player,
                monsterName,
                monsterDatabase,
                scanner,
                stage,
                world
        );
        battleController.battleStart();
    }

    private void prollog() {
        StartOutputView.showSplashScreen();
        Clear.clearScreen();
        StartOutputView.showPrologue();
        pressEnterToContinue();
        Clear.clearScreen();
        StartOutputView.showStartView();
        choicePressNumber();
        Clear.clearScreen();
    }
}