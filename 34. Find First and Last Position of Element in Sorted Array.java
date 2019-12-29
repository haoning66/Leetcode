class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;

        while (right >= left) {           //this is the new binary search, remember it!!!!!
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                int i = mid;
                int j = mid;

                while (i > 0 && nums[i - 1] == nums[i])
                    i--;
                while (j < nums.length - 1 && nums[j + 1] == nums[j])
                    j++;

                return new int[]{i, j};
            } else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = s.searchRange(new int[]{1,4}, 4);
        for (int num : a) {
            System.out.println(num);
        }
    }

}
