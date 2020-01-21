import java.util.*;

class Solution {
    //    public int kthSmallest(int[][] matrix, int k) { pq solution, slow O(n2);
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                pq.offer(matrix[i][j]);
//                if (pq.size() > k)
//                    pq.poll();
//            }
//        }
//        return pq.peek();
//    }

    //why the output is guaranteed to be a value that in the matrix
    //if helper(matrix, mid) return k, it means in the matrix there are k elements smaller or equals to mid, value we want is between [low, mid]
    //then right = mid - 1, if we still get count = k, then [low, new_mid] and we will keep narrow the range, util we get count<k then left = mid+1,
    //finally we will get a range that only one element is satisfied, that is the element we want
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int count = helper(matrix, mid);

            if (count < k)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    private int helper(int[][] matrix, int target) {
        int count = 0;
        int i = 0;
        int j = matrix.length - 1;

        while (j >= 0 && i < matrix.length) {   //count from top right
            if (matrix[i][j] <= target) {
                count += j + 1;
                i++;

            } else
                j--;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.kthSmallest(new int[][]{{2000000000}}, 1));

    }
}
