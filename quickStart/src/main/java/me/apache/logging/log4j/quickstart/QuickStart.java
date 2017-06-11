package me.apache.logging.log4j.quickstart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description logj42配置加载机制
 * 顺序查找配置文件
 * 1.log4j.configurationFile log4j检查system property中指定的配置文件路径
 * 2.第1步未找着，在classpath下找log4j2-test.properties
 * 3.第2步未找着，在classpath下找log4j2-test.yaml or log4j2-test.yml
 * 4.第3步未找着，在classpath下找log4j2-test.json or log4j2-test.jsn
 * 5.第4步未找着，在classpath下找log4j2-test.xml
 * 6.第5步未找着，在classpath下找log4j2.properties
 * 7.第6步未找着，在classpath下找log4j2.yaml or log4j2.yml
 * 8.第7步未找着，在classpath下找log4j2.json or log4j2.jsn
 * 9.第8步未找着，在classpath下找log4j2.xml
 * 10.第9步未找着，则默认使用DefaultConfiguration(默认配置输出为console,日志级别为ERROR)
 * @date 2017/5/15
 * @see org.apache.logging.log4j.core.config.DefaultConfiguration
 */
public class QuickStart {
    private static final Logger logger = LogManager.getLogger(QuickStart.class.getName());

    public static void main(String... args) {
        logger.trace("Got calculated value only if trace enabled: {}", doSomeCalculation());
        logger.info("Got calculated value only if info enabled: {}", doSomeCalculation());
        logger.debug("Got calculated value only if debug enabled: {}", doSomeCalculation());
        logger.warn("Got calculated value only if warn enabled: {}", doSomeCalculation());
        logger.error("Got calculated value only if error enabled: {}", doSomeCalculation());
    }

    private static String doSomeCalculation() {
        // do some complicated calculation
        return "do something caculation";
    }
}
