import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    //doesnt work
//    final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//    int m;
//    int n;
//
//    public void solve(char[][] board) {
//
//        if (board.length == 0 || board[0].length == 0)
//            return;
//        m = board.length;
//        n = board[0].length;
//        boolean[][] visited = new boolean[m][n];
//        for (int i = 1; i < m - 1; i++) {
//            for (int j = 1; j < n - 1; j++) {
//                if (board[i][j] == 'O'&& !visited[i][j]) {
//                    helper(board, new boolean[m][n], i, j);
//                    visited[i][j] = true;
//                }
//            }
//        }
//    }
//
//    private boolean helper(char[][] board, boolean[][] visited, int i, int j) {
//        visited[i][j] = true;
//        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
//            return true;
//        }
//        for (int[] dir : dirs) {
//            int new_i = i + dir[0];
//            int new_j = j + dir[1];
//            if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && board[new_i][new_j] == 'O' && !visited[new_i][new_j] && helper(board, visited, new_i, new_j)) {
//                return true;
//            }
//        }
//        board[i][j] = 'X';
//        return false;
//    }

    //instead of find a border 'O' for each 'O', we try to find the 'O's that count on this border 'O'
    final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m;
    int n;

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '*';
                helper(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = '*';
                helper(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '*';
                helper(board, 0, j);
            }

            if (board[m - 1][j] == 'O') {
                board[m - 1][j] = '*';
                helper(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '*')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void helper(char[][] board, int i, int j) {
        for (int[] dir : dirs) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && board[new_i][new_j] == 'O') {
                board[new_i][new_j] = '*';
                helper(board, new_i, new_j);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        s.solve(board);
    }
}
