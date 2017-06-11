package me.apache.logging.log4j.appenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description MemoryMappedFileAppender 内存映射文件appender,IO性能处理优秀
 * @date 2017/5/29
 */
public class MemoryMappedFileAppenderTest {
    static{
        System.setProperty("log4j.configurationFile","appender/log4j2_memoryMappedFileAppender.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        MemoryMappedFileAppenderTest memoryMappedFileAppenderTest = new MemoryMappedFileAppenderTest();
        memoryMappedFileAppenderTest.printLog();
    }

    private void printLog() {
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
