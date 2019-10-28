import java.util.*;

class Solution {


    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        
    }
}

class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            if(map.get(val) != list.size()-1){         //we'll always remove the last element of list
                map.put(list.get(list.size()-1),map.get(val));
                list.set(map.get(val),list.get(list.size()-1));
            }
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}