package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.MapMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @description
 * @date 2017/5/19
 */
public class MapFilterTest {

    static {
        System.setProperty("log4j.configurationFile", "filter/log4j2_markerFilter.xml");
    }

    private Logger logger = LogManager.getLogger();
    private static final Marker MSG_MARKER = MarkerManager.getMarker("MESSAGE");

    public static void main(String[] args) {
        MapFilterTest mapFilterTest = new MapFilterTest();
        mapFilterTest.printLog();
    }

    private void printLog() {
        Map<String,String> map = new HashMap<>();
        map.put("test","test");
        MapMessage mapMessage = new MapMessage(map);
        logger.debug(MSG_MARKER,mapMessage);

        map.put("name","Kevin");

        mapMessage = new MapMessage(map);
        logger.debug(MSG_MARKER,mapMessage);
    }
}
