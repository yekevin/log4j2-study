package me.apache.logging.log4j.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.ContextDataInjector;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.core.impl.ContextDataInjectorFactory;
import org.apache.logging.log4j.core.util.KeyValuePair;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.apache.logging.log4j.util.ReadOnlyStringMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yepl
 * @description log4j2 的动态日志级别扩展filter
 * @date 2017/5/21
 */
@Plugin(name = "DynamicThresholdExtFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE, printObject = true)
@PerformanceSensitive("allocation")
public class DynamicThresholdExtFilter extends AbstractFilter {

    /**
     * Creates a DynamicThresholdFilter.
     *
     * @param key              The name of the key to compare.
     * @param defaultThreshold The default Level.
     * @param onMatch          The action to perform if a match occurs.
     * @param onMismatch       The action to perform if no match occurs.
     * @return The CustomFilter.
     */
    @PluginFactory
    public static DynamicThresholdExtFilter createFilter(
            @PluginAttribute("key") final String key,
            @PluginElement("Pairs") final KeyValuePair[] pairs,
            @PluginAttribute("defaultThreshold") final Level defaultThreshold,
            @PluginAttribute("onMatch") final Result onMatch,
            @PluginAttribute("onMismatch") final Result onMismatch,
            @PluginAttribute("defaulLevelControler") final String levelControllerName) {
        final Level level = defaultThreshold == null ? Level.ERROR : defaultThreshold;
        return new DynamicThresholdExtFilter(key, pairs, level, onMatch, onMismatch, levelControllerName);
    }

    private Level defaultThreshold = Level.ERROR;
    private final String key;
    private final ContextDataInjector injector = ContextDataInjectorFactory.createInjector();
    private LevelController levelController;

    private DynamicThresholdExtFilter(final String key, final KeyValuePair[] pairs, final Level defaultLevel,
                                      final Result onMatch, final Result onMismatch, final String levelControllerName) {
        super(onMatch, onMismatch);
        Objects.requireNonNull(key, "key cannot be null");
        this.key = key;
        this.defaultThreshold = defaultLevel;
        if (levelController == null) {
            Map<String, String> map = new HashMap<String, String>();
            for (final KeyValuePair pair : pairs) {
                map.put(pair.getKey(), pair.getValue());
            }
            this.levelController = new MapLevelController(map);
        } else {
            try {
                this.levelController = (LevelController) Class.forName(levelControllerName).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("实例化LevelController异常，" + e.getMessage());
            }
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equalsImpl(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DynamicThresholdExtFilter other = (DynamicThresholdExtFilter) obj;
        if (defaultThreshold == null) {
            if (other.defaultThreshold != null) {
                return false;
            }
        } else if (!defaultThreshold.equals(other.defaultThreshold)) {
            return false;
        }
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        if (levelController == null) {
            if (other.levelController != null) {
                return false;
            }
        } else if (!levelController.equals(other.levelController)) {
            return false;
        }
        return true;
    }

    private Result filter(final Level level, final ReadOnlyStringMap contextMap) {
        final String value = contextMap.getValue(key);
        if (value != null) {
            String levelKey = levelController.getLevelName(value);
            Level ctxLevel;
            if (levelKey == null) {
                ctxLevel = defaultThreshold;
            } else {
                ctxLevel = Level.getLevel(levelKey);
                if (ctxLevel == null) {
                    ctxLevel = defaultThreshold;
                }
            }
            return level.isMoreSpecificThan(ctxLevel) ? onMatch : onMismatch;
        }
        return Result.NEUTRAL;

    }

    @Override
    public Result filter(final LogEvent event) {
        return filter(event.getLevel(), event.getContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final Message msg,
                         final Throwable t) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final Object msg,
                         final Throwable t) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object... params) {
        return filter(level, currentContextData());
    }

    private ReadOnlyStringMap currentContextData() {
        return injector.rawContextData();
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4, final Object p5) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4, final Object p5, final Object p6) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4, final Object p5, final Object p6,
                         final Object p7) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4, final Object p5, final Object p6,
                         final Object p7, final Object p8) {
        return filter(level, currentContextData());
    }

    @Override
    public Result filter(final org.apache.logging.log4j.core.Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4, final Object p5, final Object p6,
                         final Object p7, final Object p8, final Object p9) {
        return filter(level, currentContextData());
    }

    public String getKey() {
        return this.key;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCodeImpl();
        result = prime * result + ((defaultThreshold == null) ? 0 : defaultThreshold.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((levelController == null) ? 0 : levelController.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("key=").append(key);
        sb.append(", default=").append(defaultThreshold);
        return sb.toString();
    }
}
