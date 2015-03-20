package relaxtime.lib.model;

import java.util.Map;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public interface MongoFilter<T> {
    Map<String, Object> getCriteria();
}
