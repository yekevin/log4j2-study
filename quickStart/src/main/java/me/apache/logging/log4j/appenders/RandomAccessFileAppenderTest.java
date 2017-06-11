package me.apache.logging.log4j.appenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description RandomAccessFileAppender
 * @date 2017/5/29
 */
public class RandomAccessFileAppenderTest {
    static{
        System.setProperty("log4j.configurationFile","appender/log4j2_randomAccessFileAppender.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        RandomAccessFileAppenderTest randomAccessFileAppenderTest = new RandomAccessFileAppenderTest();
        randomAccessFileAppenderTest.printLog();
    }

    private void printLog() {
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
