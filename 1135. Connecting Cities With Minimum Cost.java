import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int minimumCost(int N, int[][] connections) {  //Kruskal's algorithm, sort the edges in ascending order,
        int[] parent = new int[N + 1];                    //get the edge with the smallest weight, if doesnt get a cycle
        int result = 0;                                   //put it in, use union find to figure out if it gets a cycle
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        Arrays.sort(connections, (o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < connections.length && N != 1; i++) {
            int r1 = find(parent, connections[i][0]);
            int r2 = find(parent, connections[i][1]);
            if (r1 != r2) {
                parent[r2] = r1;
                result += connections[i][2];
                N--;
            }
        }
        return N == 1 ? result : -1;
    }

    private int find(int[] parent, int i) {        //union find, to find which union i belongs
        if (parent[i] == i)
            return i;
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }

}