package me.apache.logging.log4j.lookups;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * 取环境变量参数替换log4j配置
 * 配置方式：$${env:ENV_KEY}
 * @date 2017/5/20
 */
public class EnvironmentLooklupTest {

    static{
        System.setProperty("log4j.configurationFile","lookup/log4j2_environmentLookup.xml");
    }
    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        EnvironmentLooklupTest environmentLooklupTest = new EnvironmentLooklupTest();
        environmentLooklupTest.printLog();
    }

    private void printLog() {
        logger.trace("This is trace message");
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
        logger.fatal("This is fatal message");
    }
}
