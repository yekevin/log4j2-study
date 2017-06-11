package me.apache.logging.log4j.lookups;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * 配置系统属性
 * System.setProperty("logPath","target");
 * 配置文件使用
 * ${sys:key}
 * @date 2017/5/20
 */
public class SystemPropertiesLooklupTest {
    static{
        System.setProperty("log4j.configurationFile","lookup/log4j2_systemPropertiesLookup.xml");
        System.setProperty("logPath","target");
    }
    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        SystemPropertiesLooklupTest systemPropertiesLooklupTest = new SystemPropertiesLooklupTest();
        systemPropertiesLooklupTest.printLog();
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
