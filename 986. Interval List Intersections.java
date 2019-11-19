import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length) {
            int left = Math.max(A[i][0], B[j][0]);
            int right = Math.min(A[i][1], B[j][1]);
            if (left <= right)
                result.add(new int[]{left, right});

            if (A[i][1] < B[j][1])     //because the interval with lager end point may still be able to hold new interval
                i++;
            else if (A[i][1] > B[j][1])
                j++;
            else {
                i++;
                j++;
            }
        }
        int[][] result_arr = new int[result.size()][2];
        result.toArray(result_arr);
        return result_arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
