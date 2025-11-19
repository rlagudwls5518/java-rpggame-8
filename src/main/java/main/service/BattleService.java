package main.service;

import static main.util.Clear.clearScreen;
import static main.util.EnterExplantion.pressEnterToContinue;

import main.model.battle.BattleLog;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;


public class BattleService {

    private final PlayerCharacter player;
    private final Monster monster;


    public BattleService(PlayerCharacter player,Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void processPlayerTurn(int num) {
        while (true) {
            if (num == 1) { // 스킬 사용
                processPlayerSkill(num);
                break;
            } else { // 기본공격 사용
                player.attack(monster);
                String playerLog = BattleLog.getPlayerAttackLog(player);
                BattleLog.addLog(playerLog);
                break;
            }
        }
    }

    public void processMonsterTurn() {
        monster.attack(player);
        String monsterLog = BattleLog.getMonsterLog(player, monster);
        BattleLog.addLog(monsterLog);
    }

    private void processPlayerSkill(int skillNum) {
        System.out.println("--- 스킬 목록 ---");
        player.showSkillList();

        System.out.println("6. (취소)");
        System.out.print("사용할 스킬 번호를 입력하세요: ");

        if (skillNum == 6) {
            System.out.println("스킬 사용을 취소합니다.");
            return;
        }

        boolean skillUsedSuccess = player.useSkill(monster, skillNum);
        if (skillUsedSuccess) {
            String playerLog = BattleLog.getPlayerSkillLog(player, skillNum);
            BattleLog.addLog(playerLog);
        } else {
            pressEnterToContinue();
            clearScreen();
        }

    }
}
