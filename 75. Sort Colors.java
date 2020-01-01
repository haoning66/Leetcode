import java.util.*;

class Solution {
//    public void sortColors(int[] nums) {   //solution with counting, fast but two-pass
//        int red = 0;
//        int white = 0;
//        int blue = 0;
//        for (int num : nums) {
//            if (num == 0)
//                red++;
//            else if (num == 1)
//                white++;
//            else blue++;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (red != 0) {
//                nums[i] = 0;
//                red--;
//                continue;
//            }
//
//            if (white != 0) {
//                nums[i] = 1;
//                white--;
//                continue;
//            }
//
//            if (blue != 0) {
//                nums[i] = 2;
//                blue--;
//            }
//        }
//    }

    public void sortColors(int[] nums) {  //brilliant one-pass solution
        int left = -1;    //where 0 is supposed to be
        int i = 0;        //where 1 is supposed to be
        int right = nums.length;   //where right is supposed to be

        while (i < right) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 0) {   //when 0 occurs, swap 0 to the front
                left++;
                swap(nums, i, left);
                i++;
            }

            else if (nums[i] == 2) {   //when 2 occurs, swap 2 to the end
                right--;
                swap(nums, i, right);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }




    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
