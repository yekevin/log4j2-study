package me.apache.logging.log4j.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @description
 * @date 2017/5/17
 */
public class MessageTest {

    private Logger logger = LogManager.getLogger();

    static {
        System.setProperty("log4j.configurationFile", "api/log4j2_message.xml");
    }

    private static final Marker MSG_MARKER = MarkerManager.getMarker("MESSAGE");

    public static void main(String[] args) {
        MessageTest messageTest = new MessageTest();
        messageTest.printLog();
    }
    private void printLog() {
        User user = new User();
        user.setId("1000000");
        user.setName("Kevin");
        user.setAge(28);

        // Use ParameterizedMessage
        Message formattedMessage = new FormattedMessage("This user name {},age {}", user.getName(), user.getAge());
        logger.debug(MSG_MARKER, formattedMessage);

        // Use MessageFormatMessage
        formattedMessage = new FormattedMessage("This user name {0},age {1}", user.getName(), user.getAge());
        logger.debug(MSG_MARKER, formattedMessage);

        // TODO Use StringFormattedMessage with Pattern

        // Use MapMessage
        Map<String, String> map = new HashMap<>();
        map.put("name", "Kevin");
        map.put("age", "28");
        MapMessage mapMessage = new MapMessage(map);
        logger.debug(MSG_MARKER, mapMessage.asString());
        logger.debug(MSG_MARKER, mapMessage.asString("json"));

        StringBuilder sb = new StringBuilder();
        mapMessage.asXml(sb);
        logger.debug(MSG_MARKER, sb.toString());

        logger.debug(MSG_MARKER,mapMessage);

        // Use ObjectArrayMessage
        ObjectArrayMessage objectArrayMessage = new ObjectArrayMessage(new Object[]{"Hello", "World"});
        logger.debug(MSG_MARKER, objectArrayMessage);
    }

    public static class User {
        private String id;
        private String name;
        private Integer age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
