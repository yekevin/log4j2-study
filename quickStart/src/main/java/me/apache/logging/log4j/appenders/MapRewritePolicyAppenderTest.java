package me.apache.logging.log4j.appenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MapMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @description RewriteAppender 允许对LogEvent进行操作，修改，后然再传递给后续appender处理
 * @date 2017/5/29
 */
public class MapRewritePolicyAppenderTest {
    static{
        System.setProperty("log4j.configurationFile","appender/log4j2_mapRewritePolicyAppender.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        MapRewritePolicyAppenderTest mapRewritePolicyAppenderTest = new MapRewritePolicyAppenderTest();
        mapRewritePolicyAppenderTest.printLog();
    }

    private void printLog() {
        Map<String,String> map = new HashMap<>();
        map.put("product","myProduct");
        map.put("price","100.00");

        MapMessage mapMessage = new MapMessage(map);
        logger.trace(mapMessage);
        logger.debug(mapMessage);
        logger.info(mapMessage);
        logger.warn(mapMessage);
        logger.error(mapMessage);
    }
}
