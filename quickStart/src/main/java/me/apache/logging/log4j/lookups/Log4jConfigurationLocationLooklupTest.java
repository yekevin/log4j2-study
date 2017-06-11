package me.apache.logging.log4j.lookups;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * 配置方式
 * ${log4j:configLocation} 获取配置文件绝对路径
 * ${log4j:configParentLocation} 获取配置文件父路径
 * @date 2017/5/20
 */
public class Log4jConfigurationLocationLooklupTest {

    static{
        System.setProperty("log4j.configurationFile","lookup/log4j2_log4jConfigurationLocationLookup.xml");
    }
    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Log4jConfigurationLocationLooklupTest bean = new Log4jConfigurationLocationLooklupTest();
        bean.printLog();
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
