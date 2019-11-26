import java.util.*;

//class Solution {
//
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//
//    }
//}

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n < 1)
            return -1;

        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i))    //there will be no situation that a celebrity appears after the cur candidate,
                candidate = i;          //because if so, candidate must know that guy
        }                               //no one before candidate is celebrity because they know some one, no one after the
                                        //the candidate can be celebrity because candidate doesnt know them
                                        //now we just have to check if people before candidate know candidate/ candidate doesnt
                                        //know anyone before him and people after candidate all know him because we already know
                                        //candidate doesnt know any of them

        for (int i = 0; i < n; i++) {
            if (i == candidate)
                continue;
            if (!knows(i, candidate) || knows(candidate, i))
                return -1;
        }
        return candidate;
    }
}