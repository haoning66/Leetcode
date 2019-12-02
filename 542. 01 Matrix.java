import javafx.util.Pair;

import java.util.*;


class Solution {
    final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m;
    int n;

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        m = matrix.length;
        n = matrix[0].length;
        int[][] result = new int[m][n];
        for (int[] res : result)
            Arrays.fill(res, Integer.MAX_VALUE);

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new Pair<>(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            int x = cur.getKey();
            int y = cur.getValue();

            for (int[] dir : dirs) {
                int new_x = x + dir[0];
                int new_y = y + dir[1];
                if (new_x >= 0 && new_x < m && new_y >= 0 && new_y < n) {
                    if (result[new_x][new_y] > result[x][y] + 1) {
                        result[new_x][new_y] = result[x][y] + 1;
                        queue.offer(new Pair<>(new_x, new_y));  //this is for some element is surrounded with all non 0 elements
                    }   //so that no element can reach it from just 0s
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        s.updateMatrix(matrix);
    }
}
