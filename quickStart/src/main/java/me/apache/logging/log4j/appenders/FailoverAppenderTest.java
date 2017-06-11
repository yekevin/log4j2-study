package me.apache.logging.log4j.appenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description FailoverAppender：故障转移Appender
 * 由一个primary Appender和一个failovers appender集合组成
 * 当primary appender失败，failovers appender集合按顺序尝试直到一个成功或没有可用的appender为止
 * @date 2017/5/29
 */
public class FailoverAppenderTest {
    static{
        System.setProperty("log4j.configurationFile","appender/log4j2_failoverAppender.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        FailoverAppenderTest failoverAppenderTest = new FailoverAppenderTest();
        failoverAppenderTest.printLog();
    }

    private void printLog() {
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
