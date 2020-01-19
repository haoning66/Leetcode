import java.util.*;

class Solution {
//    public List<Integer> findAnagrams(String s, String p) {    slow, slow, slow
//        List<Integer> res = new ArrayList<>();
//        if (s.length() == 0 || p.length() == 0)
//            return res;
//        int p_len = p.length();
//        char[] s_arr = s.toCharArray();
//        char[] p_arr = p.toCharArray();
//        char[] s_arr_copy = new char[p_len];
//        Arrays.sort(p_arr);
//        p = new String(p_arr);
//        System.out.println(p);
//        for (int i = 0; i < s_arr.length - p_len + 1; i++) {
//            if (p.indexOf(s_arr[i]) != -1) {
//                s_arr_copy = Arrays.copyOfRange(s_arr, i, i + p_len);
//                Arrays.sort(s_arr_copy);
//                String ss = new String(s_arr_copy);
//                if (p.equals(ss))
//                    res.add(i);
//            }
//        }
//        return res;
//    }

    //great sliding window solution, the idea of sliding window is when window length exceeded, remove the previous element and add new element to keep window length

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        char[] ap = p.toCharArray();
        char[] as = s.toCharArray();
        char[] hp = new char[26];
        char[] hs = new char[26];

        for (char c : ap)
            hp[c - 'a']++;

        for (int i = 0; i < as.length; i++) {
            hs[as[i] - 'a']++;
            if (i > ap.length - 1)    //window overflow, remove previous element
                hs[as[i - ap.length] - 'a']--;
            if (Arrays.equals(hs, hp))     //to see if the elements in these two are the same
                res.add(i - ap.length + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAnagrams("cbaebabacd","bca"));
    }
}
