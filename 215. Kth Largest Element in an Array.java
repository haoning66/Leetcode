import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int num : nums)
//            pq.offer(num);
//        while (k > 1) {
//            pq.poll();
//            k--;
//        }

//        int n = nums.length;    //this is the fastest, you cannot do Arrays.sort(nums, (o1,o1)-> o2-o1); because int array cannot be genericalized
//        Arrays.sort(nums);
//        return nums[n - k];

        for (int num : nums) {    //because when size >k the smallest one will be polled, bigger ones are left at pq
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        Solution s = new Solution();
        System.out.println(s.findKthLargest(nums, 2));

    }
}

