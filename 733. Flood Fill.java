import java.util.*;

class Solution {
    private int n;
    private int m;
    private int newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;

        n = image.length;
        m = image[0].length;
        this.newColor = newColor;
        helper(image, sr, sc, image[sr][sc]);
        return image;
    }

    private void helper(int[][] image, int i, int j,int color) {

        if (i < 0 || i >= n || j < 0 || j >= m || image[i][j] != color)
            return;

        image[i][j] = newColor;

        helper(image,i - 1, j,color);
        helper(image,i + 1, j,color);
        helper(image,i, j - 1,color);
        helper(image,i, j + 1,color);

    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[][] b;
        int[][] a = {{1,1,1},{1,1,0},{1,0,1}};
        b = s.floodFill(a,1,1,2);

        for(int[] num:b){
            for(int n:num){
                System.out.print(n);
            }
            System.out.println();
        }
    }
}