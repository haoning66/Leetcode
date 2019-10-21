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
    private Map<TreeNode, TreeNode> parent;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        int level = 0;
        parent = new HashMap<>();
        dfsFindParent(root, null);

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(null); //this null is to indicate the level of the node in the queue, [node1,node2,...,node10,null] this means node1 to node 10 are in the same level
        queue.offer(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        visited.add(null); //so that no null node will be added to the queue

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                if (level == K) {
                    List<Integer> res = new ArrayList<>();
                    for (TreeNode node : queue) {
                        res.add(node.val);
                    }
                    return res;
                }
                queue.offer(null);
                level++;
            } else {
                if(!visited.contains(cur.left)){
                    visited.add(cur.left);
                    queue.offer(cur.left);
                }
                if(!visited.contains(cur.right)){
                    visited.add(cur.right);
                    queue.offer(cur.right);
                }
                TreeNode par = parent.get(cur);
                if(!visited.contains(par)){
                    visited.add(par);
                    queue.add(par);
                }

            }
        }
        return new ArrayList<>();
    }

    private void dfsFindParent(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfsFindParent(node.left, node);
            dfsFindParent(node.right, node);
        }
    }

    public static void main(String[] args) {


    }
}