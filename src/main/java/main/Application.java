package main;

import main.controller.GameController;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        GameController gameController = new GameController();
        gameController.run();
    }
}
