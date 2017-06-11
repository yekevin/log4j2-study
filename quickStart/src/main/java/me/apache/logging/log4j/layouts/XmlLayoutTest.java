package me.apache.logging.log4j.layouts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * JsonLayout：仅对当前参数进行输出至Xml文件
 * @date 2017/5/24
 */
public class XmlLayoutTest {
    static {
        System.setProperty("log4j.configurationFile", "layout/log4j2_xmlLayout.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        XmlLayoutTest jsonLayoutTest = new XmlLayoutTest();
        jsonLayoutTest.printLog();
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
