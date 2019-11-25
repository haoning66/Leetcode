import java.util.*;

class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = m; i < m + n; i++) {
//            nums1[i] = nums2[i - m];
//        }
//        Arrays.sort(nums1);
//    }
    //  excellent two pointers solution, rewrite nums1 from the end, so that the information in nums will not be eliminated


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ( p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums2[p2] >= nums1[p1]? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        //to copy nums2 to nums1 in the front is because it may happen that elements are ran out in nums1, break the loop
        // so there are still elements in nums2 to be added
        //or m=0, the loop doesnt even start
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        s.merge(nums1, 3, nums2, 3);


    }
}