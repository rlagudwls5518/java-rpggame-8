package main.view.OutputView;

import static main.model.battle.BattleLog.showCombatLogUI;

import main.dto.WorldData;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;

public class ConsoleBattleView implements BattleView {
    @Override
    public void showCombatUI(PlayerCharacter player, Monster monster, String stageName, int stageNumber,
                             WorldData world) {
        monsterHealthBar(monster, stageName, stageNumber, world);
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

    @Override
    public void showPlayerHealthBar(PlayerCharacter player) {
        System.out.println("[" + player.getName() + ": [Lv. " + player.getLevel() + "]  " + player.getJobName() + "]");
        System.out.println();
        System.out.println(
                " 체력(HP): " + drawHealthBar(player.getHp(), player.getMaxHp(), 10) + " 마나(MP): " + drawHealthBar(
                        player.getMp(), player.getMaxMp(), 10));
    }

    @Override
    public void monsterHealthBar(Monster currentMonster, String stageName, int stageNumber, WorldData worldData) {
        System.out.println("=======================================================================");
        System.out.println("                 ["+ worldData.worldId + "-" + stageNumber +" "+ stageName+"]");
        System.out.println("                  ["+currentMonster.getName()+"]");
        System.out.println("           HP: " + drawHealthBar(currentMonster.getHp(), currentMonster.getMaxHp(), 20));
        System.out.println("=======================================================================");
    }

    @Override
    public void monsterAsciArt(Monster currentMonster) {
        System.out.println("                     +-----------------------+");
        String art = currentMonster.getAsciiArt();

        for (String line : art.split("\n")) {
            System.out.printf("                     | %-21s |\n", line);
        }
        System.out.println("                     +-----------------------+");
    }

    @Override
    public String drawHealthBar(int hp, int maxHp, int totalLength) {
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

    @Override
    public void skillView(PlayerCharacter player, int skillNum) {
        System.out.println("--- 스킬 목록 ---");
        player.showSkillList();

        System.out.println("6. (취소)");
        System.out.print("사용할 스킬 번호를 입력하세요: ");

        if (skillNum == 6) {
            System.out.println("스킬 사용을 취소합니다.");
            return;
        }
    }

    @Override
    public void showVictoryScreen(String monsterName, PlayerCharacter player, int expGained, int goldGained) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.println("                ☆★ 전투 승리! ★☆");
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.printf("   '%s'를 성공적으로 처치했습니다!\n", monsterName);
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("                [ 획득 보상 ]");
        System.out.println();
        System.out.printf("   ▶ 경험치 (EXP) :  + %d\n", expGained);
        System.out.printf("   ▶ 골드  (gold) : + %d C\n", goldGained);
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.printf("   현재 경험치: %d / %d (다음 레벨까지 %d)\n",
                player.caculateLevel(expGained), player.getMaxExp(), player.getMaxExp()-player.caculateLevel(expGained));
        System.out.println();
        System.out.println();
    }

    @Override
    public void showGameOverScreen(String monsterName) {
        System.out.println("==================================================");
        System.out.println();
        System.out.println("                ... G A M E   O V E R ...");
        System.out.println();
        System.out.println("                       전투 패배");
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.println("   당신의 체력(HP)이 0이 되어");
        System.out.println("   차가운 바닥에 쓰러지고 말았습니다...");
        System.out.println();
        System.out.println("   (의식이 흐려집니다...)");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("                  [ 전투 실패 결과 ]");
        System.out.println();
        System.out.println("   ▶ " + monsterName + "공략에 실패했습니다.");
        System.out.println("   ▶ 획득한 경험치(EXP)와 골드가 없습니다.");
        System.out.println("   [ 패널티 ]");
        System.out.println("   ▶ 패배의 충격으로 소지한 10 골드를 잃었습니다.");
        System.out.println("   ▶ 패배의 충격으로 경험치를 잃었습니다.");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("   \"\"포기하지 마세요. 마을에서 재정비 후 다시 도전합시다.\"\"");
        System.out.println();
        System.out.println();
    }
}
