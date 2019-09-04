import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return Collections.EMPTY_LIST;
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] str_c = str.toCharArray();
            Arrays.sort(str_c);
            String str_s = new String(str_c);
            if (!result.containsKey(str_s)) {
                result.put(str_s,new ArrayList<>());
            }
            result.get(str_s).add(str);

        }
        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(s.groupAnagrams(str));
//        System.out.println(s.helper("eat","bte"));
    }
}
