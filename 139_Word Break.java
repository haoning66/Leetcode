import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "leetcode";
        List word = new ArrayList();
        word.add("leet");
        word.add("code");
        System.out.println(s.wordBreak(ss,word));


    }
}


