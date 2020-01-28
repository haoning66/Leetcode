import java.util.*;

class Solution {
    public int findMin(int[] nums) {  //dont know why, only use this kind of binary search can pass
        int left = 0;
        int right = nums.length - 1;

        while (right > left) {
            int mid = (left + right) / 2;
            if (nums[left] > nums[mid])
                right = mid;
            else if (nums[mid] > nums[right])
                left = mid + 1;
            else
                return nums[left];
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
