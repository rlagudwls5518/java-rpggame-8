package main.controller;

import static main.util.Clear.clearScreen;
import static main.util.EnterExplantion.choicePressNumber;
import static main.util.EnterExplantion.pressEnterRetry;
import static main.util.EnterExplantion.pressEnterToContinue;

import main.dto.StageData;
import main.dto.WorldData;
import main.service.BattleService;
import main.view.OutputView.CharacterStateView;
import main.view.OutputView.TownOutputView;
import main.model.world.StageDatabase;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.model.unit.monster.MonsterDatabase;
import main.view.OutputView.BattleResultOutView;
import main.view.OutputView.StartOutputView;
import java.util.List;
import main.view.inputView.Input;

public class GameController {

    private final MonsterDatabase monsterDatabase;
    private final Input input;
    private final StageDatabase stageDatabase;



    public GameController() {
        this.monsterDatabase = new MonsterDatabase();
        this.input = new Input();
        this.stageDatabase = new StageDatabase();
    }

    public void run() {
        prollog();
        PlayerCharacter player = new PlayerCharacter("형진");
        List<WorldData> allWorlds = stageDatabase.getAllWorlds();



        for (WorldData world : allWorlds) {
            clearScreen();
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
                    clearScreen();
                    TownOutputView.showTownMenu(player, world, stage);
                    int choice = input.inputNumber();
                    if(choice == 1){
                        break;
                    }
                    else if(choice == 2) {
                        clearScreen();
                        CharacterStateView.CharacterState(player);
                        pressEnterToContinue();
                    }
                }
            }

            String monsterName = stage.monsterName;
            Monster monster = this.monsterDatabase.createMonster(monsterName);

            if (monster == null) {
                System.err.println("오류: " + monsterName + " 몬스터 데이터를 로드할 수 없습니다.");
                continue;
            }
            int expGained = monster.giveExp();
            int goldGained = monster.giveGold();
            BattleService battleService = new BattleService(player,monster);

            while(true){
                player.refillHpMp();
                startBattle(player, monster, battleService, stage, world);

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
                    break;
                }
            }

        }
    }

    private void startBattle(PlayerCharacter player, Monster monster,
                             BattleService battleService, StageData stage, WorldData world) {
        if (monster.getName() == null) {
            System.err.println("오류: 몬스터 이름이 null입니다. ");
            return;
        }

        BattleController battleController = new BattleController(
                player,
                monster,
                battleService,
                input
        );
        battleController.battleStart(stage, world);
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