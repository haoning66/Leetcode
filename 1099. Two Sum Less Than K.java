class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int max = -1;
        int i = 0;
        int j = A.length - 1;
        Arrays.sort(A);
        while (i < j) {
            int sum = A[i] + A[j];
            if(sum >= K)
                j--;
            else{
                max = Math.max(sum,max);
                i++;
            }
        }
        return max;
    }
}