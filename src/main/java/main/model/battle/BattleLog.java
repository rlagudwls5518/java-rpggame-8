package main.model.battle;

import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;


public class BattleLog {

    private static StringBuilder combatLog = new StringBuilder();

    public static void clearLog() {
        combatLog.setLength(0);
    }

    public static void addLog(String logLine) {
        combatLog.append(logLine).append("\n");
    }

    public static String getPlayerSkillLog(PlayerCharacter player, int skillNum) {
        String playerSkillLog = player.getName() + "은(는) " + player.showSkillName(skillNum) + " 스킬을 사용했다!!";
        return playerSkillLog;
    }

    public static String getPlayerAttackLog(PlayerCharacter player) {
        String playerLog = player.getName() + "은(는) 기본공격으로 공격한다!!";
        return playerLog;
    }

    public static String getMonsterLog(PlayerCharacter player, Monster currentMonster) {
        String monsterLog = currentMonster.getName() + "가 " + player.getName() + "을(를) 할퀴었다!";
        return monsterLog;
    }

    public static void showCombatLogUI() {

        System.out.println(" [ 전투 로그 ]");
        String logText = combatLog.toString();

        if (logText.isEmpty()) {
            System.out.println(" (...)");
            return;
        }

        for (String line : logText.split("\n")) {
            System.out.println(" " + line);
        }
    }
}
