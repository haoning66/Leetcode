import java.util.*;


class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum;
        int remain;
        while (set.add(n)) {  //if there is duplicate element, add will return false
            sum = 0;
            while (n > 0) {
                remain = n % 10;
                sum = sum + remain * remain;
                n /= 10;
            }

            if(sum==1)
                return true;
            else
                n = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(12);
        System.out.println(set.add(12));

    }
}


