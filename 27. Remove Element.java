import javafx.util.Pair;

import java.util.*;


class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;

        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == val){
                i++;
            }
            if (i < nums.length)     //only when the last element == val i can be out of boundary, in this case n wont increase so n wont
                nums[n++] = nums[i];   //be out of boundary
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeElement(new int[]{3,2,2,3},3));
    }

}
