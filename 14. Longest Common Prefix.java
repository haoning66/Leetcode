import java.util.*;

class Solution {
    //    public String longestCommonPrefix(String[] strs) {   //horizontal scan
//        if (strs.length == 0)
//            return "";
//
//        String prefix = strs[0];
//        String temp;
//        for (int i = 1; i < strs.length; i++) {
//            temp = strs[i];
//            while (temp.indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty())
//                    return "";
//            }
//        }
//        return prefix;
//    }
    public String longestCommonPrefix(String[] strs) {    //vertical scan, speed is pretty much the same
        if (strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"flowers", "flow", "flight"};
//        System.out.println(s.longestCommonPrefix(strs));
        String str = "xx";
        System.out.println(strs[0].indexOf(str));

    }
}
