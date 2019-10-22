import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
//    public int[][] kClosest(int[][] points, int K) {
//        Arrays.sort(points, (point1, point2) ->  //this is simple and concise but slow as fuck
//            point1[0]*point1[0]+point1[1]*point1[1]-point2[0]*point2[0]-point2[1]*point2[1]);
//        return Arrays.copyOfRange(points,0,K);
//    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o1[0]+o1[1]*o1[1]-o2[0]*o2[0]-o2[1]*o2[1];     //the comparator of priority queue is the same with Arrays.sort, o1-o2 => ascending, o2-o1 => descending
            }
        });

        for(int[] p:points){
            pq.offer(p);
        }

        int[][] res = new int[K][2];

        int i=0;
        while(i<K){
            res[i++] = pq.poll();

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points={{3,3},{5,-1},{-2,4}};
        Solution s= new Solution();
        for(int[] i:s.kClosest(points,2)){
            System.out.println(i[0]);
        }
    }
}