import java.util.*;


class Solution {

    public int search(int[] nums, int target) {
        //  List<Integer> list = new ArrayList<Integer>(Arrays.asList(nums));    this will not work because primitive types cannot be applied to generic method
        int left = 0;
        int right = nums.length - 1;    //here right has to be nums.length - 1 because latter it is used as nums[right]
                                                     //  ||
        while (right >= left) {  //so here it has to have "=", or when nums =[1] the initial value of left=0 right=0 it will not enter the loop
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[left] <= nums[mid]) {  //the "=" here is not about there is duplicate elements or not, is about mid can be the same with left
                if (target >= nums[left] && target <= nums[mid])
                    right = mid;   //here right=mid and right =mid-1 doesnt matter
                else left = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(s.search(nums, 3));
    }

}


