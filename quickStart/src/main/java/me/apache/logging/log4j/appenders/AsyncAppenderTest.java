package me.apache.logging.log4j.appenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description AsyncAppender 开启一个异步守护线程，将日志事件写入到引用的appenders
 * @date 2017/5/29
 */
public class AsyncAppenderTest {
    static{
        System.setProperty("log4j.configurationFile","appender/log4j2_asyncAppender.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        AsyncAppenderTest asyncAppenderTest = new AsyncAppenderTest();
        asyncAppenderTest.printLog();
    }

    private void printLog() {
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
