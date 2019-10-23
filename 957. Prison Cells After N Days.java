import java.util.*;

class Solution {
//    public int[] prisonAfterNDays(int[] cells, int N) {   //apparently this naive solution will TLE
//        int[] newcells = new int[cells.length];
//        newcells[0] = 0;
//        newcells[newcells.length - 1] = 0;
//        while (N > 0) {
//
//            for (int i = 1; i < newcells.length - 1; i++) {
//                if (cells[i - 1] == 0 && cells[i + 1] == 0 || cells[i - 1] == 1 && cells[i + 1] == 1)
//                    newcells[i] = 1;
//                else newcells[i] = 0;
//            }
//            cells = newcells.clone();
//
//            N--;
//        }
//        return newcells;
//    }

//    public int[] prisonAfterNDays(int[] cells, int N) {
//
//    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        int[] newcells = new int[cells.length];
        newcells[0] = 0;
        newcells[cells.length - 1] = 0;
        while (N>0) {
            for (int i = 1; i < newcells.length - 1; i++)
                newcells[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            N--;
            if (!map.containsKey(Arrays.toString(newcells))) {
                map.put(Arrays.toString(newcells), N);
            }else {
                N = N%map.size();   //when it happens that the next status already appears in the map, N becomes the remainder
            }
            cells = newcells.clone();   //clone is deepcopy
        }
        return newcells;
    }

    public static void main(String[] args) {
        int[] cells = {1,0,0,1,0,0,1,0};
        Solution s = new Solution();

        for(int i:s.prisonAfterNDays(cells,1000000000)){
            System.out.print(i);
        }


    }
}