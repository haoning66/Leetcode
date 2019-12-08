import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i + 1] <= nums[i])   //find the element that is smaller than its previous element in reverse order
            i--;                                   //eg: 158476531, the element is 4

        if (i >= 0) {                              //there may be two cases, we cannot find such element then i = -1, we can find such element then i = its index
            int j = nums.length - 1;              //if we can find such i, we try to find a j that is bigger than nums[i] but is the smallest in reverse order
            while (j >= 0 && nums[j] <= nums[i])  //because all the element on the right of nums[i] is in descending order(otherwise there i will not be this value)
                j--;                              //we can just start from the right and find the first element that is bigger than nums[i]
            swap(nums, i, j);                     //we swap nums[i] and nums[j], and also we have to arrange all the element on the right of nums[i] in ascending order
        }                                         //so that this permutation can be the smallest
        swapAll(nums, i + 1);                //remember that there is a case we cannot find a suitable i and i=-1 in this case, swapAll will swap all the elements in nums
    }                                             //so that all elements are in ascending order as the problem requires

    private void swapAll(int[] nums, int start) {
        int j = nums.length - 1;
        int i = start;
        while (j > i) {
            swap(nums, i, j);
            j--;
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
