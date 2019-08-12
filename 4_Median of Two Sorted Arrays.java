import java.util.Map;

class test {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int mn = n + m;
        double median = 0.0;
        int start = 0;
        int end = m;

        while (start <= end) {

            int xcut = (start + end) / 2;
            int ycut = (mn + 1) / 2 - xcut;

            int maxleftx = (xcut == 0) ? Integer.MIN_VALUE : nums1[xcut - 1];
            int maxlefty = (ycut == 0) ? Integer.MIN_VALUE : nums2[ycut - 1];
            int minrightx = (xcut == m) ? Integer.MAX_VALUE : nums1[xcut];
            int minrightY = (ycut == n) ? Integer.MAX_VALUE : nums2[ycut];

            if (maxleftx <= minrightY && maxlefty <= minrightx) {
                if (mn % 2 == 0)
                    return (double) (Math.max(maxleftx, maxlefty) + Math.min(minrightx, minrightY)) / 2;
                else
                    return (double) Math.max(maxleftx, maxlefty);
            } else if (maxleftx > minrightY) {
                end = xcut-1;
            } else if (maxlefty > minrightx) {
                start = xcut+1;
            }
        }
        return median;

    }

    public static void main(String[] args) {
        test t1 = new test();
        int[] nums1 = {1,3,4};
        int[] nums2 = {};
        System.out.println(t1.findMedianSortedArrays(nums1,nums2));

    }
}