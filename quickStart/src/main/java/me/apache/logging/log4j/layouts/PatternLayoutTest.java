package me.apache.logging.log4j.layouts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * PatternLayout 最常用的格式化输出
 * @date 2017/5/24
 * @see <a href="https://logging.apache.org/log4j/2.x/manual/layouts.html">Log4j2 Layouts</a>
 */
public class PatternLayoutTest {
    static {
        System.setProperty("log4j.configurationFile", "layout/log4j2_patternLayout.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        PatternLayoutTest patternLayoutTest = new PatternLayoutTest();
        patternLayoutTest.printLog();
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
