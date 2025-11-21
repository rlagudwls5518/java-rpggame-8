package main.view.inputView;


import static main.util.InputException.inputException;
import static main.util.ToInt.toInt;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);

    public int inputNumber() {
        String num = scanner.nextLine();
        inputException(num);
        return toInt(num);
    }
}
