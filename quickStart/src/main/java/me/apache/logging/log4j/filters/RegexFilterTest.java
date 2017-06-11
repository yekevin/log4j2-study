package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;

/**
 * @author Kevin
 * @description
 * 正则表达式过滤
 * @date 2017/5/20
 */
public class RegexFilterTest {

    static {
        System.setProperty("log4j.configurationFile", "filter/log4j2_regexFilter.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        RegexFilterTest regexFilterTest = new RegexFilterTest();
        regexFilterTest.printLog();
    }

    private void printLog() {
        Message message = new SimpleMessage("Hello World!");
        logger.debug(message);

        message = new SimpleMessage("Hello TEST!");
        logger.debug(message);

        // 过滤规则 .* test .*
        message = new SimpleMessage("Hello ... test ...!");
        logger.debug(message);
    }
}
