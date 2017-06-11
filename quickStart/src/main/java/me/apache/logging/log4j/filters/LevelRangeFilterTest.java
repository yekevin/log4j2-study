package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * LevelRangeFilter:基于日志级别范围过滤器
 * @date 2017/5/20
 */
public class LevelRangeFilterTest {

    static {
        System.setProperty("log4j.configurationFile", "filter/log4j2_levelRangeFilter.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        LevelRangeFilterTest levelRangeFilterTest = new LevelRangeFilterTest();
        levelRangeFilterTest.printLog();
    }

    private void printLog() {
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
        logger.fatal("fatal log");
    }

}
