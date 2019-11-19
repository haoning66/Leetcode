import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] rem = new int[60];
        int total = 0;
        for (int song : time) {
            rem[song % 60]++;
        }

        total += rem[0] * (rem[0] - 1) / 2 + rem[30] * (rem[30] - 1) / 2;
        /*
        * songs with remainder 0 and 30 should be counted individually, because every two elements from this
        * two can satisfy the requirement, here is how this equation comes from, let say rem[0]=5, then there are
        * 1,2,3,4,5 their number of combinations are 4,3,2,1,0 and the sum is (4+0)*5/2 which is (ret-1)*ret/2
        *
        * */

        for(int i=1;i<30;i++){
            total += rem[i]*rem[60-i];
        }
        return total;
    }
}
