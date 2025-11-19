package main.util;

public class InputException {
    public static void inputException(String inputNum) {
        try {
            Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
