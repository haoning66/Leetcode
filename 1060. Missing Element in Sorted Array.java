import java.util.*;

class Solution {
//    public int missingElement(int[] nums, int k) {  brute force solution, slow as fuck
//        int len = nums.length;
//        int[] complete = new int[nums[len - 1] + 1];
//        int j = 0;
//        int num = nums[0];
//        for (int i = 0; i < complete.length; i++) {
//            complete[i] = num++;
//        }
//        for (int i = 0; i < complete.length; i++) {
//            if (complete[i] > nums[len - 1])
//                return nums[len - 1] + k;
//            if (nums[j] != complete[i]) {
//                k--;
//            } else
//                j++;
//
//            if (k == 0)
//                return complete[i];
//        }
//        return 0;
//    }
public int missingElement(int[] nums, int k) {     //binary search can search anything
    if (k > missing(nums.length - 1, nums))
        return nums[nums.length - 1] + k - missing(nums.length - 1, nums);
    //the elements missing in nums is not enough

    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (k > missing(mid, nums))
            left = mid + 1;

        else if (k < missing(mid, nums))
            right = mid;
        else
            break;
    }
    return k - missing(left - 1, nums) + nums[left - 1]; //after nums[left-1] there are k - missing(left - 1, nums) element still need to miss
                                                               //so nums[left-1] plus this amount is the element
}    //how many element missing before nums[index]
    private int missing(int index, int[] nums) {
        return nums[index] - nums[0] - index;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 4};
        System.out.println(s.missingElement(nums, 3));

    }
}