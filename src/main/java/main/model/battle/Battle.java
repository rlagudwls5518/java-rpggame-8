package main.model.battle;

import java.util.Scanner;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;

public class Battle {
    public void miniBattleStart(PlayerCharacter player, Monster monster, Scanner input) {
        while (player.isAlive() && monster.isAlive()) {

            if (player.getAd() > monster.getAd()) {
                processPlayerTurn(player, monster, input);
                if (!monster.isAlive()) {
                    break;
                }
                processMonsterTurn(monster, player);
            } else {
                processMonsterTurn(monster, player);
                if (!player.isAlive()) {
                    break;
                }
                processPlayerTurn(player, monster,input);
            }
        }
        EndBattle.endBattleReword(player, monster);
    }

    public void processMonsterTurn(Monster monster, PlayerCharacter player) {
        monster.attack(player);
    }

    public void processPlayerTurn(PlayerCharacter player, Monster monster, Scanner input) {
        int num = input.nextInt();
        if (num == 1) {// 스킬 사용
            processPlayerSkill(player, monster, input);
        }
        else{ //기본공격사용
            player.attack(monster);
        }
    }

    private void processPlayerSkill(PlayerCharacter player, Monster monster, Scanner sc) {
        System.out.println("--- 스킬 목록 ---");
        // PlayerCharacter가 자신의 스킬 목록을 보여주는 메서드가 필요합니다.
        player.showSkillList(); // (이 메서드는 PlayerCharacter.java에 구현해야 함)

        System.out.println("6. (취소)");
        System.out.print("사용할 스킬 번호를 입력하세요: ");

        int skillNum = sc.nextInt();
        if (skillNum == 6) {
            System.out.println("스킬 사용을 취소합니다.");
            // (턴을 다시 진행하거나, 턴을 종료해야 함. 지금은 간단히 턴 종료로 처리)
            return;
        }
        player.useSkill(monster, skillNum);
    }
}
