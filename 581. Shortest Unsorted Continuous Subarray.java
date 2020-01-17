import java.util.*;

class Solution {
//    public int findUnsortedSubarray(int[] nums) {  O(nlogn), time complexity for sorting is O(nlogn)
//        if (nums.length == 0 || nums.length == 1)
//            return 0;
//        int[] temp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            temp[i] = nums[i];
//        }
//        Arrays.sort(temp);
//
//        int i = 0;
//        int j = nums.length - 1;
//        while (i < nums.length && nums[i] == temp[i])
//            i++;
//
//        if (i == nums.length)
//            return 0;
//        while (j >= 0 && nums[j] == temp[j])
//            j--;
//
//        return  j - i + 1;
//    }


    //brilliant solution with stack, push elements to stack from the front, if we meet element<stack.peek, pop all the elements
    //that is bigger than current element, the minimum index is the start index of the unsorted array
    //then push elements from the end, if we meet element > stack.peek then pop all the element that is smaller than it
    //the maximum index of these elements is the end of the unsorted array
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int start = nums.length-1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()])
                start = Math.min(start, stack.pop());
            stack.add(i);
        }
        if (stack.size() == nums.length)
            return 0;
        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()])
                end = Math.max(end, stack.pop());
            stack.add(i);
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 8, 4, 12, 2};
        int[] temp = nums;
        Arrays.sort(temp);
        for (int num: nums) {
            System.out.println(num);
        }

    }
}
