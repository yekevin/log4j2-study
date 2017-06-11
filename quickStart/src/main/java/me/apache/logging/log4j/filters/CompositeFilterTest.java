package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.*;

/**
 * @author Kevin
 * @description
 * CompisiteFilter:组合过滤器
 * @date 2017/5/19
 */
public class CompositeFilterTest {

    static{
        System.setProperty("log4j.configurationFile","filter/log4j2_compositeFilter.xml");
    }

    private Logger logger = LogManager.getLogger();

    // MarkerFilter中指定的marker标记
    private static final Marker EVENT_MARKER = MarkerManager.getMarker("EVENT");
    private static final Marker OTHER_MARKER = MarkerManager.getMarker("OTHER");

    public static void main(String[] args) {
        CompositeFilterTest compositeFilterTest = new CompositeFilterTest();
        compositeFilterTest.printLog();
    }

    public void printLog(){
        logger.debug("This log will not print.");
        logger.debug(EVENT_MARKER,"This log will filters by event marker");
        logger.debug(OTHER_MARKER,"This log will not print.");

        ThreadContext.put("name","Kevin");
        logger.debug(OTHER_MARKER,"This log wiil filters by dynamicThresholdFilter");
        ThreadContext.clearMap();

        ThreadContext.put("name","Chris");
        logger.debug(OTHER_MARKER,"This log wiil not print.");
        logger.error(OTHER_MARKER,"This log wiil use defult log level.");
        ThreadContext.clearMap();

        logger.error("This log wiil use defult log level.");
    }
}
