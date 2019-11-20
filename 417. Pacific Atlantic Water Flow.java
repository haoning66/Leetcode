import java.util.*;

class Solution {
    private int m;
    private int n;
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return result;

        m = matrix.length;
        n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, i, 0, Integer.MIN_VALUE);
            dfs(matrix, atlantic, i, n - 1, Integer.MIN_VALUE);
        }

        for (int j = 0; j < n; j++) {
            dfs(matrix, pacific, 0, j, Integer.MIN_VALUE);
            dfs(matrix, atlantic, m - 1, j, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int x, int y, int pre) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < pre)
            return;  //because only if current value is bigger than previous value water can flow from previous point to current point
        visited[x][y] = true;
        for (int[] dir : dirs)
            dfs(matrix, visited, x + dir[0], y + dir[1], matrix[x][y]);
    }
}

