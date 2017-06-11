package me.apache.logging.log4j.layouts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ObjectArrayMessage;

/**
 * @author Kevin
 * @description
 * CsvParameterLayout：仅对当前参数进行输出至CSV文件
 * CsvLogEventLayout：不仅对当前参数，还将日志相关明细也输出至CSV
 * @date 2017/5/24
 */
public class CsvLayoutTest {
    static {
        System.setProperty("log4j.configurationFile", "layout/log4j2_csvLayout.xml");
    }

    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        CsvLayoutTest csvLayoutTest = new CsvLayoutTest();
        csvLayoutTest.printLog();
    }

    private void printLog() {
        logger.debug("Ignored", "val1", "val2", "val3");
        logger.info("Ignored", "val4", "val5", "val6");
        logger.warn("Ignored", "val7", "val8", "val9");

        logger.debug(new ObjectArrayMessage("val1", "val2", "val3"));
        logger.info(new ObjectArrayMessage("val4", "val5", "val6"));
        logger.warn(new ObjectArrayMessage("val7", "val8", "val9"));

        logger.debug("one={},two={},three={}", "val1", "val2", "val3");
        logger.info("one={},two={},three={}", "val4", "val5", "val6");
        logger.warn("one={},two={},three={}", "val7", "val8", "val9");
    }
}
