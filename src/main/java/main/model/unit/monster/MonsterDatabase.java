package main.model.unit.monster;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import main.dto.JsonToBoss;
import main.dto.JsonToMonster;

public class MonsterDatabase {

    private Map<String, Monster> monsterPrototypes = new HashMap<>();


    public MonsterDatabase() {
        loadMonsters("MiniMonster.json");
        loadBosses("BossMonster.json");
    }

    private void loadMonsters(String fileName) {
        Gson gson = new Gson();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             Reader reader = new InputStreamReader(inputStream)) {

            JsonToMonster[] monsterDataArray = gson.fromJson(reader, JsonToMonster[].class);

            for (JsonToMonster data : monsterDataArray) {
                if (data.name == null) {
                    continue;
                }
                String art = String.join("\n", data.artLines);

                Monster prototype = new Monster(
                        MonsterType.MINI,
                        data.name, data.hp, data.mp, data.hp, data.mp,
                        data.attackDamage, data.magicForce, data.defense, data.gold,
                        data.exp, data.description, art
                );

                this.monsterPrototypes.put(prototype.name, prototype);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBosses(String fileName) {
        Gson gson = new Gson();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             Reader reader = new InputStreamReader(inputStream)) {

            JsonToBoss[] bossDataArray = gson.fromJson(reader, JsonToBoss[].class);

            for (JsonToBoss data : bossDataArray) {
                if (data.name == null) {
                    continue;
                }

                MonsterType type = MonsterType.valueOf(data.type);
                String art = String.join("\n", data.artLines);

                Monster prototype = new Monster(
                        type,
                        data.name, data.hp, data.mp, data.hp, data.mp,
                        data.attackDamage, data.magicForce, data.defense, data.gold,
                        data.exp, data.description, art
                );

                this.monsterPrototypes.put(prototype.name, prototype);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Monster createMonster(String name) {
        Monster prototype = monsterPrototypes.get(name);
        if (prototype == null) {
            System.err.println("오류: " + name + " 몬스터 원본을 찾을 수 없습니다.");
            return null;
        }

        return new Monster(prototype);
    }
}
