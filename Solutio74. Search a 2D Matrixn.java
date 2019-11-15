class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            int value = matrix[i][j];
            if (value == target)
                return true;
            else if (value > target)
                i--;
            else
                j++;
        }
        return false;
    }
}