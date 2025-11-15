package main.controller;


import main.dto.StageData;
import main.dto.WorldData;
import main.world.StageDatabase;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.model.unit.monster.MonsterDatabase;
import main.util.Clear;
import main.view.BattleResultOutView;
import main.view.StartOutputView;
import java.util.List;
import java.util.Scanner;
import main.view.TownOutputView;

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

            System.out.println("\n\n=============== [ " + world.worldName + " 진입 ] ===============");
            pressEnterToContinue();
            runWorld(player, world);
            if (!player.isAlive()) {

                return;
            }
        }
    }

    //            if (player.getLevel() < world.requiredLevel) {
    //                System.out.println("\n" + world.worldName + "에 진입하려면 Lv." + world.requiredLevel + " 이상이 필요합니다.");
    //                System.out.println("... 모험이 부족한 것 같습니다 ...");
    //                break;
    //            }
    //        if (player.isAlive()) {
    //            System.out.println("\n\n축하합니다! 모든 세계를 구원했습니다! (엔딩)");
    //        } else {
    //            System.out.println("최후의 전투에서 패배했습니다...");
    //        }


    private void runWorld(PlayerCharacter player, WorldData world) {

        for (StageData stage : world.stages) {
//            String stageType = stage.stageType;
//            if ("MID_BOSS".equals(stageType) || "FINAL_BOSS".equals(stageType) || "TRUE_FINAL_BOSS".equals(stageType)) {
//                TownOutputView.showTownMenu(player);
//            }

            System.out.println("\n--- [ " + stage.stageName + " ] ---");
            String monsterName = stage.monsterName;

            Monster monsterData = monsterDatabase.createMonster(monsterName);
            if (monsterData == null) {
                System.err.println("오류: " + monsterName + " 몬스터 데이터를 로드할 수 없습니다.");
                continue;
            }
            int expGained = monsterData.giveExp();
            int goldGained = monsterData.giveGold();

            startBattle(player, monsterName);
            player.refillHpMp();

            if (!player.isAlive()) {
                Clear.clearScreen();
                System.out.println("게임 오버...");
                return;
            }

            Clear.clearScreen();
            BattleResultOutView.showVictoryScreen(
                    monsterName,
                    expGained,
                    goldGained,
                    player.getCurrentExp(),
                    player.getMaxExp()
            );
            pressEnterToContinue();
        }
    }


    private void startBattle(PlayerCharacter player, String monsterName) {
        if (monsterName == null) {
            System.err.println("오류: 몬스터 이름이 null입니다. ");
            return;
        }
        System.out.println(monsterName + "이(가) 나타났다!");

        BattleController battleController = new BattleController(
                player,
                monsterName,
                monsterDatabase,
                scanner
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
        pressEnterToContinue();
        Clear.clearScreen();
    }

    private void pressEnterToContinue() {
        System.out.println("\n(계속하려면 Enter를 누르세요...)");
        try {
            scanner.nextLine();
        } catch (Exception e) {
        }
    }
}