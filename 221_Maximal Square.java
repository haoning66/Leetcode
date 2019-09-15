import java.util.*;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return 0;
        int[][] area = new int[matrix.length][matrix[0].length];
        area[0][0] = Integer.parseInt("" + matrix[0][0]);
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) area[i][j] = Integer.parseInt("" + matrix[i][j]);
                else {
                    if(matrix[i][j]=='1'){
                        area[i][j] = Math.min(Math.min(area[i-1][j],area[i][j-1]),area[i-1][j-1])+1;
                    }
                }
            if(area[i][j]>max) max=area[i][j];
            }

        }
        return max*max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] a = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] b = {{'0'},{'0'}};
        System.out.println(s.maximalSquare(b));
    }
}

