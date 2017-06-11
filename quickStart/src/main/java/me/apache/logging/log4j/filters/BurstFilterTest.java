package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * BurstFilter：防止爆炸式的日志输出的过滤器
 * level:日志等级过滤
 * rate:控制每秒处理的速率
 * maxBurst:类似于队列最大积压
 * @date 2017/5/19
 */
public class BurstFilterTest {

    static{
        System.setProperty("log4j.configurationFile","filter/log4j2_burstFilter.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws InterruptedException {
        BurstFilterTest burstFilterTest = new BurstFilterTest();
        burstFilterTest.printLog();
    }

    private void printLog() throws InterruptedException {
        // 配置文件配置的rate为16，maxBurst为100
        // 这里发送200条日志，正常情况只处理100条
        for (int i = 0; i < 200; i++) {
            logger.info("print info log " + i);
        }

        Thread.sleep(10000);

        // 这里又可以处理100条
        for (int i = 0; i < 200; i++) {
            logger.info("print info log " + i);
        }
    }
}
