package me.apache.logging.log4j.asyncLoggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;

/**
 * @author Kevin
 * @description
 * @date 2017/6/11
 */
public class AsyncLoggerTest {
    static {
        System.setProperty("log4j.configurationFile", "asyncLoggers/log4j2_asyncLogger.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        AsyncLoggerTest asyncLoggerTest = new AsyncLoggerTest();
        while (true) {
            asyncLoggerTest.printLog();
        }
    }

    private void printLog() {
//        logger.trace("trace log");
//        logger.debug("debug log");
//        logger.info("info log");
//        logger.warn("warn log");
//        logger.error("error log");
//        logger.debug("hello {} {}", 2L, false);
        logger.debug("hello {} {}", Unbox.box(2L), Unbox.box(false));
    }
}
