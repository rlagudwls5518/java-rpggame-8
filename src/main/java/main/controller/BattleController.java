package main.controller;

import static main.util.EnterExplantion.pressEnterNextTurn;
import static main.util.EnterExplantion.pressEnterToContinue;
import static main.util.InputException.inputException;
import static main.util.ToInt.toInt;

import java.util.Scanner;
import main.dto.StageData;
import main.dto.WorldData;
import main.model.battle.BattleLog;
import main.model.battle.EndBattle;
import main.model.unit.character.PlayerCharacter;
import main.model.unit.monster.Monster;
import main.model.unit.monster.MonsterDatabase; // 1. MonsterDatabase 임포트
import main.util.Clear;
import main.view.OutputView.BattleOutView;
import main.view.inputView.Input;

public class BattleController {
    private final PlayerCharacter player;
    private final Monster monster;
    private final Input input;
    private final MonsterDatabase monsterDatabase;
    private final WorldData worldData;
    private final StageData stage;

    public BattleController(PlayerCharacter player, String monsterName,
                            MonsterDatabase monsterDatabase, Input input, StageData stage, WorldData worldData) {
        this.player = player;
        this.input = input;
        this.monsterDatabase = monsterDatabase;
        this.monster = this.monsterDatabase.createMonster(monsterName);
        this.worldData = worldData;
        this.stage = stage;
    }

    public void battleStart() {

        if (this.monster == null) {
            System.err.println("치명적 오류: 몬스터를 찾지 못해 전투를 시작할 수 없습니다.");
            return;
        }

        boolean isPlayerTurn = player.getAd() > monster.getAd();

        while (player.isAlive() && monster.isAlive()) {
            Clear.clearScreen();
            BattleLog.clearLog();

            BattleOutView.showCombatUI(player, monster, stage.stageName, stage.stageNumber, worldData);

            if (isPlayerTurn) {
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
            BattleOutView.showCombatUI(player, monster, stage.stageName, stage.stageNumber, worldData);
            isPlayerTurn = !isPlayerTurn;
            pressEnterNextTurn();
        }

        if (player.isAlive()) {
            EndBattle.endBattleReword(player, monster);
        } else {
            EndBattle.deadPlayerEndBattle(player, monster);
        }
    }
//    private void processBattle(boolean isPlayerTurn) {
//        if (isPlayerTurn) {
//            processPlayerTurn();
//            if (!monster.isAlive()) {
//                break;
//            }
//            processMonsterTurn();
//        } else {
//            processMonsterTurn();
//            if (!player.isAlive()) {
//                break;
//            }
//            processPlayerTurn();
//        }
//    }

    public void processMonsterTurn() {
        monster.attack(player);
        String monsterLog = BattleLog.getMonsterLog(player, monster);
        BattleLog.addLog(monsterLog);
    }

    public void processPlayerTurn() {
        while(true) {
            int num = input.inputNumber();
            if (num == 1) { // 스킬 사용
                processPlayerSkill();
                break;
            } else { // 기본공격사용
                player.attack(monster);
                String playerLog = BattleLog.getPlayerAttackLog(player);
                BattleLog.addLog(playerLog);
                break;
            }
        }

    }


    private void processPlayerSkill() {
        System.out.println("--- 스킬 목록 ---");
        player.showSkillList();

        System.out.println("6. (취소)");
        System.out.print("사용할 스킬 번호를 입력하세요: ");

        int skillNum = input.inputNumber();

        if (skillNum == 6) {
            System.out.println("스킬 사용을 취소합니다.");
            return;
        }

        boolean skillUsedSuccess = player.useSkill(monster, skillNum);
        if(skillUsedSuccess) {
            String playerLog = BattleLog.getPlayerSkillLog(player, skillNum);
            BattleLog.addLog(playerLog);
        }
        else{
            pressEnterToContinue();
            Clear.clearScreen();
        }

    }
}
