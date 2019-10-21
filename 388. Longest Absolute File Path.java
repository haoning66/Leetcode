import java.util.*;

class Solution {
    public int lengthLongestPath(String input) {
        int max=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);   //dummy head, to make initial size of stack 1

        for(String s:input.split("\n")){
            int numoftab = s.lastIndexOf("\t")+1; //number of \t
            int level = numoftab+1;     //the level of the current file or folder, dir will be level 1

            while(level<stack.size())      //to find the size of the parent directory of the current file or folder
                stack.pop();

            int curlen = stack.peek() + s.length() - numoftab +1;
                   //the length of its parent path(include a "/") + the length of itself(include its "\t") - the number of its "\t"(because "\t" is counted as 1 in length) + a "/"
            stack.push(curlen);

            if(s.contains("."))
                max = Math.max(max,curlen-1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "\tfile";
        System.out.println(input.length());

    }
}