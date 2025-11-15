package main.view;

public class StartOutputView {

    public static void showSplashScreen() {
        System.out.println("========================================");
        System.out.println();
        System.out.println("              A GAME BY");
        System.out.println();
        System.out.println("              [ 김형진 ]");
        System.out.println("              (개굴개굴)");
        System.out.println();
        System.out.println();
        System.out.println("             DEVELOPMENT");
        System.out.println("               PERIOD");
        System.out.println();
        System.out.println("   [ 2025. 11. 04 ~ 2025. 11. 25 ]");
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
        System.out.println("    세계의 '틈'이 벌어지고 있습니다.");
        System.out.println("    오래된 봉인이 약해지며,");
        System.out.println("    다섯 개의 세계가 ");
        System.out.println("    어둠에 잠식당하고 있습니다.");
        System.out.println();
        System.out.println("    '썩은나무 숲'은 독기로 물들고,");
        System.out.println("    '울부짖는 협곡'은 비명을 삼키며,");
        System.out.println("    '불타는 사막'은 재가 되어갑니다.");
        System.out.println();
        System.out.println("    당신은 이 균열을 막을 유일한 희망,");
        System.out.println("    '차원 방랑자'입니다.");
        System.out.println();
        System.out.println("    다섯 세계의 '중심'을 되찾고,");
        System.out.println("    무너지는 대륙을 구원하십시오.");
        System.out.println();
        System.out.println("========================================");
    }

    public static void showStartView(){
        System.out.println("========================================");
        System.out.println("         PROJECT: DAWNBREAKER");
        System.out.println("      (프로젝트: 여명을 부수는 자)");
        System.out.println("========================================");
        System.out.println();
        System.out.println("           1. 여정을 떠난다");
        System.out.println("           2. 게임을 종료한다");
        System.out.println();
        System.out.println("========================================");
        System.out.println("   숫자를 입력하고 Enter를 누르세요... ");
    }
}
