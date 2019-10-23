import java.util.*;

class Solution {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        int N = grid.length;

        if (grid[0][0] != 0 || grid[N - 1][N - 1] != 0)
            return -1;

        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int res = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

//                if (visited[x][y])
//                    continue;
//                visited[x][y] = true;    //if determine visited or not here, it will become much slower,because yo already enter the next iteration

                if (x == N - 1 && y == N - 1)
                    return res;

                for (int j = 0; j < dirs.length; j++) {

                    int nx = x + dirs[j][0];
                    int ny = y + dirs[j][1];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] == 0 && !visited[nx][ny]) { //instead, put it here
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}