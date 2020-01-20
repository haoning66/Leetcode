import java.util.*;

class Solution {
//    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {  O(n4) with memorization, still TLE
//        if (A.length == 0)
//            return 0;
//        Arrays.sort(A);
//        Arrays.sort(B);
//        Arrays.sort(C);
//        Arrays.sort(D);
//        int res = 0;
//        int cb = 0;
//        int cc = 0;
//        int cd = 0;
//
//        for (int i = 0; i < A.length; i++) {
//            if (i > 0 && A[i] == A[i - 1]) {
//                res += cb;
//                continue;
//            }
//            else
//                cb = 0;
//            for (int j = 0; j < B.length; j++) {
//                if (j > 0 && B[j] == B[j - 1]) {
//                    res += cc;
//                    cb += cc;
//                    continue;
//                }
//                else
//                    cc = 0;
//                for (int m = 0; m < C.length; m++) {
//                    if (m > 0 && C[m] == C[m - 1]) {
//                        res += cd;
//                        cc += cd;
//                        cb += cd;
//                        continue;
//                    }
//                    else
//                        cd = 0;
//                    for (int n = 0; n < D.length; n++) {
//                        if (A[i] + B[j] + C[m] + D[n] == 0) {
//                            res++;
//                            cd++;
//                            cc++;
//                            cb++;
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }

    //brilliant hashmap solution, convert to 2sum
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (map.containsKey(-1*(C[i] + D[j])))
                    res += map.get(-1*(C[i] + D[j]));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
