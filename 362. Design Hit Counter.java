import java.util.*;

//class HitCounter {
//    private Map<Integer, Integer> map;
//    /** Initialize your data structure here. */
//    public HitCounter() {
//        map = new HashMap<>();
//    }
//
//    /** Record a hit.
//     @param timestamp - The current timestamp (in seconds granularity). */
//    public void hit(int timestamp) {
//        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
//    }
//
//    /** Return the number of hits in the past 5 minutes.
//     @param timestamp - The current timestamp (in seconds granularity). */
//    public int getHits(int timestamp) {
//        int count = 0;
//        int i = timestamp;
//        while (i > timestamp - 300 && i > 0) {
//            count += map.getOrDefault(i, 0);
//            i--;
//        }
//        return count;
//    }


//}

class HitCounter {                      //faster solution with queue
    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int past = timestamp - 300;     //this is the time 300 seconds earlier than timestamp
        while (!queue.isEmpty() && queue.peek() <= past)       //if there exists timestamp that is smaller than past, poll it
            queue.poll();                                  //which means it is added before 300 seconds ago
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

