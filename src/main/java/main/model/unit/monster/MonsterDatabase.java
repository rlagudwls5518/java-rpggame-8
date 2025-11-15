package main.model.unit.monster;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import main.dto.MonsterData;
import java.nio.charset.StandardCharsets;

public class MonsterDatabase {

    private Map<String, Monster> monsterPrototypes = new HashMap<>();


    public MonsterDatabase() {
        loadMonsterData("MiniMonster.json");
        loadMonsterData("BossMonster.json");
    }

    private void loadMonsterData(String fileName) {
        Gson gson = new Gson();
        MonsterType type;
        Class<MonsterData[]> dataType = MonsterData[].class;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

            MonsterData[] monsterDataArray = gson.fromJson(reader, dataType);

            for (MonsterData data : monsterDataArray) {
                if (data.name == null) {
                    continue;
                }

                if (data.type == null) {
                    type = MonsterType.MINI;
                }else{
                    type = MonsterType.valueOf(data.type);
                }

                String art = String.join("\n", data.artLines);

                Monster prototype = new Monster(
                        type,
                        data.name, data.hp, data.mp,
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
