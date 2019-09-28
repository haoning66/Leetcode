import javafx.util.Pair;

import java.util.*;


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> adjMap = new HashMap<>(numCourses);
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int course = prerequisites[i][0];
            if (!adjMap.containsKey(course))
                adjMap.put(course, new ArrayList<>());
            adjMap.get(course).add(pre);
            inDegree[course]++;
        }


        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i]==0)
                queue.offer(i);
        }

        int count=0;
        while(!queue.isEmpty()){
            int pre = queue.poll();
            count++;
            for(int course:adjMap.keySet()){
                if(adjMap.get(course).contains(pre)){
                    inDegree[course]--;
                    if(inDegree[course]==0)
                        queue.offer(course);
                }
            }

        }
        return count==numCourses;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int numCourses = 4;
        int[][] pre = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println(s.canFinish(numCourses, pre));

    }
}


