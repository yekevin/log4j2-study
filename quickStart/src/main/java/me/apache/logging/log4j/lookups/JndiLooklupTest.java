package me.apache.logging.log4j.lookups;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Kevin
 * @description
 * JNDI方式替换log4j配置
 * @date 2017/5/20
 */
public class JndiLooklupTest {

    static{
        System.setProperty("log4j.configurationFile","lookup/log4j2_jndiLookup.xml");
    }
    private Logger logger = LogManager.getLogger();
}
