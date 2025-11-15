package main.view;

import static main.model.battle.BattleLog.showCombatLogUI;

import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;

public class BattleOutView {

    public static void showCombatUI(PlayerCharacter player, Monster monster) {
        monsterHealthBar(monster);
        System.out.println();
        monsterAsciArt(monster);
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        showCombatLogUI();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();
        showPlayerHealthBar(player);
        System.out.println("[ 행동 선택 ]");
        System.out.println();
        System.out.println("1. 스킬사용  2. 기본 공격");
        System.out.println();
        System.out.println("=======================================================================");
        System.out.print("  명령을 입력하세요: ");
    }

    private static void showPlayerHealthBar(PlayerCharacter player) {
        System.out.println("[" + player.getName() + ": [Lv. " + player.getLevel() + "]" + player.getJobName() + "]");
        System.out.println(
                " 체력(HP): " + drawHealthBar(player.getHp(), player.getMaxHp(), 10) + " 마력(MP): " + drawHealthBar(
                        player.getMp(), player.getMaxMp(), 10));
    }

    private static void monsterHealthBar(Monster currentMonster) {
        System.out.println("=======================================================================");
        System.out.println("                 [ " + currentMonster.getName() + " ]");
        System.out.println("          HP: " + drawHealthBar(currentMonster.getHp(), currentMonster.getMaxHp(), 20));
        System.out.println("=======================================================================");
    }

    private static void monsterAsciArt(Monster currentMonster) {
        System.out.println("                     +-----------------------+");
        String art = currentMonster.getAsciiArt();

        for (String line : art.split("\n")) {
            System.out.printf("                     | %-21s |\n", line);
        }
        System.out.println("                     +-----------------------+");
    }

    private static String drawHealthBar(int hp, int maxHp, int totalLength) {
        if (maxHp <= 0) {
            return "[" + " ".repeat(totalLength) + "]";
        }

        if (hp < 0) {
            hp = 0;
        }

        if (hp > maxHp) {
            hp = maxHp;
        }

        int filledBars = (int) (((double) hp / maxHp) * totalLength);
        int emptyBars = totalLength - filledBars;

        String filledPart = "■".repeat(filledBars);
        String emptyPart = " ".repeat(emptyBars);
        return "[" + filledPart + emptyPart + "]";
    }
}
