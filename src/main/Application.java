package main;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        String name = "김전사";
        String job = "전사";
        int level = 1;
        int exp = 0;
        int hp = 30;
        int gold = 0;
        String weapon = "낡은 목도";
        String shield = "나무 방패(2)";


        for (int i = 0; i < 10; i++) {
            clearScreen();
            printStatus(name, job, level, exp, hp, gold, weapon, shield);
            Thread.sleep(1000);

            hp -= 5;
            exp += 10;

            if (hp <= 0) {
                clearScreen();
                System.out.println("-----------GAME OVER-----------");
                break;
            }
        }
    }

    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            ProcessBuilder processBuilder;
            if (os.contains("win")) {
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                processBuilder = new ProcessBuilder("clear");
            }
            processBuilder.inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printStatus(String name, String job, int level, int exp, int hp, int gold, String weapon, String shield) {
        System.out.println("-----------□게임 월드□-----------");
        System.out.printf("%-6s : %-10s   %s : %s\n", "이름", name, "클래스", job);
        System.out.printf("%-6s : %-10d   %s : %d\n", "LV", level, "EXP", exp);
        System.out.printf("%-6s : %-10d   %s : %d\n", "HP", hp, "골드", gold);
        System.out.printf("%-6s : %-10s   %s : %s\n", "무기", weapon, "방패", shield);
        System.out.println("------------------------------------");
    }

}
