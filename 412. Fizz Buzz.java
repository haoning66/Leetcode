import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1)
            return res;

        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                res.add("FizzBuzz");
            else if (i % 3 == 0)
                res.add("Fizz");
            else if (i % 5 == 0)
                res.add("Buzz");
            else
                res.add(i + "");
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
