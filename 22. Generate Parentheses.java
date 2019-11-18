import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {   //Absolutely brilliant solution
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            result.add(cur);
            return;
        }

        if (open < max)
            backtrack(result, cur+"(", open + 1, close, max);

        if (close < open)       //when the last level of recursion finished, there are some level of recursion in the calling stack
            backtrack(result, cur+")", open, close + 1, max);// that are not finished with this, so cur will keep being filled
                                                                       //and added to result

    }
}
