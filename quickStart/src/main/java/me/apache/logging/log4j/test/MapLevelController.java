package me.apache.logging.log4j.test;

import java.util.Map;

public class MapLevelController implements LevelController {

    // 日志级别map key:交易码 value:日志级别
    private Map<String, String> levelMap;

    public MapLevelController(Map<String, String> levelMap) {
        this.levelMap = levelMap;
    }

    @Override
    public String getLevelName(String key) {
        return levelMap.get(key);
    }

}
