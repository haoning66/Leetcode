import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        int[] min = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(nums[i], min[i - 1]);

        for (int j = nums.length - 1; j >= 0; j--) {
            if(nums[j]>min[j]){
                while(!stack.isEmpty()&&stack.peek()<=min[j])
                    stack.pop();
                if(!stack.isEmpty()&&stack.peek()<nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public static void main(String[] args) {


    }
}