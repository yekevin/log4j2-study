package me.apache.logging.log4j.appenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 * @author Kevin
 * @description 日志等级映射策略
 * @date 2017/5/29
 */
public class LoggerNameLevelRewritePolicyAppenderTest {
    static{
        System.setProperty("log4j.configurationFile","appender/log4j2_loggerNameLevelRewritePolicyAppender.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        LoggerNameLevelRewritePolicyAppenderTest loggerNameLevelRewritePolicyAppenderTest = new LoggerNameLevelRewritePolicyAppenderTest();
        loggerNameLevelRewritePolicyAppenderTest.printLog();
    }

    private void printLog() {
        logger.trace("trace log...");
        logger.debug("debug log...");
        logger.info("info log...");
        logger.warn("warn log...");
        logger.error("error log...");
    }
}
