import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            List<Integer> list = map.getOrDefault(cur.level, new ArrayList<>());
            list.add(cur.node.val);
            map.put(cur.level, list);

            if (cur.node.left != null)
                queue.offer(new Node(cur.node.left, cur.level - 1));
            if (cur.node.right != null)
                queue.offer(new Node(cur.node.right, cur.level + 1));
        }

        return new ArrayList<>(map.values());     
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(s.verticalOrder(n1));

    }
}

class Node {
    TreeNode node;
    int level;

    public Node(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}