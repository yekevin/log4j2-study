package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * ThresholdFilter 日志级别的过滤器
 * 根据配置的日志等级过滤日志
 * @date 2017/5/20
 */
public class ThresholdFilterTest {

    static {
        System.setProperty("log4j.configurationFile", "filter/log4j2_thresholdFilter.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        ThresholdFilterTest thresholdFilterTest = new ThresholdFilterTest();
        thresholdFilterTest.printLog();
    }

    private void printLog() {
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
