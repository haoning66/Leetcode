import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    private LRULinkedHashMap<Integer,Integer> LRUMap = new LRULinkedHashMap<>();
    private int capacity;
    private class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V>{
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest){
            if(size()>capacity)
                return true;
            else return false;
        }
    }


    public Solution(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if(LRUMap.containsKey(key)){
            int value = LRUMap.get(key);
            LRUMap.remove(key);
            LRUMap.put(key,value);
            return value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(LRUMap.containsKey(key))
            LRUMap.remove(key);
        LRUMap.put(key,value);
    }


    public static void main(String[] args) {
        Solution s = new Solution(2);
        s.put(1,1);
        s.put(2,2);
        System.out.println(s.get(1));
        s.put(3,3);
        System.out.println(s.get(2));
        s.put(4,4);
        System.out.println(s.get(1));
        System.out.println(s.get(3));
        System.out.println(s.get(4));

    }
}

