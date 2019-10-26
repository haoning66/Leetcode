import java.util.*;

class Solution {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int n;
    private int m;

    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                System.out.println(grid[i][j]);
                if (grid[i][j] == 1)
                    fresh++;
                else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }


        if (fresh == 0)
            return 0;

        if(queue.size()==0)
            return -1;


        int count = 0;


        while (!queue.isEmpty()) {

            int queuesize = queue.size();

            if (fresh == 0){
                return count;
            }

            for (int iter = 0; iter < queuesize; iter++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                System.out.println(x+" "+y);




                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        fresh--;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{0},{2}};
        System.out.println(s.orangesRotting(grid));
    }
}