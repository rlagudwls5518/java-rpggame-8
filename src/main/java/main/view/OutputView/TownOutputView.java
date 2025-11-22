package main.view.OutputView;

import main.dto.StageData;
import main.dto.WorldData;
import main.model.unit.character.PlayerCharacter;

public class TownOutputView {
    public static void showTownMenu(PlayerCharacter player, WorldData worldData, StageData stageData) {
        System.out.println("==================================================");
        showplace();
        System.out.println("==================================================");
        System.out.println();
        showState(player);
        System.out.println();
        story();
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("  무엇을 하시겠습니까?");
        System.out.println();
        selectToContinue(worldData, stageData);
        System.out.println();
        System.out.println("==================================================");
        System.out.print("  숫자를 입력하세요:  ");
    }

    private static void showplace() {
        System.out.println("[ 현재 위치: 마을 여관 (안전 구역) ]");
    }

    private static void showState(PlayerCharacter player) {
        System.out.println("  당신: [Lv. " + player.getLevel() + "] " + player.getName());
        System.out.println("  HP: " + player.getHp() + " / " + player.getMaxHp() + "  (체력)");
        System.out.println("  MP: " + player.getMp() + " / " + player.getMaxMp() + "  (마나)");
        System.out.println("  Gold: " + player.getGold() + " G  (소지금)");
    }

    public static void selectToContinue(WorldData worldData, StageData stageData) {
        System.out.println("  1. [이동] '" + stageData.stageName + "' 입구 (Stage" + worldData.worldId + "-" + stageData.stageNumber + ")");
        System.out.println("  2. [메뉴] 내 정보 보기  ");
    }

    private static void story() {
        System.out.println("  \"모닥불의 따뜻한 온기와 모험가들의 활기찬 목소리가 들립니다.");
        System.out.println("   몬스터들은 아직 이곳을 눈치채지 못했습니다...\"");
    }
}
