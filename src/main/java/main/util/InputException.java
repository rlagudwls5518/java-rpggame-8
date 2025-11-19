package main.util;

public class InputException {

    private static final String NOT_INPUT_NUMBER = "숫자가 아닙니다";

    public static void inputException(String inputNum) {
        try {
            Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_NUMBER);
        }
    }
}
