import java.util.*;

class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //if not specified, the order is ascending 
        for (int len : sticks) {
            pq.offer(len);
        }

        int sum=0;
        while (pq.size() > 1) {
            int two = pq.poll() + pq.poll();
            sum += two;
            pq.offer(two);
        }
        return sum;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] sticks = {1,8,3,5};
        System.out.println(s.connectSticks(sticks));
    }
}