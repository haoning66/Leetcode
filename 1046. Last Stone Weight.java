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

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int w : stones)
            pq.offer(w);
        while(pq.size()>1){
            pq.offer(pq.poll() - pq.poll());   //dont need to compare the two elements because it will be in the correct position of pq, and dont need to add 0 if they are equal because 0 will always be at the bottom of pq
        }
        return pq.peek();
    }

    public static void main(String[] args) {


    }
}