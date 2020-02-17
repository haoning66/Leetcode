import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0)
            return "0";
        String[] nums_s = new String[nums.length];
        for (int i = 0; i < nums_s.length; i++) {
            nums_s[i] = nums[i] + "";
        }


        Arrays.sort(nums_s, (o1, o2) -> {

//            return new BigInteger(o2 + o1).subtract(new BigInteger(o1 + o2)).intValue();
            return (o2 + o1).compareTo(o1 + o2);
            //lets see o2-o1, will return + if o2>o1, it is the same with compareTo, o2.compareTo(o1)
            //will return + if o2 > o1 in ascii order, which is also numeric order
        });

        if (nums_s[0].equals("0"))
            return "0";

        String res = "";
        for (String s : nums_s)
            res += s;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
