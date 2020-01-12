import java.util.*;

class Solution {
    //it will reach the leaf of the left and right subtree, flatten them and put the flattened left subtree to the right of the root
    //and reach the leaf of the current right subtree and put the original flattened right subtree on its right, brilliant!
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            flatten(root.left);
        if (root.right != null)
            flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null)
            root = root.right;
        root.right = temp;
    }
}