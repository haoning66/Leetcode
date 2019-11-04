import java.util.*;


class Solution {
    //    public int firstUniqChar(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (s.indexOf(c) == s.lastIndexOf(c))
//                return i;
//        }
//        return -1;
//    }
    public int firstUniqChar(String s) {          //this actually becomes slower, because of two loops
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(int i=0;i<n;i++){
            if(map.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "leetcode";
        System.out.println(s.firstUniqChar(ss));
    }

}


