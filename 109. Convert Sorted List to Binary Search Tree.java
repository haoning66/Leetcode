import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        TreeNode root = helper(list, 0, list.size() - 1);
        return root;
    }

    private TreeNode helper(List<Integer> list, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(list.get(mid));
            root.left = helper(list, left, mid - 1);
            root.right = helper(list, mid + 1, right);
            return root;
        } else return null;
    }
}
