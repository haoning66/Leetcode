import java.util.*;


class Solution {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int n;
    private int m;

    public int maximumMinimumPath(int[][] a) {
        n = a.length;
        m = a[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[2] - x[2]);
        boolean[][] visited = new boolean[n][m];
        pq.offer(new int[]{0, 0, a[0][0]});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curx = cur[0];
            int cury = cur[1];
            int curval = cur[2];

            if (curx == n - 1 && cury == m - 1) {
                System.out.println("x "+curx+"y "+cury);
                return curval;
            }

            for (int[] dir : dirs) {
                int x = curx + dir[0];
                int y = cury + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    pq.offer(new int[]{x, y, Math.min(curval,a[x][y])});
                    visited[x][y] = true;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{1,1,0,3,1,1},{0,1,0,1,1,0},{3,3,1,3,1,1},{0,3,2,2,0,0},{1,0,1,2,3,0}};
        System.out.println(s.maximumMinimumPath(a));

    }

}


