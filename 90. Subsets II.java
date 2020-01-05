import java.util.*;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);   //have to sort it, so that duplicate elements will be together to avoid situation like {4,4,4,1,4}
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> temp = new ArrayList<>();
        for (int num : nums) {
            if (!set.contains(num)) {   //if num is not duplicate, get all elements in result and add this num
                int n = result.size();
                temp = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    List<Integer> list = new ArrayList<>(result.get(i));

                    list.add(num);
                    temp.add(list);
                    result.add(list);
                }
            }
            else {  //if num is duplicate, get all the elements added in last iteration and add num
                List<List<Integer>> temp2 = new ArrayList<>();
                for (int i = 0; i < temp.size(); i++) {
                    List<Integer> list = new ArrayList<>(temp.get(i));
                    list.add(num);
                    result.add(list);
                    temp2.add(list);
                }
                temp = new ArrayList<>(temp2);
            }
            set.add(num);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,4,4,1,4};
        System.out.println(s.subsetsWithDup(nums));
    }
}
