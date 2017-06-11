package me.apache.logging.log4j.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

/**
 * @author Kevin
 * @description log4j2提供给日志加tag标签
 * 目前有两种方式，map和stack
 * 配合layout配置来显示
 * @date 2017/5/18
 */
public class ThreadContextTest {
    private Logger logger = LogManager.getLogger();

    static {
        System.setProperty("log4j.configurationFile", "api/log4j2_threadContext.xml");
    }

    public static void main(String[] args) {

        ThreadContextTest threadContextTest = new ThreadContextTest();
        threadContextTest.threadContextStack();
        threadContextTest.threadContextMap();
        threadContextTest.threadContextMapKey();
    }

    // stack方式
    private void threadContextStack() {
        ThreadContext.push(UUID.randomUUID().toString()); // Add the fishtag;
        ThreadContext.push(UUID.randomUUID().toString()); // Add the fishtag;
        logger.debug("Message 1");

        ThreadContext.pop();
        logger.debug("Message 2");
        ThreadContext.clearStack();

        logger.debug("Message 3");
    }

    // map 指定key方式
    private void threadContextMapKey() {
        ThreadContext.put("name", "Kevin");
        ThreadContext.put("age", "28");
        logger.debug("Message 1");

        ThreadContext.remove("age");
        logger.debug("Message 2");

        ThreadContext.clearMap();
        logger.debug("Message 3");
    }

    // map方式
    private void threadContextMap() {
        // traceId 已在配置layout中指定了key
        ThreadContext.put("traceId", UUID.randomUUID().toString());
        logger.debug("Message 1");

        ThreadContext.clearMap();
        logger.debug("Message 2");
    }
}
