package main.view;

import main.model.unit.character.PlayerCharacter;

public class CharacterStateView {


    public static void CharacterState(PlayerCharacter player) {
        System.out.println("==================================");
        System.out.println("[ 캐릭터 정보 (내 상태) ]");
        System.out.println("==================================");
        System.out.println();
        System.out.println("  당신: [Lv. " + player.getLevel() + "]" + player.getName());
        System.out.println("  직업: " + player.getJobName());
        System.out.println();
        System.out.println("  [ 스탯 ]");
        System.out.println("  - HP:" + player.getHp() + "/" + player.getMaxHp());
        System.out.println("  - HP:" + player.getMp() + "/" + player.getMaxMp());
        System.out.println();
        System.out.println("  - 공격력 (ad) : " + player.getAd());
        System.out.println("  - 방어력 (df) : " + player.getDefense());
        System.out.println();
        System.out.println("==================================");
    }
}
