import javafx.util.Pair;

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";
        Map<Character, Integer> t_map = new HashMap<>();
        for (char c : t.toCharArray()) {
            t_map.put(c, t_map.getOrDefault(c, 0) + 1);
        }
        int need = t_map.size();
        int left = 0;
        int right = 0;
        int min_length = Integer.MAX_VALUE;
        int begin = 0;
        int end = 0;
        int has = 0;

        List<Pair<Integer, Character>> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (t_map.containsKey(c))
                list.add(new Pair<Integer, Character>(i, c));
        }
        Map<Character, Integer> s_map = new HashMap<>();
        while (right < list.size()) {
            char c = list.get(right).getValue();
            s_map.put(c, s_map.getOrDefault(c, 0) + 1);

            if (t_map.get(c).intValue() == s_map.get(c).intValue())
                has++;

            while (left <= right && has == need) {
                c = list.get(left).getValue();
                if (min_length > list.get(right).getKey() - list.get(left).getKey() + 1) {
                    min_length = list.get(right).getKey() - list.get(left).getKey() + 1;
                    begin = list.get(left).getKey();
                    end = list.get(right).getKey();
                }
                s_map.put(c, s_map.getOrDefault(c, 0) - 1);
                if (t_map.get(c).intValue() > s_map.get(c).intValue())
                    has--;
                left++;
            }
            right++;
        }
        return min_length == Integer.MAX_VALUE ? "" : s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ABBCZBAC","ABC"));
    }
}
