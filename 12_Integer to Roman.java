class Solution {

    public String intToRoman(int num) {

        String[] SI = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] TE = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] HU = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] TH = {"", "M", "MM", "MMM"};

        int th = num/1000;
        int hu = (num%1000)/100;
        int te = (num%100)/10;
        int si = num%10;

        return TH[th]+HU[hu]+TE[te]+SI[si];

//        int num_length = num_string.length();
//        int digits = num_length;
//
//        while (digits >= 1) {
//            String digit_str = num_string.charAt(num_length - digits) + "";
//            int digit_int = Integer.parseInt(digit_str);
//            if (digit_int == 0){
//                digits--;
//                continue;
//            }
//            if (digits == 1) {
//                result += arr_1[digit_int - 1];
//            } else if (digits == 2) {
//                result += arr_2[digit_int - 1];
//            } else if (digits == 3) {
//                result += arr_3[digit_int - 1];
//            } else if (digits == 4) {
//                result += arr_4[digit_int - 1];
//            }
//
//            digits--;
//        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(58));

    }
}

