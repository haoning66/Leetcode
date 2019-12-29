class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] row = new boolean[m][n];
        boolean[][] column = new boolean[m][n];
        boolean[][] box = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int c = board[i][j] - '1';
                    int k = 3 * (i / 3) + j / 3;        //k is used to make each row of the array box to indicate which number is used in this "box"
                    if (row[i][c] || column[j][c] || box[k][c])
                        return false;
                    row[i][c] = true;
                    column[j][c] = true;
                    box[k][c] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('9'-'1');
    }
}
