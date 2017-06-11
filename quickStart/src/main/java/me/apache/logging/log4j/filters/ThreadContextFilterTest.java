package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 * @author Kevin
 * @description
 * ThreadContextFilter 基于线程上下文内容过滤
 * 实现是基于ThreadContextMap(ThreadLocal) 设置当前线程的K/V
 * 基于配置文件配置好的K/V进行匹配
 * @date 2017/5/20
 */
public class ThreadContextFilterTest {

    static {
        System.setProperty("log4j.configurationFile", "filter/log4j2_threadContextFilter.xml");
    }
    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        ThreadContextFilterTest threadContextTest = new ThreadContextFilterTest();
        threadContextTest.printLog();
    }

    private void printLog() {
        ThreadContext.put("name", "Kevin");
        ThreadContext.put("age", "28");
        logger.debug("Message 1");

        ThreadContext.remove("age");
        logger.debug("Message 2");
        ThreadContext.clearMap();

        logger.debug("Message 3");
    }
}
