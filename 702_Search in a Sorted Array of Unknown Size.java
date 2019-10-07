class Solution {
    public int search(ArrayReader reader, int target) {
        int left=0;
        int right = Integer.MAX_VALUE;
        while(right > left) {
            int mid = left + (right-left) / 2;
            int x = reader.get(mid);
            if(x == target)
                return mid;
            else if(x>target)
                right = mid;
            else
                left = mid + 1;
        }
        return -1;
    }
}