import java.util.*;

class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (i == 0)
                    result.get(i).add(1);
                else {
                    if (j == 0 || j == i)
                        result.get(i).add(1);
                    else
                        result.get(i).add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
