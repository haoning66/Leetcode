import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>(); //reverse order because we should use task with larger amount, if use all the task with smaller amount then we can only add more idle in the future
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (char task : tasks)
            map.put(task, map.getOrDefault(task, 0) + 1);
        for (char task : map.keySet())
            pq.offer(map.get(task));

        int time = 0;
        List<Integer> list;

        while (!pq.isEmpty()) {
            list = new ArrayList<>();
            int i = 0;
            while (i <= n) {
                if (!pq.isEmpty()) {    //because when pq is empty but temp is not, which means the loop has to go on to add
                    if (pq.peek() > 1)  //idle into the schedule
                        list.add(pq.poll() - 1);
                    else
                        pq.poll();
                }
                time++;
                i++;
                if (pq.isEmpty() && list.size() == 0)     //when they are both empty, means the all the task is finished
                    break;                                //no need to add idle in the end of the schedule, even though i <= n
            }
            for (int l : list)
                pq.offer(l);
        }
        return time;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
