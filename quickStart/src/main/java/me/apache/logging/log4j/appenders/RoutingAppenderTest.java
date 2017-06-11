package me.apache.logging.log4j.appenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 * @author Kevin
 * @description
 * @date 2017/5/29
 */
public class RoutingAppenderTest {
    static{
        System.setProperty("log4j.configurationFile","appender/log4j2_routingAppender.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        RoutingAppenderTest routingAppenderTest = new RoutingAppenderTest();
        routingAppenderTest.printLog();
    }

    private void printLog() {
        ThreadContext.put("type","Console");
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
        ThreadContext.clearMap();

        ThreadContext.put("type","File");
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
        ThreadContext.clearMap();
    }
}
