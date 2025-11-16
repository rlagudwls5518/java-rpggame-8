package main.util;

import java.util.Scanner;

public class EnterExplantion  {
    private static final Scanner scanner = new Scanner(System.in);

    public static void pressEnterToContinue() {
        System.out.println("\n(계속하려면 Enter를 누르세요...)");
        pressEnter();
    }

    public static void pressEnterTown(){
        System.out.print("[ Enter 키를 누르면 '마을'로 돌아갑니다... ]");
        pressEnter();
    }

    public static void pressEnterNextTurn(){
        System.out.println("... (Enter를 눌러 다음 턴 진행)");
        pressEnter();
    }

    private static void pressEnter(){
        try {
            scanner.nextLine();
        } catch (Exception e) {
        }
    }
}
