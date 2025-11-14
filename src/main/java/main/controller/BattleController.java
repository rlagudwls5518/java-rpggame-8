package main.controller;

import java.util.Scanner;
import main.model.battle.BattleLog;
import main.model.battle.EndBattle;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.model.unit.monster.MonsterDatabase; // 1. MonsterDatabase 임포트
import main.util.Clear;
import main.view.BattleOutView;

public class BattleController {
    private PlayerCharacter player;
    private Monster monster;
    private Scanner scanner;
    private MonsterDatabase monsterDatabase;


    public BattleController(PlayerCharacter player, String monsterName,
                            MonsterDatabase monsterDatabase, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
        this.monsterDatabase = monsterDatabase;

        this.monster = this.monsterDatabase.createMonster(monsterName);
    }


    public void battleStart() {

        if (this.monster == null) {
            System.err.println("치명적 오류: 몬스터를 찾지 못해 전투를 시작할 수 없습니다.");
            return;
        }

        while (player.isAlive() && monster.isAlive()) {
            Clear.clearScreen();
            BattleLog.clearLog();

            BattleOutView.showCombatUI(player, monster);

            if (player.getAd() > monster.getAd()) {
                processPlayerTurn();
                if (!monster.isAlive()) {
                    break;
                }
                processMonsterTurn();
            } else {
                processMonsterTurn();
                if (!player.isAlive()) {
                    break;
                }
                processPlayerTurn();
            }

            Clear.clearScreen();
            BattleOutView.showCombatUI(player, monster);

            System.out.println("... (Enter를 눌러 다음 턴 진행)");
            // scanner.nextLine(); // nextInt() 다음에 nextLine()을 한 번만 써서 버퍼를 비우는 게 일반적입니다.
            scanner.nextLine();
        }

        if (player.isAlive()) {
            EndBattle.endBattleReword(player, monster);
        } else {
            EndBattle.deadPlayerEndBattle(player, monster);
        }
    }

    public void processMonsterTurn() {
        monster.attack(player); // 'this.monster', 'this.player' 사용
        String monsterLog = BattleLog.getMonsterLog(player, monster);
        BattleLog.addLog(monsterLog);
    }

    public void processPlayerTurn() {
        int num = scanner.nextInt();
        if (num == 1) { // 스킬 사용
            processPlayerSkill();
        } else { // 기본공격사용
            player.attack(monster);
            String playerLog = BattleLog.getPlayerAttackLog(player);
            BattleLog.addLog(playerLog);
        }
    }


    private void processPlayerSkill() {
        System.out.println("--- 스킬 목록 ---");
        player.showSkillList();

        System.out.println("6. (취소)");
        System.out.print("사용할 스킬 번호를 입력하세요: ");

        int skillNum = scanner.nextInt();
        if (skillNum == 6) {
            System.out.println("스킬 사용을 취소합니다.");
            return;
        }
        player.useSkill(monster, skillNum);
        String playerLog = BattleLog.getPlayerSkillLog(player, skillNum);
        BattleLog.addLog(playerLog);
    }
}
