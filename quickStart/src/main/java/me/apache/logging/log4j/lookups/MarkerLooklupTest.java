package me.apache.logging.log4j.lookups;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * @author Kevin
 * @description
 * Marker的替换
 * 配置方式：%marker
 * @date 2017/5/20
 */
public class MarkerLooklupTest {

    static{
        System.setProperty("log4j.configurationFile","lookup/log4j2_markerLookup.xml");
    }
    public static final Marker SQL = MarkerManager.getMarker("SQL");
    public static final Marker PAYLOAD = MarkerManager.getMarker("PAYLOAD");
    public static final Marker PERFORMANCE = MarkerManager.getMarker("PERFORMANCE");

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        MarkerLooklupTest markerLooklupTest = new MarkerLooklupTest();
        markerLooklupTest.printLog();
    }

    private void printLog() {
        logger.info(SQL, "Message in Sql.log");
        logger.info(PAYLOAD, "Message in Payload.log");
        logger.info(PERFORMANCE, "Message in Performance.log");
    }
}
