package me.apache.logging.log4j.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Kevin
 * @description
 * 流程追踪
 * @date 2017/5/16
 */
public class TestService {

    private Logger logger = LogManager.getLogger();

    private String[] messages = new String[]{
            "Hello,World",
            "Goodbye Cruel World",
            "You had me at hello"
    };

    private Random rand = new Random(1);

    public String retrieveMessage() {
        logger.traceEntry();
        String testMsg = getMessage(getKey());
        return logger.traceExit(testMsg);
    }

    public void exampleException() {
        logger.traceEntry();
        try {
            String msg = messages[messages.length];
            logger.error("An exception should have been thrown");
        } catch (Exception ex) {
            logger.catching(ex);
        }
        logger.traceExit();
    }

    public String getMessage(int key) {
        logger.entry(key);
        String value = messages[key];
        return logger.traceExit(value);
    }

    private int getKey() {
        logger.traceEntry();
        int key = rand.nextInt(messages.length);
        return logger.traceExit(key);
    }

    public static class JsonMessage{
        private String[] messages;

        public JsonMessage(String[] messages) {
            this.messages = messages;
        }

        @Override
        public String toString() {
            return "JsonMessage{" +
                    "messages=" + Arrays.toString(messages) +
                    '}';
        }
    }
}
