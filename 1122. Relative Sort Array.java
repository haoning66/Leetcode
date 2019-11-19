import java.util.*;

class Solution {
    class CustomCompare implements Comparator<Integer> {
        private Map<Integer, Integer> map = new HashMap<>();

        public CustomCompare(int[] arr2) {
            for (int i = 0; i < arr2.length; i++) {
                map.put(arr2[i], i);
            }
        }

        /* Now lets talk about how to use customized sort, lets say we want ascending order so it is o1-o2
         * o1>o2   return 1  o2,o1
         * o1<o2   return -1 o1,o2
         * o1=o2   return 0  o1 o2 is the same
         * Use this rule to check if the return value is what we want
         * */

        public int compare(Integer a, Integer b) {
            if (map.containsKey(a) && map.containsKey(b))
                return map.get(a).compareTo(map.get(b));      // >0 b,a; <0 a,b
            else if (map.containsKey(a))
                return -1;                           // a-b<0; a<b; a,b
            else if (map.containsKey(b))
                return 1;                            //b,a
            else
                return a.compareTo(b);               //a>b, 1, b,a;
            //b>a, -1, a,b;
        }

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            list.add(i);
        }

        Collections.sort(list, new CustomCompare(arr2));

        for (int i = 0; i < list.size(); i++)
            arr1[i] = list.get(i);
        return arr1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Integer a = 1;

    }
}
