import java.util.*;

class HashNode {
    int key;
    int value;
    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private final int CAPACITY = 1000;
    private List<List<HashNode>> map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new ArrayList<>();
        for (int i = 0; i < CAPACITY; i++)
            map.add(new ArrayList<HashNode>());
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket_num = key % CAPACITY;
        List<HashNode> bucket = map.get(bucket_num);
        for (HashNode hashnode: bucket) {
            if (hashnode.key == key) {
                hashnode.value = value;
                return;
            }
        }
        bucket.add(new HashNode(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket_num = key % CAPACITY;
        List<HashNode> bucket = map.get(bucket_num);
        for (HashNode hashnode: bucket) {
            if (hashnode.key == key)
                return hashnode.value;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int bucket_num = key % CAPACITY;
        List<HashNode> bucket = map.get(bucket_num);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == key)
                bucket.remove(i);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */