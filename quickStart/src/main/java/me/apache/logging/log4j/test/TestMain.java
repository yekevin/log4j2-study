package me.apache.logging.log4j.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

/**
 * @author Administrator
 * @description
 * @date 2017/5/22
 */
public class TestMain {

    static{
        System.setProperty("log4j.configurationFile","test/log4j2.xml");
    }
    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.printLog();
    }

    private void printLog() {
        ThreadContext.put("traceId", "ap001");
        logger.trace("This is trace message");
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
        logger.fatal("This is fatal message");
        ThreadContext.clearMap();
    }
}
