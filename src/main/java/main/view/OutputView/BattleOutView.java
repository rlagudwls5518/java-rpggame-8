package main.view.OutputView;

import static main.model.battle.BattleLog.showCombatLogUI;

import main.dto.WorldData;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;

public class BattleOutView {

    public static void showCombatUI(PlayerCharacter player, Monster monster, String stageName, int stageNumber, WorldData worldData) {
        monsterHealthBar(monster, stageName, stageNumber, worldData);
        System.out.println();
        monsterAsciArt(monster);
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        showCombatLogUI();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();
        showPlayerHealthBar(player);
        System.out.println();
        System.out.println("[ 행동 선택 ]");
        System.out.println();
        System.out.println("1. 스킬사용  2. 기본 공격");
        System.out.println();
        System.out.println("=======================================================================");
        System.out.print("  명령을 입력하세요: ");
    }

    private static void showPlayerHealthBar(PlayerCharacter player) {
        System.out.println("[" + player.getName() + ": [Lv. " + player.getLevel() + "]  " + player.getJobName() + "]");
        System.out.println();
        System.out.println(
                " 체력(HP): " + drawHealthBar(player.getHp(), player.getMaxHp(), 10) + " 마나(MP): " + drawHealthBar(
                        player.getMp(), player.getMaxMp(), 10));
    }

    private static void monsterHealthBar(Monster currentMonster, String stageName, int stageNumber,  WorldData worldData) {
        System.out.println("=======================================================================");
        System.out.println("                 ["+ worldData.worldId + "-" + stageNumber +" "+ stageName+"]");
        System.out.println("                  ["+currentMonster.getName()+"]");
        System.out.println("           HP: " + drawHealthBar(currentMonster.getHp(), currentMonster.getMaxHp(), 20));
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

    public static void skillView(PlayerCharacter player, int skillNum) {
        System.out.println("--- 스킬 목록 ---");
        player.showSkillList();

        System.out.println("6. (취소)");
        System.out.print("사용할 스킬 번호를 입력하세요: ");

        if (skillNum == 6) {
            System.out.println("스킬 사용을 취소합니다.");
            return;
        }
    }
}
