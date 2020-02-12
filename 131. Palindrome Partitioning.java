import java.util.*;

class Solution {
    //dfs + backtracking
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0)
            return result;
        helper(s, new ArrayList<>(), result);
        return result;
    }

    private void helper(String cur, List<String> cur_list, List<List<String>> result) {
        if (cur.length() == 0) {
            result.add(new ArrayList<>(cur_list));
            return;
        }
        for (int i = 1; i <= cur.length(); i++) {
            String sub = cur.substring(0, i);
            if (isPalind(sub)) {
                cur_list.add(sub);
                helper(cur.substring(i,cur.length()), cur_list, result);
                cur_list.remove(cur_list.size() - 1);
            }
        }
    }

    private boolean isPalind(String s) {
        if (s.length() == 1)
            return true;
        int i = 0;
        int j = s.length() - 1;
        while (j > i && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (j > i)
            return false;
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.partition("aabb");
    }
}
