package org.fanlychie.common;

import java.util.HashMap;
import java.util.Map;

import static com.dianping.cat.Cat.Context;

/**
 * Created by fanlychie on 2018/7/28.
 */
public class CatContext implements Context {

    private Map<String, String> map = new HashMap<>();

    @Override
    public void addProperty(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String getProperty(String key) {
        return map.get(key);
    }

}