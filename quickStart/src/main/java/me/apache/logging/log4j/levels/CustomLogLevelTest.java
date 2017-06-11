package me.apache.logging.log4j.levels;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description 自定义日志级别
 * @date 2017/6/11
 */
public class CustomLogLevelTest {

    private Logger logger = LogManager.getLogger();

    private Level VERBOSE = Level.getLevel("VERBOSE");
    private Level NOTICE = Level.getLevel("NOTICE");
    private Level DIAG = Level.getLevel("DIAG");

    static {
        System.setProperty("log4j.configurationFile", "levels/log4j2_customLogLevel.xml");
    }

    public static void main(String[] args) {
        CustomLogLevelTest customLogLevelTest = new CustomLogLevelTest();
        customLogLevelTest.printLog();
    }

    private void printLog() {
        logger.log(VERBOSE, "verbose log...");
        logger.log(NOTICE, "notice log...");
        logger.log(DIAG, "diag log...");

        logger.trace("trace log...");
        logger.debug("trace log...");
        logger.info("trace log...");
        logger.warn("trace log...");
        logger.error("trace log...");
    }
}
