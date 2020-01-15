import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){   //how to write customized comparator
            @Override
            public int compare(int[] a, int[] b){  //sort the array in descending order by [0], in ascending order by [1]
                if (a[0] == b[0])                  //so that when adding element to a list by its [1] it will be in right order
                    return a[1] - b[1];            //its index will change when other shorter people are added in front of it, and its [1] will be satisfied
                else                               //because these people is shorter
                    return b[0] - a[0];
            }
        });

        List<int[]> res = new ArrayList<>();

        for (int[] p : people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[people.length][2]);      //how to convert list to array
    }


    public static void main(String args[]) {
        Solution s = new Solution();
    }
}
