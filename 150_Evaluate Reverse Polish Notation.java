import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            System.out.println(s.equals("+"));
            if (s == "+" || s == "-" || s == "/" || s == "*") {
                int top1 = stack.pop();
                int top2 = stack.pop();
                if (s == "+")
                    stack.push(top2 + top1);
                else if (s == "-")
                    stack.push(top2 - top1);
                else if (s == "/")
                    stack.push(top2 / top1);
                else
                    stack.push(top2 * top1);
            }
            else{
                stack.push(Integer.parseInt(s));
            }

        }
        return stack.peek();
    }
    public static void main(String[] args){
        Solution s = new Solution();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(s.evalRPN(tokens));
    }

}