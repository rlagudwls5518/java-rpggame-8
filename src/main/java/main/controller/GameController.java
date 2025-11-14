package main.controller;

import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.model.unit.monster.MonsterDatabase;
import main.util.Clear; // Clear 유틸리티
import main.view.BattleResultOutView;
import main.view.StartOutputView; // 프롤로그 뷰

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameController {

    private final MonsterDatabase monsterDatabase;
    private final Scanner scanner;

    // Key: 스테이지 번호 (1 ~ 40), Value: 몬스터 이름
    private final Map<Integer, String> regularStageMap = new HashMap<>();
    // Key: 월드 번호 (1 ~ 5), Value: 중간 보스 이름
    private final Map<Integer, String> midBossMap = new HashMap<>();
    // Key: 월드 번호 (1 ~ 5), Value: 월드 보스 이름
    private final Map<Integer, String> worldBossMap = new HashMap<>();
    // 최종 보스
    private String finalBossName;


    public GameController() {
        this.monsterDatabase = new MonsterDatabase();
        this.scanner = new Scanner(System.in);
        loadStageData();
    }


    private void loadStageData() {
        // --- WORLD 1: 썩은나무 숲 (Stages 1-8) ---
        regularStageMap.put(1, "썩은나무 고블린");
        regularStageMap.put(2, "거대 독버섯");
        regularStageMap.put(3, "진흙 슬라임");
        regularStageMap.put(4, "길 잃은 새끼 늑대");
        regularStageMap.put(5, "부패한 들쥐");
        regularStageMap.put(6, "숲 거미");
        regularStageMap.put(7, "나무 정령 파수꾼");
        regularStageMap.put(8, "숲 도적");
        midBossMap.put(1, "[숲의 악동] 고블린 족장 '스크래그'");
        worldBossMap.put(1, "[월드 보스] 부패의 군주 '그룰'");

        // --- WORLD 2: 울부짖는 협곡 (Stages 9-16) ---
        regularStageMap.put(9, "협곡 박쥐");
        regularStageMap.put(10, "돌가죽 멧돼지");
        regularStageMap.put(11, "하피");
        regularStageMap.put(12, "코볼트 광부");
        regularStageMap.put(13, "바람 정령");
        regularStageMap.put(14, "낙석 골렘");
        regularStageMap.put(15, "절벽 도마뱀");
        regularStageMap.put(16, "협곡 독수리");
        midBossMap.put(2, "[협곡의 돌주먹] 바위 트롤 '그렁'");
        worldBossMap.put(2, "[월드 보스] 거대 골렘 '기간테스'");

        // --- WORLD 3: 불타는 사막 (Stages 17-24) ---
        regularStageMap.put(17, "사막 전갈");
        regularStageMap.put(18, "미라 병사");
        regularStageMap.put(19, "불개미");
        regularStageMap.put(20, "모래 유령");
        regularStageMap.put(21, "타오르는 도마뱀");
        regularStageMap.put(22, "선인장 괴물");
        regularStageMap.put(23, "황무지 하이에나");
        regularStageMap.put(24, "모래폭풍 정령");
        midBossMap.put(3, "[모래의 암살자] 거대 전갈 '아크라브'");
        worldBossMap.put(3, "[월드 보스] 고대 파라오 '아크나톤'");

        // --- WORLD 4: 얼어붙은 산맥 (Stages 25-32) ---
        regularStageMap.put(25, "설원 늑대");
        regularStageMap.put(26, "아이스 트롤");
        regularStageMap.put(27, "서리 거미");
        regularStageMap.put(28, "얼음 정령");
        regularStageMap.put(29, "혹한의 망령");
        regularStageMap.put(30, "동상 걸린 고블린");
        regularStageMap.put(31, "설인");
        regularStageMap.put(32, "겨울 멧돼지");
        midBossMap.put(4, "[눈보라의 주인] '웬디고'");
        worldBossMap.put(4, "[월드 보스] 서리 용 '니드호그'");

        // --- WORLD 5: 침몰한 도시 (Stages 33-40) ---
        regularStageMap.put(33, "심해어인");
        regularStageMap.put(34, "부패한 해초");
        regularStageMap.put(35, "전기 뱀장어");
        regularStageMap.put(36, "물에 젖은 구울");
        regularStageMap.put(37, "고대 유적 수호자");
        regularStageMap.put(38, "유령 해적");
        regularStageMap.put(39, "거대 집게");
        regularStageMap.put(40, "심해의 군주");
        midBossMap.put(5, "[심해의 문지기] '나가 여왕'");
        worldBossMap.put(5, "[월드 보스] 태고의 존재 '크라켄'");

        // --- FINAL BOSS ---
        finalBossName = "[최종 보스] 차원의 파괴자 '엔트로피'";
    }


    public void run() {
        prollog();
        PlayerCharacter player = new PlayerCharacter("형진");

        int stageCounter = 1;

        for (int world = 1; world <= 5; world++) {
            System.out.println("\n\n=============== [ WORLD " + world + " 진입 ] ===============");
            pressEnterToContinue();
            nomalStage(player, stageCounter, 0, 4);
            midStage(player, world);
            nomalStage(player, stageCounter, 5, 9);
            worldStage(player, world);
        }
        finalStage(player);
    }

    private void startBattle(PlayerCharacter player, String monsterName) {
        if (monsterName == null) {
            System.err.println("오류: " + monsterName + " 몬스터를 찾을 수 없습니다. (데이터 확인 필요)");
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

    private void nomalStage(PlayerCharacter player, int stageCounter, int start, int end) {
        for (int i = start; i < end; i++) {
            String monsterName = regularStageMap.get(stageCounter);
            Monster monsterData = monsterDatabase.createMonster(monsterName);
            int expGained = monsterData.giveExp();
            int goldGained = monsterData.giveGold();

            System.out.println("\n--- [ Stage " + stageCounter + " ] ---");

            startBattle(player, monsterName);

            if (!player.isAlive()) {
                System.out.println("게임 오버...");
                return;
            }
            BattleResultOutView.showVictoryScreen(
                    monsterName,
                    expGained,
                    goldGained,
                    player.getCurrentExp(),
                    player.getMaxExp()
            );
            System.out.println("스테이지 " + stageCounter + " 클리어!");
            stageCounter++;
            pressEnterToContinue();
        }
    }

    private void midStage(PlayerCharacter player, int world) {

        System.out.println("\n--- [ 중간 보스 출현! ] ---");
        String midBossName = midBossMap.get(world);
        Monster monsterData = monsterDatabase.createMonster(midBossName);
        int expGained = monsterData.giveExp();
        int goldGained = monsterData.giveGold();
        startBattle(player, midBossName);

        if (!player.isAlive()) {
            System.out.println("게임 오버...");
            return;
        }
        BattleResultOutView.showVictoryScreen(
                midBossName,
                expGained,
                goldGained,
                player.getCurrentExp(),
                player.getMaxExp()
        );
        System.out.println("중간 보스 격파!");
        pressEnterToContinue();
    }

    private void worldStage(PlayerCharacter player, int world) {
        System.out.println("\n--- [ 월드 보스 출현! ] ---");
        String worldBossName = worldBossMap.get(world);
        Monster monsterData = monsterDatabase.createMonster(worldBossName);
        int expGained = monsterData.giveExp();
        int goldGained = monsterData.giveGold();
        startBattle(player, worldBossName);

        if (!player.isAlive()) {
            System.out.println("게임 오버...");
            return;
        }
        BattleResultOutView.showVictoryScreen(
                worldBossName,
                expGained,
                goldGained,
                player.getCurrentExp(),
                player.getMaxExp()
        );
        System.out.println("월드 " + world + " 클리어!");
    }

    private void finalStage(PlayerCharacter player) {
        System.out.println("\n\n=============== [ 최종 결전 ] ===============");
        Monster monsterData = monsterDatabase.createMonster(finalBossName);
        int expGained = monsterData.giveExp();
        int goldGained = monsterData.giveGold();
        startBattle(player, finalBossName);

        if (player.isAlive()) {
            System.out.println("\n\n축하합니다! 모든 세계를 구원했습니다! (엔딩)");
            BattleResultOutView.showVictoryScreen(
                    finalBossName,
                    expGained,
                    goldGained,
                    player.getCurrentExp(),
                    player.getMaxExp()
            );
        } else {
            System.out.println("최후의 전투에서 패배했습니다...");
        }
    }

    private void prollog() {
        StartOutputView.showSplashScreen();
        Clear.clearScreen();
        StartOutputView.showPrologue();
        Clear.clearScreen();
        StartOutputView.showStartView();
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