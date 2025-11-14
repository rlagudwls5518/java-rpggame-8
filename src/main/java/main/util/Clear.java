package main.util;

public class Clear {

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
}
