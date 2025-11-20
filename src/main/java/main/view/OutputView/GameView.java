package main.view.OutputView;

import static main.util.Clear.clearScreen;
import static main.util.EnterExplantion.pressEnterToContinue;

import main.dto.WorldData;

public class GameView {

    public void worldStartView(WorldData world) {
        clearScreen();
        System.out.println("\n\n=============== [ " + world.worldName + " 진입 ] ===============");
        pressEnterToContinue();
    }
}
