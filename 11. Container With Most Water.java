import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (right > left) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right])
                left++;
            else
                right--;
                                             //Always move the shorter side, because the area depends on
                                             //the shorter side, moving the longer side will not increase
                                             //the area at all
        }
        return max;
    }
}