package me.apache.logging.log4j.api;

/**
 * @author Kevin
 * @description
 * @date 2017/5/16
 */
public class FlowTraceTest {

    static{
        System.setProperty("log4j.configurationFile", "api/log4j2_flowTrace.xml");
    }

    public static void main(String[] args) {
        TestService testService = new TestService();
        testService.retrieveMessage();
        testService.retrieveMessage();
        testService.exampleException();
    }
}
