package main.model.unit.monster;

import java.util.HashMap;
import java.util.Map;

public class MonsterDatabase {

    private static Map<String, MiniMonsterInfo> miniMonster = new HashMap<>();
    private static Map<String, MidBossMonsterInfo> midBoss = new HashMap<>();
    private static Map<String, WorldBossInfo> worldBoss = new HashMap<>();

    public static void init() {
        miniMonster.put("goblin_1_1", new MiniMonsterInfo(
                "썩은나무 고블린", 50, 10, 50, 10, 5, 0, 0, 10, "낡은 단검을 든 고블린이 뛰쳐나왔다!"));

        midBoss.put("spider_1_5", new MidBossMonsterInfo(
                "거대 독거미", 300, 50, 300, 50, 10, 5, 50, 50, "수십 개의 붉은 겹눈이 섬뜩하게 빛난다."));

        worldBoss.put("golem_1_10", new WorldBossInfo(
                "우드골렘", 1000, 100, 1000, 100, 25, 15, 300, "거대한 '우드골렘'이 당신을 '침입자'로 규정했다."));
    }

    public static MiniMonsterInfo createMiniMonster(String id) {
        MiniMonsterInfo original = miniMonster.get(id);
        if (original == null) {
            System.out.println("오류: " + id + " 몬스터 원본을 찾을 수 없습니다.");
            return null;
        }

        return new MiniMonsterInfo(original);
    }

    public static MidBossMonsterInfo createMidBoss(String id) {
        MidBossMonsterInfo original = midBoss.get(id);
        if (original == null) {
            System.out.println("오류: " + id + " 몬스터 원본을 찾을 수 없습니다.");
            return null;
        }
        return new MidBossMonsterInfo(original);
    }


    public static WorldBossInfo createWorldBoss(String id) {
        WorldBossInfo original = worldBoss.get(id);
        if (original == null) {
            System.out.println("오류: " + id + " 몬스터 원본을 찾을 수 없습니다.");
            return null;
        }
        return new WorldBossInfo(original);
    }
}
