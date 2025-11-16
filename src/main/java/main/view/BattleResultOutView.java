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
        System.out.println("   모니터 앞에 쓰러지고 말았습니다...");
        System.out.println();
        System.out.println("   (저 멀리서 포비의 목소리가 들리는 듯합니다. ");
        System.out.println("    \"체력 관리도 실력입니다.\")");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("                  [ 전투 실패 결과 ]");
        System.out.println();
        System.out.println("   ▶ "+monsterName+"공략에 실패했습니다.");
        System.out.println("   ▶ 획득한 경험치(EXP)와 크레딧이 없습니다.");
        System.out.println("   ");
        System.out.println("   [ 패널티 ]");
        System.out.println("   ▶ 집중력이 흐트러져 소지한 10 크레딧을 잃었습니다.");
        System.out.println("   ▶ 집중력이 흐트러져 경험치를 잃었습니다.");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("   \"포기하지 마세요. 잠시 쉬고 다시 도전합시다.\"");
        System.out.println();
        System.out.println();

        // 마지막 줄은 print()를 사용해 커서가 같은 줄에 머물도록 함
        System.out.print("[ Enter 키를 누르면 '마을'로 돌아갑니다... ]");

        // 마을로 돌아가는 로직을 시뮬레이션
        System.out.println(); // 줄바꿈
        System.out.println("\n휴게실(마을)로 돌아갑니다...");
    }
}
