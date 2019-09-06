import java.util.*;

public class Solution {
    private int m;
    private int n;
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return false;}
        boolean result = false;
        if (word.length() == 1) {
            if (!helper(board, word).isEmpty()) return true;
            else return false;
        }


        m = board.length;
        n = board[0].length;

        List<int[]> starts = helper(board, word);

        word = word.substring(1);

        for (int i = 0; i < starts.size(); i++) {
            boolean[][] visited = new boolean[m][n];

            if (dfs_search(board, starts.get(i), word, visited) == true) result = true;

        }


        return result;
    }


    private boolean not_border(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) return true;
        else return false;
    }

    private List<int[]> helper(char[][] board, String word) {
        char start = word.charAt(0);
        List<int[]> result = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == start) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private boolean dfs_search(char[][] board, int[] start, String word, boolean[][] visited) {

        System.out.println();
        if (visited[start[0]][start[1]]) {
            return false;
        }

        if (word.length() == 0) {
            return true;
        }

        visited[start[0]][start[1]] = true;

        for (int[] dir : directions) {
            int x = start[0];
            int y = start[1];
            while (not_border(x + dir[0], y + dir[1])&&word.charAt(0)==board[x + dir[0]][y + dir[1]]) {

                int x_s=x+dir[0];
                int y_s=y+dir[1];

                String word_s=word.substring(1);
                if(dfs_search(board,new int[]{x_s,y_s},word_s,visited)) return true;

                break;
            }
        }
        visited[start[0]][start[1]]=false;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'}};
        String word = "ABCESEEEFS";

//        System.out.println(s.exist(board,word));
        System.out.println(s.exist(board, word));
//        System.out.println(s.not_border(2,3));
    }
}
