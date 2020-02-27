import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] ress = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ress[i] = i;
            }
            return ress;
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indeg = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int[] prer : prerequisites) {
            if (!adj.containsKey(prer[0])) {
                adj.put(prer[0], new ArrayList<>());
            }
            adj.get(prer[0]).add(prer[1]);
            indeg[prer[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            for (int x : adj.keySet()) {
                if (adj.get(x).contains(cur)) {
                    indeg[x]--;
                    if (indeg[x] == 0)
                        queue.offer(x);
                }
            }
        }
        if (res.size() == numCourses) {
            int[] ress = new int[res.size()];
            for (int i = 0; i < res.size(); i++)
                ress[i] = res.get(i);
            return ress;
        }
        else
            return new int[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
