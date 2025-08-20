package binarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeMap {

    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> values = map.getOrDefault(key, new TreeMap<>());
        values.put(timestamp, value);
        map.put(key, values);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> values = map.get(key);
        Integer index = values.floorKey(timestamp);
        if (index != null) {
            return values.get(index);
        } else {
            return "";
        }
    }
}
