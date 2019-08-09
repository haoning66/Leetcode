import java.util.*;

class test {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList();
        int nums_length = nums.length;
        Arrays.sort(nums);
        if (nums_length == 0 || nums == null) return results;
        for (int i = 0; i < nums_length - 2; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int low = i + 1;
            int high = nums_length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    List result = new ArrayList();
                    result.add(nums[i]);
                    result.add(nums[low]);
                    result.add(nums[high]);
                    results.add(result);
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low - 1]) low++;
                    while (low < high && nums[high] == nums[high + 1]) high--;
                } else if (nums[i] + nums[low] + nums[high] < 0) {
                    low++;
                } else {
                    high--;
                }

            }
        }
        return results;
    }

    public static void main(String[] args) {
        test t1 = new test();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(t1.threeSum(nums));
    }
}