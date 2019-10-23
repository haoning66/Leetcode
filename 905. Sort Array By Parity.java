import java.util.*;

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int i = 0;
        int j = A.length - 1;
        for (int a : A) {
            if(a % 2 == 0){
                res[i] = a;
                i++;
            }
            else{
                res[j] = a;
                j--;
            }
        }
        return res;
    }
}