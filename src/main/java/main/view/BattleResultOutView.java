package main.view;

public class BattleResultOutView {

    public static void showVictoryScreen(String monsterName, int expGained, int creditGained, int currentExp, int maxExp) {

        int expToNextLevel = maxExp - (expGained % maxExp);

        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.println("                ☆★ 전투 승리! ★☆");
        System.out.println();
        System.out.println("==================================================");
        System.out.println();


        System.out.printf("   '%s'를 성공적으로 처치했습니다!\n", monsterName);
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("                [ 획득 보상 ]");
        System.out.println();
        System.out.printf("   ▶ 경험치 (EXP) :  + %d\n", expGained);
        System.out.printf("   ▶ 크레딧 (Credit) : + %d C\n", creditGained);
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.printf("   현재 경험치: %d / %d (다음 레벨까지 %d)\n", currentExp, maxExp, expToNextLevel);
        System.out.println();
        System.out.println();
    }

    public static void showGameOverScreen(String monsterName) {
        System.out.println("==================================================");
        System.out.println();
        System.out.println("                ... G A M E   O V E R ...");
        System.out.println();
        System.out.println("                       전투 패배");
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.println("   당신의 체력(HP)이 0이 되어");
        System.out.println("   차가운 바닥에 쓰러지고 말았습니다...");
        System.out.println();
        System.out.println("   (의식이 흐려집니다...)");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("                  [ 전투 실패 결과 ]");
        System.out.println();
        System.out.println("   ▶ "+monsterName+"공략에 실패했습니다.");
        System.out.println("   ▶ 획득한 경험치(EXP)와 골드가 없습니다.");
        System.out.println("   ");
        System.out.println("   [ 패널티 ]");
        System.out.println("   ▶ 패배의 충격으로 소지한 10 골드를 잃었습니다.");
        System.out.println("   ▶ 패배의 충격으로 경험치를 잃었습니다.");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("   \"\"포기하지 마세요. 마을에서 재정비 후 다시 도전합시다.\"\"");
        System.out.println();
        System.out.println();
    }
}
