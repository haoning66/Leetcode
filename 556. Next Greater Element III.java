import java.util.*;

class Solution {
    public int nextGreaterElement(int n) {     //according to leetcode 31
        String s = n+"";
        char[] nums = s.toCharArray();
        if (nums.length == 0 || nums.length == -1)
            return -1;

        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i])
            i--;

        if (i < 0)
            return -1;

        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i])
            j--;

        swap(nums, i, j);
        swapAll(nums, i + 1);
        s = new String(nums);
        long res = Long.parseLong(s);
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? -1 : (int)res;
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void swapAll(char[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (j > i) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nextGreaterElement(12));

    }
}
