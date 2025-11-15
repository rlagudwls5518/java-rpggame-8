package main.view;

import main.model.unit.character.PlayerCharacter;

public class TownOutputView {
    public static void showTownMenu(PlayerCharacter player) {
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
        pressEnterToContinue();
        System.out.println();
        System.out.println("==================================================");
        System.out.print("  숫자를 입력하세요:  ");
    }

    private static void showplace() {
        System.out.println("[ 현재 위치: '시작의 마을' 여관 (안전 구역) ]");
    }

    private static void showState(PlayerCharacter player) {
        System.out.println("  당신: [Lv. " + player.getLevel() + "] " + player.getName());
        System.out.println("  HP: " + player.getHp() + " / " + player.getMaxHp() + "  (체력)");
        System.out.println("  MP: " + player.getMp() + " / " + player.getMaxMp() + "  (마력)");
        System.out.println("  Gold: " + player.getGold() + " G  (소지금)");
    }

    private static void pressEnterToContinue() {
        System.out.println("  1. [휴식] 여관 주인 (체력/마력 모두 회복 -10 G)");
        System.out.println("  2. [상점] 대장간 (검, 방패, 갑옷 - 준비 중)");
        System.out.println("  3. [이동] '초보자의 숲' 입구 (Stage 1-1)");
        System.out.println("  4. [메뉴] 내 정보 보기 / 저장하기 (준비 중)");
    }

    private static void story() {
        System.out.println("  \"모닥불의 따뜻한 온기와 모험가들의 활기찬 목소리가 들립니다.");
        System.out.println("   '자르곤'의 군대는 아직 이곳을 눈치채지 못했습니다...\"");
    }
}
