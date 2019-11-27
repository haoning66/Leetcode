import java.util.*;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        int level = (int) (Math.log(label) / Math.log(2)) + 1;

        int pre;
        result.add(label);
        while (level > 1) {
            if (level % 2 == 0) {
                pre = (int) (Math.pow(2, level - 2)) + ((int) Math.pow(2, level) - 1 - label) / 2;  //its parent node 
            } else
                pre = (int) (Math.pow(2, level - 1)) - ((int) Math.pow(2, level - 2) - ((int) Math.pow(2, level) - 1 - label) / 2);

            result.add(pre);
            level--;
            label = pre;
        }
        if (label > 1)
            result.add(1);

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.pathInZigZagTree(26));
    }
}