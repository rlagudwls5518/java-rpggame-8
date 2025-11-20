package main.model.battle;

import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;

public class EndBattle {

    public static void endBattleReword(PlayerCharacter player, Monster monster) {
        player.storeExp(monster.giveExp());
        player.storeGold(monster.giveGold());
    }

    public static void deadPlayerEndBattle(PlayerCharacter player) {
        player.decreaseExp();
        player.storeExp(0);
        player.storeGold(0);
    }


}
