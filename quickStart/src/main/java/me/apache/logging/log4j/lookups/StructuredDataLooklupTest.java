package me.apache.logging.log4j.lookups;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.message.StructuredDataMessage;

/**
 * @author Kevin
 * @description
 * StructuredData 默认有id，id.name，type的KEY
 * StructuredData 继承了MapMessage 可以额外添加key
 * 配置方式${sd:key}
 * @date 2017/5/20
 */
public class StructuredDataLooklupTest {

    static{
        System.setProperty("log4j.configurationFile","lookup/log4j2_structuredDataLookup.xml");
    }

    public static void main(String[] args) {
        StructuredDataLooklupTest structuredDataLooklupTest = new StructuredDataLooklupTest();
        structuredDataLooklupTest.printLog();
    }

    private void printLog() {
        StructuredDataMessage msg = new StructuredDataMessage("10086", "money transfer user to user", "transfer");
        msg.with("key","val");
        EventLogger.logEvent(msg);
        EventLogger.logEvent(msg);
        EventLogger.logEvent(msg);
        EventLogger.logEvent(msg);
        EventLogger.logEvent(msg);
    }
}
