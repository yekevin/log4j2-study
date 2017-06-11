package me.apache.logging.log4j.lookups;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.lookup.MainMapLookup;
import org.apache.logging.log4j.message.MapMessage;
import org.apache.logging.log4j.message.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @description
 * MapLookup
 * @date 2017/5/20
 */
public class MapLooklupTest {

    static{
        System.setProperty("log4j.configurationFile","lookup/log4j2_mapLookup.xml");
    }
    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        MainMapLookup.setMainArguments(args);
        MapLooklupTest mapLooklupTest = new MapLooklupTest();
        mapLooklupTest.printLog();
    }

    private void printLog() {
        Map<String,String> map = new HashMap<>();
        map.put("type","type");
        Message message = new MapMessage(map);
        logger.trace(message);
        logger.debug(message);
        logger.info(message);
        logger.warn(message);
        logger.error(message);
        logger.fatal(message);
    }
}
