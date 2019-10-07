import java.util.Stack;

class Solution {
    private int index;

    public int evalRPN(String[] tokens) {
        index = tokens.length - 1;
        return helper(tokens);
    }

    private int helper(String[] tokens) {
        String cur = tokens[index--];
        int op1, op2;
        switch (cur) {
            case "+":
                op1 = helper(tokens);
                op2 = helper(tokens);
                return op2 + op1;
            case "-":
                op1 = helper(tokens);
                op2 = helper(tokens);
                return op2 - op1;
            case "/":
                op1 = helper(tokens);
                op2 = helper(tokens);
                return op2 / op1;
            case "*":
                op1 = helper(tokens);
                op2 = helper(tokens);
                return op2 * op1;
            default:
                return Integer.valueOf(cur);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] tokens = {"/", "+", "3", "5", "2"};
//        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(s.evalRPN(tokens));
    }

}