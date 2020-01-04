import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {  //every time just add new element to existing subset, and elements are distinct, so there will not be duplicate
            int n = result.size();
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3};
        System.out.println(s.subsets(nums));
    }
}
