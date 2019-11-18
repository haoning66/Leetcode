import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return result;
        int m = matrix.length;
        int n = matrix[0].length;


        int row_begin = 0;
        int row_end = m - 1;
        int col_begin = 0;
        int col_end = n - 1;
        int count = 0;


        while (count < m * n) {
            for (int y = col_begin; y <= col_end; y++) {
                result.add(matrix[row_begin][y]);
                count++;
                if (count >= m * n)
                    return result;
            }
            row_begin++;

            for (int x = row_begin; x <= row_end; x++) {
                result.add(matrix[x][col_end]);
                count++;
                if (count >= m * n)
                    return result;
            }

            col_end--;


            for (int y = col_end; y >= col_begin; y--) {
                result.add(matrix[row_end][y]);
                count++;
                if (count >= m * n)
                    return result;
            }
            row_end--;

            for (int x = row_end; x >= row_begin; x--) {
                result.add(matrix[x][col_begin]);
                count++;
                if (count >= m * n)
                    return result;
            }

            col_begin++;

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }
}