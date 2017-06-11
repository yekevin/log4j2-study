package me.apache.logging.log4j.layouts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * RFC5424Layout syslog增强
 * @date 2017/5/24
 */
public class RFC5424LayoutTest {
    static {
        System.setProperty("log4j.configurationFile", "layout/log4j2_rfc5424Layout.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        RFC5424LayoutTest rfc5424LayoutTest = new RFC5424LayoutTest();
        rfc5424LayoutTest.printLog();
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
