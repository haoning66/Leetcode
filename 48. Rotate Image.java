import java.util.*;

class Solution {
    public void rotate(int[][] matrix) {  // surprisingly, when you transpose a matrix and reverse its column, you get its 90 degrees clockwise rotation
        if (matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length)
            return;

        transpose(matrix);

        for (int i = 0; i < matrix.length / 2; i++) {   //reverse columns
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void transpose(int[][] matrix) {    //transpose matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        s.rotate(matrix);
    }
}
