import java.util.*;

class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> student;

        for (int[] item : items) {
            student = map.getOrDefault(item[0], new PriorityQueue<>(Comparator.reverseOrder()));
            student.offer(item[1]);
            map.put(item[0], student);
        }

        int[][] result = new int[map.size()][2];


        for (int i = 1; i < result.length + 1; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += map.get(i).poll();
            }
            result[i - 1] = new int[]{i, sum / 5};
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(11/5);

    }
}