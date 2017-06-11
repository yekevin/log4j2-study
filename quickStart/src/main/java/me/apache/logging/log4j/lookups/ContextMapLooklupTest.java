package me.apache.logging.log4j.lookups;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

/**
 * @author Kevin
 * @description
 * ContextMapLooklup 线程上线文方式替换log4j配置
 * 只需在ThreadContext中设置指定的K/V
 * 配置方式
 * 方式一：$${ctx:key}
 * 方式二：%X{key}
 * @date 2017/5/20
 */
public class ContextMapLooklupTest {

    static{
        System.setProperty("log4j.configurationFile","lookup/log4j2_contextMapLookup.xml");
    }
    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        ContextMapLooklupTest contextMapLooklupTest = new ContextMapLooklupTest();
        contextMapLooklupTest.printLog();
    }

    private void printLog() {
        ThreadContext.put("traceId", UUID.randomUUID().toString());
        logger.trace("This is trace message");
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
        logger.fatal("This is fatal message");
        ThreadContext.clearMap();
    }
}
