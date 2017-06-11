package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.EventLogger;
import org.apache.logging.log4j.message.StructuredDataMessage;

/**
 * @author Kevin
 * @description
 * StructuredDataFilter 是MapFilter的扩展
 * 不但支持map方式的匹配还增加了id,id.name,type,message的匹配
 * 在配置文件中配置key为id和type项即可
 * @date 2017/5/20
 */
public class StructuredDataFilterTest {

    static {
        System.setProperty("log4j.configurationFile", "filter/log4j2_structuredDataFilter.xml");
    }

    public static void main(String[] args) {
        StructuredDataFilterTest structuredDataFilterTest = new StructuredDataFilterTest();
        structuredDataFilterTest.printLog();
    }

    private void printLog() {
        // 配置文件定义了三个键值对
        // fromAccount:6225654321   id:10086    type:transfer
        // operator为or，匹配任意一个即可打印日志，否则过滤，默认为and匹配全部
        StructuredDataMessage msg = new StructuredDataMessage("10086", "money transfer user to user", "remain");
        EventLogger.logEvent(msg);

        msg = new StructuredDataMessage("10010", "money transfer user to user", "transfer");
        EventLogger.logEvent(msg);

        msg = new StructuredDataMessage("10010", "money transfer user to user", "remain");
        // equals msg.put...
        msg.with("fromAccount", "6225654321");
        EventLogger.logEvent(msg);

        msg = new StructuredDataMessage("10010", "GOOD", "remain");
        msg.with("fromAccount", "0000000000");
        EventLogger.logEvent(msg);
    }
}
