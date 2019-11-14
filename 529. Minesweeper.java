import java.util.*;

class Solution {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        int count = 0;

        if (board[i][j] == 'E') {
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length && board[ni][nj] == 'M')
                    count++;
            }

            board[i][j] = count == 0 ? 'B' : (char) (count + 48);

            if (count == 0) {
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length)
                        dfs(board, ni, nj);
                }
            }
        }else if(board[i][j] == 'M')
            board[i][j] = 'X';

    }

    public static void main(String[] args) {
        int i=5;
        char a = (char)(i+48);
        System.out.println(a);
    }
}


