package me.apache.logging.log4j.appenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.message.MapMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @description RewriteAppender 允许对LogEvent进行操作，修改，后然再传递给后续appender处理
 * @date 2017/5/29
 */
public class PropertiesRewritePolicyAppenderTest {
    static{
        System.setProperty("log4j.configurationFile","appender/log4j2_propertiesRewritePolicyAppender.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        PropertiesRewritePolicyAppenderTest propertiesRewritePolicyAppenderTest = new PropertiesRewritePolicyAppenderTest();
        propertiesRewritePolicyAppenderTest.printLog();
    }

    private void printLog() {
        ThreadContext.put("product","myProduct");

        logger.trace("trace log...");
        logger.debug("debug log...");
        logger.info("info log...");
        logger.warn("warn log...");
        logger.error("error log...");
    }
}
