package me.apache.logging.log4j.filters;

import org.apache.logging.log4j.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @description
 * @date 2017/5/20
 */
public class MarkerFilterTest {

    static {
        System.setProperty("log4j.configurationFile", "filter/log4j2_markerFilter.xml");
    }

    private Logger logger = LogManager.getLogger();
    private static final Marker SQL_MARKER = MarkerManager.getMarker("SQL");
    private static final Marker UPDATE_MARKER = MarkerManager.getMarker("SQL_UPDATE").setParents(SQL_MARKER);
    private static final Marker QUERY_MARKER = MarkerManager.getMarker("SQL_QUERY").setParents(SQL_MARKER);

    public static void main(String[] args) {
        MarkerFilterTest markerTest = new MarkerFilterTest();
        Map<String, String> params = new HashMap<String, String>();
        params.put("key1", "value1");
        params.put("key2", "value2");

        markerTest.doQuery("table", params);
        markerTest.doUpdate("table", params);

        ThreadContext.clearAll();
    }

    public String doQuery(String table, Map<String, String> params) {
        logger.entry(params);
        logger.debug(QUERY_MARKER, "SELECT * FROM {}", table);
        return logger.traceExit("doQuery with return");
    }

    public String doUpdate(String table, Map<String, String> params) {
        logger.entry(params);
        logger.debug(UPDATE_MARKER, "UPDATE {} SET {}", table, formatCols(params));
        return logger.traceExit("doUpdate with return");
    }

    private String formatCols(Map<String, String> cols) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : cols.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        return sb.toString();
    }
}
