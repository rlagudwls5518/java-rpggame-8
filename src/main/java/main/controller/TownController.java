package main.controller;

import static main.util.Clear.clearScreen;
import static main.util.EnterExplantion.pressEnterToContinue;

import main.dto.StageData;
import main.dto.WorldData;
import main.model.unit.character.PlayerCharacter;
import main.view.OutputView.CharacterStateView;
import main.view.OutputView.TownOutputView;
import main.view.inputView.Input;


public class TownController {
    Input input = new  Input();
    private final PlayerCharacter player;
    private final WorldData world;
    private final StageData stage;

    public TownController(PlayerCharacter player, WorldData world, StageData stage) {
        this.player = player;
        this.world = world;
        this.stage = stage;
    }

    public void runTownLoop(){
        while(true){
            clearScreen();
            TownOutputView.showTownMenu(player, world, stage);
            int choice = input.inputNumber();
            if(choice == 1){
                break;
            }
            else if(choice == 2) {
                clearScreen();
                CharacterStateView.CharacterState(player);
                pressEnterToContinue();
            }
        }
    }
}
