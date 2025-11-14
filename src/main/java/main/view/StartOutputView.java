package main.view;

public class StartOutputView {

    public static void showSplashScreen() {
        System.out.println("========================================");
        System.out.println();
        System.out.println("             A GAME BY");
        System.out.println();
        System.out.println("             [ 김형진 ]");
        System.out.println("              (개굴개굴)");
        System.out.println();
        System.out.println();
        System.out.println("     DEVELOPMENT PERIOD");
        System.out.println();
        System.out.println("   [ 2025. 10. 04 ~ 2025. 11. 18 ]");
        System.out.println();
        System.out.println("========================================");
        System.out.println();
        System.out.println();
        System.out.println("   \"이제, 당신의 여정이 시작됩니다.\"");
        System.out.println();
        System.out.println();
        System.out.println("[ 잠시 후 게임이 시작됩니다... ]");
        System.out.println();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void showPrologue() {
        System.out.println("========================================");
        System.out.println();
        System.out.println("    오래전, '에루나' 대륙은");
        System.out.println("    고대 드래곤들의 가호 아래");
        System.out.println("    조화와 번영을 누리고 있었다.");
        System.out.println();
        System.out.println("    그러나, 심연의 군주 '자르곤'이 깨어나");
        System.out.println("    대륙을 끝없는 어둠 속에 가두었다.");
        System.out.println();
        System.out.println("    찬란했던 왕국들은 무너졌고,");
        System.out.println("    희망의 불씨는 꺼져가는 듯했다.");
        System.out.println();
        System.out.println("    이제, 고대의 예언에 따라");
        System.out.println("    '빛의 조각'을 모을 유일한 용사,");
        System.out.println("    바로 당신이 나설 차례다.");
        System.out.println();
        System.out.println("    이 험난한 여정을 받아들이고,");
        System.out.println("    '자르곤'을 물리쳐 대륙에 빛을 되찾아라.");
        System.out.println();
        System.out.println("========================================");
        System.out.print("\n[ Enter 키를 눌러 계속하기... ]");

    }

    public static void showStartView(){
        System.out.println("========================================");
        System.out.println("           PROJECT: DRAGON KNIGHT");
        System.out.println("========================================");
        System.out.println();
        System.out.println("      1. 여정을 떠난다");
        System.out.println("      2. 게임을 종료한다");
        System.out.println();
        System.out.println("========================================");
        System.out.println("   숫자를 입력하고 Enter를 누르세요... ");
    }
}
