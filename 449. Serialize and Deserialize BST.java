import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {

    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            sb.append(temp.val);
            sb.append(",");

            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);

        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("null"))
            return null;

        Queue<Integer> queue = new LinkedList<>();
        for (String s : data.split(","))
            queue.offer(Integer.parseInt(s));
        return treeBuilder(queue);
    }

    private TreeNode treeBuilder(Queue<Integer> queue) {
        if (queue.isEmpty())
            return null;
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> left = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < root.val)
            left.offer(queue.poll());
        root.left = treeBuilder(left);
        root.right = treeBuilder(queue);

        return root;
    }


}

class Solution {
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));