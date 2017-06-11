package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * TimeFilter:基于时间范围的过滤器，指定开始，结束时间（ HH:mm:ss），仅记录指定范围的日志
 * @date 2017/5/20
 */
public class TimeFilterTest {
    static {
        System.setProperty("log4j.configurationFile", "filter/log4j2_timeFilter.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        TimeFilterTest timeFilterTest = new TimeFilterTest();
        timeFilterTest.printLog();
    }

    private void printLog() {
        logger.debug("print a log 1");
        logger.debug("print a log 2");
        logger.debug("print a log 3");
    }
}
