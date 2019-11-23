import java.util.*;

class Solution {
//    public int canCompleteCircuit(int[] gas, int[] cost) {    //brute force solution, slow as fuck
//        for (int i = 0; i < gas.length; i++) {
//            if (gas[i] >= cost[i]) {
//                int cur = 0;
//                for (int j = i; j < i + gas.length; j++) {
//                    int x = j >= gas.length ? j - gas.length : j;
//                    cur = cur + gas[x] - cost[x];
//                    System.out.println("cur"+cur+"i"+i+"x"+x);
//                    if (cur < 0) break;
//
//                    if (cur >= 0 && (x + 1 == i || x + 1 == gas.length&&i==0))
//                        return i;
//                }
//            }
//        }
//        return -1;
//    }
public int canCompleteCircuit(int[] gas, int[] cost) {
    int cur_tank = 0;
    int total_tank = 0;
    int start = 0;
    for (int i = 0; i < gas.length; i++) {
        cur_tank = cur_tank + gas[i] - cost[i];
        total_tank = total_tank + gas[i] - cost[i];
        if (cur_tank < 0) {
            cur_tank = 0;
            start = i + 1;
        }
    }
    return total_tank >= 0 ? start : -1;
}
/* if total_tank >= 0 means there must exist a point, start from this point you can travel without cur_tank < 0
* the thing is to find this point, the point is the point in start, from this point to the last point cur_tank must
* be >= 0, if not, start with be the next point, and when you turn around start from the first point to the start point
* even if for each point cost is bigger than gas, which leads to consume the gas instead of compensate it will not use
* all the gas, because total_tank is >= 0,then it can make it to the start point
* */


    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5,5,70};
        int[] cost = {2,3,4,3,9,6,2};
//        for (int i = 3; i <= 3 + gas.length; i++) {
//            int j = i >= gas.length ? i - gas.length : i;
//            System.out.println(gas[j]);
//        }
        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}

