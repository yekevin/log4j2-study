package me.apache.logging.log4j.layouts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * SyslogLayout
 * @date 2017/5/24
 */
public class SyslogLayoutTest {
    static {
        System.setProperty("log4j.configurationFile", "layout/log4j2_syslogLayout.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        SyslogLayoutTest syslogLayoutTest = new SyslogLayoutTest();
        syslogLayoutTest.printLog();
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
