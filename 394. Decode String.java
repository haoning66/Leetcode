import java.util.*;

class Solution {
    public String decodeString(String s) {
        String result = "";
        Stack<String> stack = new Stack<>();
        String temp = "";
        String time = "";
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(time);
                time = "";
                stack.push(String.valueOf(c));
            } else if (Character.isDigit(c)) {
                if (!temp.equals("")) {
                    stack.push(temp);
                    temp = "";
                }
                time += c;
            } else if (Character.isLetter(c))
                temp += c;
            else if (c == ']') {
                if (!temp.equals("")) {
                    stack.push(temp);
                    temp = "";
                }
                while (!stack.isEmpty()) {
                    if (stack.peek().equals("[")) {
                        stack.pop();   //pop "["
                        int t = Integer.valueOf(stack.pop());
                        String temp2 = "";
                        while (t > 0) {
                            temp2 += temp;
                            t--;
                        }
                        if (stack.isEmpty()) {
                            result += temp2;
                        }
                        else
                            stack.push(temp2);
                        temp = "";
                        break;    //one "]" can only pop one "["
                    } else {
                        temp = stack.pop() + temp;
                    }
                }

            }
        }

        String res = "";

        while(!stack.isEmpty())     //there may still be elements remained in the stack
            res = stack.pop() + res;

        result = result + res;

        if (!temp.equals(""))
            result += temp;

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "2[abc]xyc3[z]";
        System.out.println(s.decodeString(str));
    }
}
