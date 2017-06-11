package me.apache.logging.log4j.test;

public interface LevelController {

    /**
     * 
     * @param key ThreadContext中put的key
     * @return
     */
    public String getLevelName(String key);
}
