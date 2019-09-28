import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Solution {
//    final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//    int m;
//    int n;
//
//    public int numIslands(char[][] grid) {
//
//        if(grid.length==0)
//            return 0;
//        m = grid.length;
//        n = grid[0].length;
//        boolean[][] visited = new boolean[m][n];
//        int result=0;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == '1' && visited[i][j] != true) {
//                    BFS_FindIsland(grid,new int[]{i,j},visited);
//                    result += 1;
//                }
//            }
//        }
//        return result;
//    }
//
//    private void BFS_FindIsland(char[][] grid, int[] current, boolean[][] visited) {
//        if (visited[current[0]][current[1]])
//            return;
//
//        visited[current[0]][current[1]] = true;
//
//        for (int[] dir : directions) {
//            int x = current[0];
//            int y = current[1];
//
//            while (not_Wall(x + dir[0], y + dir[1]) && grid[x + dir[0]][y + dir[1]] != '0') {
//                x += dir[0];
//                y += dir[1];
//                BFS_FindIsland(grid,new int[]{x,y},visited);
//            }
//        }
//    }
//
//    private boolean not_Wall(int x, int y) {
//        return (x >= 0 && x < m && y >= 0 && y < n);
//    }

    public int numIslands(char[][] grid) {

        if (grid.length == 0)
            return 0;
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result += 1;
                    BFS_FindIsland(grid, i, j);

                }
            }
        }
        return result;
    }

    private void BFS_FindIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        BFS_FindIsland(grid, i - 1, j);
        BFS_FindIsland(grid, i + 1, j);
        BFS_FindIsland(grid, i, j - 1);
        BFS_FindIsland(grid, i, j + 1);

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(s.numIslands(grid));
    }
}


