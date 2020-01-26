import javafx.util.Pair;

import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int res = 0;
        while (i < j) {
            int sum = people[i] + people[j];
            if (sum > limit) {
                j--;
                res++;
            }
            else {
                res++;
                i++;
                j--;
            }
        }
        if (i == j)
            res++;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
