package me.apache.logging.log4j.lookups;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.lookup.MainMapLookup;

/**
 * @author Kevin
 * @description
 * @date 2017/5/20
 */
public class MainArgumentsLooklupTest {

    static{
        System.setProperty("log4j.configurationFile","lookup/log4j2_mainArgsLookup.xml");
    }
    private Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        // set args
        MainMapLookup.setMainArguments(args);
        MainArgumentsLooklupTest mainArgumentsLooklupTest = new MainArgumentsLooklupTest();
        mainArgumentsLooklupTest.printLog();
    }

    private void printLog() {
        logger.trace("This is trace message");
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
        logger.fatal("This is fatal message");
    }
}
