import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        List<Integer> res = new ArrayList<>();
        int j = 0;
        int anchor = 0;

        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                res.add(j - anchor + 1);
                anchor = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "\tfile";
        System.out.println(input.length());

    }
}