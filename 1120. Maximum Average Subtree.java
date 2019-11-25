import java.util.*;

class Solution {
    //    public double maximumAverageSubtree(TreeNode root) { easy recursive solution, slow
//        if (root == null)
//            return 0;
//
//        double result = (double) getSum(root) / getCount(root);
//
//        return Math.max(result, Math.max(maximumAverageSubtree(root.left), maximumAverageSubtree(root.right)));
//
//    }
//
//    private int getSum(TreeNode cur) {
//        if (cur == null)
//            return 0;
//
//        return getSum(cur.left) + getSum(cur.right) + cur.val;
//    }
//
//    private int getCount(TreeNode cur) {
//        if (cur == null)
//            return 0;
//        return getCount(cur.left) + getCount(cur.right) + 1;
//    }
    private double max = 0;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null)
            return 0;

        double[] rootVal = helper(root);

        return Math.max(rootVal[0] / rootVal[1], max);

    }

    private double[] helper(TreeNode cur) {
        if (cur == null)
            return new double[]{0, 0};
        double[] left = helper(cur.left);
        double[] right = helper(cur.right);

        if (cur.left == null && cur.right != null)
            max = Math.max(max, right[0] / right[1]);
        else if (cur.left != null && cur.right == null)
            max = Math.max(max, left[0] / left[1]);
        else if(cur.left != null && cur.right != null)
            max = Math.max(max, Math.max(left[0] / left[1], right[0] / right[1]));

        return new double[]{left[0] + right[0] + cur.val, left[1] + right[1] + 1};
    }
}