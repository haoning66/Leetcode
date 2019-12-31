import java.util.*;

class Solution {
//    int result = Integer.MAX_VALUE;     intuitive dfs solution, TLE because of the last big testcase
//    int m;
//    int n;
//    public int minPathSum(int[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0)
//            return 0;
//        m = grid.length;
//        n = grid[0].length;
//        dfs(0, 0, grid[0][0], grid);
//        return result;
//    }
//
//    private void dfs(int x, int y, int sum, int[][] grid) {
//        if (x == m - 1 && y == n - 1) {
//            result = Math.min(result, sum);
//        }
//
//        if (x + 1 <= m - 1 && sum + grid[x + 1][y] < result)
//            dfs(x + 1, y, sum + grid[x + 1][y], grid);
//
//        if (y + 1 <= n - 1 && sum + grid[x][y + 1] < result)
//            dfs(x, y + 1, sum + grid[x][y + 1], grid);
//    }

    public int minPathSum(int[][] grid) {   //classic dp solution
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int j = 1; j < dp.length; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
