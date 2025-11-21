package main.model.world;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import main.dto.StageData;
import main.dto.WorldData;


public class StageDatabase {

    private List<WorldData> worldDataList = new ArrayList<>();

    private Map<Integer, WorldData> worldDataMap = new HashMap<>();

    public StageDatabase() {
        loadWorldData("WorldData.json");
    }


    private void loadWorldData(String fileName) {
        Gson gson = new Gson();

        Class<WorldData[]> dataType = WorldData[].class;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

            WorldData[] worldDataArray = gson.fromJson(reader, dataType);

            for (WorldData data : worldDataArray) {
                if (data == null) {
                    continue;
                }

                this.worldDataList.add(data);
                this.worldDataMap.put(data.worldId, data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<WorldData> getAllWorlds() {
        return worldDataList;
    }
}