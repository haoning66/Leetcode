import java.util.*;

class Solution {
//    public int singleNonDuplicate(int[] nums) {   //my intuitive solution, slow
//        int i = 0;
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        while (i < nums.length) {
//            if (i == 0 && nums[i] != nums[i + 1])
//                return nums[i];
//            else if (i == nums.length - 1 && nums[i] != nums[i-1])
//                return nums[i];
//            else if (nums[i] < nums[i + 1] && nums[i] != nums[i - 1]) {
//                return nums[i];
//            }
//            i++;
//        }
//        return 0;
//    }

//    public int singleNonDuplicate(int[] nums) {  brilliant solution with 2 step for i
//        int i = 0;
//
//        while (i < nums.length - 1) {
//            if (nums[i] == nums[i + 1])
//                i += 2;
//            else break;
//        }
//
//        return nums[i];
//    }

    public int singleNonDuplicate(int[] nums) {    //binary search solution
        if (nums.length == 1)
            return nums[0];

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 && nums[mid] != nums[mid + 1]) || (mid == nums.length - 1 && nums[mid] != nums[mid - 1] ))
                return nums[mid];

            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];
            else if (nums[mid] == nums[mid - 1]) {    //if nums[mid] = nums[mid-1] and mid is even then the single element
                if (mid % 2 == 0) {                  //must appear before nums[mid] because if not mid should be odd
                    right = mid;
                }
                else {                         //if mid is odd then single element must appear after nums[mid], search the other half
                    left = mid + 1;
                }
            }
            else if (nums[mid] == nums[mid + 1]) { //if nums[mid] = nums[mid+1] and mid is even then single element must appear after num[mid]
                if (mid % 2 == 0) {
                    left = mid + 1;  //if mid is odd then single element appear before nums[mid]
                }
                else {
                    right = mid;
                }
            }
        }
        return nums[left];   //because left = mid + 1, so it can be larger than right and the loop will break, single element is the last element 
    }



    public static void main(String[] args) {
        Solution s = new Solution();


    }
}
