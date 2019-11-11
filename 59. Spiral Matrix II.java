import java.util.*;

class Solution {
    public int[][] generateMatrix(int n) {
        int row_begin = 0;
        int row_end = n - 1;
        int col_begin = 0;
        int col_end = n - 1;
        int[][] result = new int[n][n];
        int value = 1;

        while (value <= n * n) {

            for (int y = col_begin; y <= col_end; y++)
                result[row_begin][y] = value++;

            row_begin++;

            for (int x = row_begin; x <= row_end; x++)
                result[x][col_end] = value++;

            col_end--;

            for (int y = col_end; y >= col_begin; y--)
                result[row_end][y] = value++;

            row_end--;

            for (int x = row_end; x >= row_begin; x--)
                result[x][col_begin] = value++;

            col_begin++;

        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateMatrix(4);
    }
}
