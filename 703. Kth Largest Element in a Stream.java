import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    class KthLargest {
        private PriorityQueue<Integer> pq;
        private int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for(int num:nums) {
                pq.offer(num);
            }
        }

        public int add(int val) {
            pq.offer(val);
            while(pq.size()>k)
                pq.poll();

            return pq.peek();
        }
    }
}