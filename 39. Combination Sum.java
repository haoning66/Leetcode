import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper (candidates, target, 0, 0,result, new ArrayList<>());
        return result;
    }

    private void helper (int[] candidates, int target, int sum, int start, List<List<Integer>> result, List<Integer> list) {
        if (sum == target) {
            result.add(new ArrayList<>(list));   //this is deep copy
            return;
        }
        else {
            for (int i = start; i < candidates.length; i++) {   //start with the index "start", to avoid adding num added in previous recursion
                if (sum + candidates[i] > target)
                    continue;
                list.add (candidates[i]);
                helper (candidates, target, sum + candidates[i], i,result, list);
                list.remove (list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] can = {2,3,6,7};
        System.out.println(s.combinationSum(can, 7));
    }
}
