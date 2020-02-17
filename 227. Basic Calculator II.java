import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public int calculate(String s) {
        if (s.length() == 0)
            return 0;
        int num = 0;
        int res = 0;
        char op = '+';   //to store its previous operator
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            //when c is the last character, there will be no operator after it to push it into the stack
            if (i == s.length() - 1 || !Character.isDigit(c) && c != ' ') {
                if (op == '+')
                    stack.push(num);
                else if (op == '-')
                    stack.push(-num);
                else if (op == '*')
                    stack.push(stack.pop() * num);
                else
                    stack.push(stack.pop() / num);

                num = 0;
                op = c;
            }
        }

        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
