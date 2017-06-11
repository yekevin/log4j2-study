package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 * @author Kevin
 * @description DynamicThresholdFilter：动态日志级别过滤器
 * 将指定的Key/Value 设置到ThreadContext map的方式
 * 使用KeyValuePair配置多组，只要值对应到map中的value就可以使用设置的日志级别
 * 否则使用默认的日志级别
 * @date 2017/5/19
 */
public class DynamicThresholdFilterTest {

    static {
        System.setProperty("log4j.configurationFile", "filter/log4j2_dynamicThresholdFilter.xml");
    }

    private Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        DynamicThresholdFilterTest dynamicThresholdFilterTest = new DynamicThresholdFilterTest();
        dynamicThresholdFilterTest.printLog();
    }

    private void printLog() {
        // 默认日志级别为ERROR，这边只能答应出ERROR级别日志
        logger.debug("Debug Message Without Set ThreadContextMap");
        logger.info("Info Message Without Set ThreadContextMap");
        logger.warn("Warn Message Without Set ThreadContextMap");
        logger.error("Error Message Without Set ThreadContextMap");

        // Chris匹配上了配置中KeyValuePair，日志级别设置为INFO
        ThreadContext.put("name", "Chris");
        logger.debug("Debug Message With key name value Chris");
        logger.info("Info Message With key name value Chris");
        logger.warn("Warn Message With key name value Chris");
        logger.error("Error Message With key name value Chris");
        ThreadContext.clearMap();

        // Kevin匹配上了配置中KeyValuePair，日志级别设置为DEBUG
        ThreadContext.put("name", "Kevin");
        logger.debug("Debug Message With key name value Kevin");
        logger.info("Info Message With key name value Kevin");
        logger.warn("Warn Message With key name value Kevin");
        logger.error("Error Message With key name value Kevin");
        ThreadContext.clearMap();
    }
}
