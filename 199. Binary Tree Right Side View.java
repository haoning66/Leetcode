import javafx.util.Pair;

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        int max_depth = 0;
        nodes.offer(root);
        depth.offer(0);

        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.poll();
            int cur_depth = depth.poll();
            max_depth = Math.max(max_depth, cur_depth);
            map.put(cur_depth, cur.val);
            if (cur.left != null) {
                nodes.offer(cur.left);
                depth.offer(cur_depth + 1);
            }
            if (cur.right != null) {
                nodes.offer(cur.right);
                depth.offer(cur_depth + 1);
            }
        }

        for (int i = 0; i <= max_depth; i++) {
            list.add(map.get(i));
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {1, 2};
        String str = "aa";
    }
}
