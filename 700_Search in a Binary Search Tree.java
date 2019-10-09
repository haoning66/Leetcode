class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
//        TreeNode cur = root;
//        while(cur != null){
//            if(val > cur.val)
//                cur = cur.right;
//            else if(val < cur.val)
//                cur = cur.left;
//            else return cur;
//        }
//        return null;
        if (root == null)
            return null;
        if (val == root.val)
            return root;
        else if (val > root.val)
            return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}