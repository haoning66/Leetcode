import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int[] result;
        for(int num: nums1){
            set.add(num);
        }
        int i = 0;
        for(int num: nums2){
            if(set.remove(num))
                nums2[i++] = num;
        }
        return Arrays.copyOfRange(nums2,0,i);
    }
}