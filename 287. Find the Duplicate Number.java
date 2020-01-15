import java.util.*;

class Solution {

    public int findDuplicate(int[] nums) {  //slow fast pointer solution, refer to leetcode 142
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);    //now slow == fast, but this doesnt have to be the elemnt that is duplicate
                                  //so we have to reset slow to the start of array and keep going
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.findDuplicate(new int[]{1,4,6,6,6,2,3}));
    }
}
