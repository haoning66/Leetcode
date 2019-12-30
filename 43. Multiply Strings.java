import java.util.*;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return "";

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int[] result = new int[num1.length() + num2.length() - 1];
        char[] num1_arr = num1.toCharArray();
        char[] num2_arr = num2.toCharArray();
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                if (num1_arr[0] != '0' && num2_arr[j] != '0')
                    result[i + j] += (num1_arr[i] - '0') * (num2_arr[j] - '0');
            }
        }

        for (int i = result.length - 1; i >= 1; i--) {   //this is brilliant, the first element in result doesnt have to
            result[i - 1] += result[i] / 10;          //add something to its previous digit because it can stay what it is
            result[i] = result[i] % 10;               //and added in front of the result.
        }

        StringBuffer sb = new StringBuffer();
        for (int num : result) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println('9'-'0');
    }
}
