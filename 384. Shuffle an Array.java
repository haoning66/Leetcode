import java.util.*;

class Solution {
    //better if sorted already
//    public int[] intersect(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int i = 0;
//        int j = 0;
//        List<Integer> list = new ArrayList<>();
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] < nums2[j])
//                i++;
//            else if (nums1[i] > nums2[j])
//                j++;
//            else {
//                list.add(nums1[i]);
//                i++;
//                j++;
//            }
//        }
//        int[] res = new int[list.size()];
//        for (int n = 0; n < list.size(); n++) {
//            res[n] = list.get(n);
//        }
//        return res;
//    }

    //hashmap solution
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] res = new int[list.size()];
        for (int n = 0; n < list.size(); n++) {
            res[n] = list.get(n);
        }
        return res;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intersect(new int[]{1,2,2,1},new int[]{2,2}));
    }

}
