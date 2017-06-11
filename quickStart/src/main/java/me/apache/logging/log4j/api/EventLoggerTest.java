package me.apache.logging.log4j.api;

import org.apache.logging.log4j.EventLogger;
import org.apache.logging.log4j.message.StructuredDataMessage;

import java.util.UUID;

/**
 * @author Kevin
 * @description
 * EventLogger使用OFF等级日志作为默认值用以表示它不能被过滤
 * @date 2017/5/16
 */
public class EventLoggerTest {

    static{
        System.setProperty("log4j.configurationFile", "api/log4j2_eventLogger.xml");
    }

    public static void main(String[] args) {
        String confirm = UUID.randomUUID().toString().substring(0,32);
        StructuredDataMessage msg = new StructuredDataMessage(confirm, "money transfer user to user", "transfer");
        msg.put("toAccount", "6228123456");
        msg.put("fromAccount", "6225654321");
        msg.put("amount", "100000.00");
        EventLogger.logEvent(msg);
    }
}
