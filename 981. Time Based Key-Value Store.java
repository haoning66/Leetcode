import java.util.*;

class Solution {
    public static void main(String[] args) {
    }
}

class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";

        TreeMap<Integer, String> treemap = map.get(key);
        Integer t = treemap.floorKey(timestamp);

        return t == null ? "" : treemap.get(t);
    }
}