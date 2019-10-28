import java.util.*;

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] truster = new int[N];
        int[] trustee = new int[N];
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            truster[a] += 1;
            trustee[b] += 1;
        }

        for (int i = 1; i < N; i++) {
            if (truster[i] == 0 && trustee[i] == N - 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}