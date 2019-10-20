import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            int index1 = s1.indexOf(' ');
            int index2 = s2.indexOf(' ');
            String sub1 = s1.substring(index1+1);
            String sub2 = s2.substring(index2+1);

            if (sub1.charAt(0) <= '9') {
                if (sub2.charAt(0) <= '9')
                    return 0;
                else return 1;
            } else {
                if (sub2.charAt(0) <= '9')
                    return -1;

                int cmp = sub1.compareTo(sub2);
                if (cmp != 0)
                    return cmp;
                else return s1.substring(0,index1).compareTo(s2.substring(0,index2));
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "abcd";
        String s2 = "dbcd";
        System.out.println(s1.compareTo(s2));

    }
}