package main.view;

public class BattleResultOutView {

    public static void showVictoryScreen(String monsterName, int expGained, int creditGained, int currentExp, int maxExp) {

        int expToNextLevel = maxExp - currentExp;

        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.println("                ☆★ 전투 승리! ★☆");
        System.out.println();
        System.out.println("==================================================");
        System.out.println();


        System.out.printf("   '%s'를 성공적으로 설득(처치)했습니다!\n", monsterName);
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("                [ 획득 보상 ]");
        System.out.println();
        System.out.printf("   ▶ 경험치 (EXP) :  + %d\n", expGained);
        System.out.printf("   ▶ 크레딧 (Credit) : + %d C\n", creditGained);
        //System.out.printf("   ▶ 획득 아이템 : [%s] x 1\n", itemName);
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.printf("   현재 경험치: %d / %d (다음 레벨까지 %d)\n", currentExp, maxExp, expToNextLevel);
        System.out.println();
        System.out.println();
        System.out.println("[ Enter 키를 눌러 스테이지로 돌아가기... ]");
    }
}
