import java.util.*;

public class Solution {
    //The idea is to build the tree with smaller elements, for a element in the array, use it and the smaller one from its left and
    //right to construct the tree. Like merge stone problem.
    public int mctFromLeafValues(int[] arr) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);

        for (int a : arr) {           //here, the tree will be constructed if a bigger element come. when construct the tree
                                       //with two elements, the bigger element will remain in the stack for future calculation.
            while (stack.peek() <= a) {
                int small = stack.pop();
                result += small * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }

        while (stack.size() > 2) {   //here, tree will also be constructed util only one element remain in the stack
            result += stack.pop() * stack.peek();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}


