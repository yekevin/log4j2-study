package me.apache.logging.log4j.lookups;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * 日期替换
 * 日期格式：SimpleDateFormat
 * 表达方式：$${date:yyyy-MM-dd}
 * @date 2017/5/20
 */
public class DateLooklupTest {

    static{
        System.setProperty("log4j.configurationFile","lookup/log4j2_dateLookup.xml");
    }
    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        DateLooklupTest dateLooklupTest = new DateLooklupTest();
        dateLooklupTest.printLog();
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
