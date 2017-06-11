package me.apache.logging.log4j.layouts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ObjectArrayMessage;

/**
 * @author Kevin
 * @description
 * HtmlLayout：对当前输出日志以HTML格式输出
 * @date 2017/5/24
 */
public class HtmlLayoutTest {
    static {
        System.setProperty("log4j.configurationFile", "layout/log4j2_htmlLayout.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        HtmlLayoutTest htmlLayoutTest = new HtmlLayoutTest();
        htmlLayoutTest.printLog();
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
