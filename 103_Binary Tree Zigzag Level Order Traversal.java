import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> tree_queue = new LinkedList<>();
        tree_queue.offer(root);
        int count = 0;

        while (!tree_queue.isEmpty()) {
            int len = tree_queue.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0;i<len;i++){
                TreeNode curr = tree_queue.poll();
                if(curr.left!=null){
                    tree_queue.offer(curr.left);
                }
                if(curr.right!=null){
                    tree_queue.offer(curr.right);
                }
                temp.add(curr.val);
            }

            if(count%2!=0) Collections.reverse(temp);

            result.add(temp);
            count++;
        }

        return result;
    }




    public TreeNode build_tree(int[] tree_list) {
        List<TreeNode> treenode_list = new ArrayList<>();

        for (int i = 0; i < tree_list.length; i++) {
            treenode_list.add(new TreeNode(tree_list[i]));
        }

        for (int j = 0; j < tree_list.length / 2 - 1; j++) {
            treenode_list.get(j).left = treenode_list.get(2 * j + 1);
            treenode_list.get(j).right = treenode_list.get(2 * j + 2);
        }
        int index = tree_list.length / 2 - 1;
        treenode_list.get(index).left = treenode_list.get(2 * index + 1);
        if (tree_list.length % 2 == 1) {
            treenode_list.get(index).right = treenode_list.get(2 * index + 2);
        }
        return treenode_list.get(0);
    }


    public void show_tree(TreeNode tree) {
        Queue<TreeNode> tree_queue = new LinkedList<>();
        tree_queue.offer(tree);
        int count=0;
        while (!tree_queue.isEmpty()) {
            TreeNode temp = tree_queue.poll();
            count+=1;
            System.out.println(temp.val);
            if(((count+1)&count)==0){
                System.out.println("--------------");
            }
            if (temp.left != null) {
                tree_queue.offer(temp.left);
            }
            if (temp.right != null) {
                tree_queue.offer(temp.right);
            }
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.left.left = new TreeNode(5);


        System.out.println(s.zigzagLevelOrder(root));

//        System.out.println(s.helper(root));


    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {

    }

}

