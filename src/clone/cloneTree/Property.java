package clone.cloneTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuyc
 * @version 0.0.1
 * @date 2019/3/19
 */
public class Property {

    Map<String,String> property = new HashMap<>();

    public Map<String, String> getProperty() {
        return property;
    }

    public void setProperty(Map<String, String> property) {
        this.property = property;
    }
}