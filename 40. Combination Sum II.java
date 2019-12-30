import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        helper(candidates, target, 0, 0, result, new ArrayList<>(), used);
        return new ArrayList<>(result);
    }

    private void helper(int[] candidates, int target, int sum, int start, List<List<Integer>> result, List<Integer> list, boolean[] used) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (sum + candidates[i] > target)
                    break;

                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1])  //used[i - 1] is false means list does not contain this candidates[i-1],
                    continue;                         //and candidates[i] is the same with i - 1, means the same situation already happened before, this recursion is useless

                list.add(candidates[i]);
                used[i] = true;
                helper(candidates, target, sum + candidates[i], i + 1, result, list, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] can = {2, 5, 2, 1, 2};
    }
}
