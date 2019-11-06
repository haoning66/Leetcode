import java.util.*;

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);        //if the value if dist is -1 then this node is not visited yet
        int[] low = new int[n];

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < connections.size(); i++) {   //build graph
            int from = connections.get(i).get(0);
            int to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == -1)
                dfs(i, dist, low, graph, res, i);
        }

        return res;
    }

    int time = 0;

    private void dfs(int u, int[] dist, int[] low, List<Integer>[] graph, List<List<Integer>> res, int pre) {
        dist[u] = low[u] = ++time;
        for (int j = 0; j < graph[u].size(); j++) {
            int v = graph[u].get(j);

            if (v == pre)
                continue;

            if (dist[v] == -1) {
                dfs(v, dist, low, graph, res, u);
                low[u] = Math.min(low[u], low[v]);   //because at this time u is also connected to v, so its low value has to include v's low value
                if (low[v] > dist[u])  //which means v is not in scc of u, edge (u,v) is a bridge
                    res.add(Arrays.asList(u, v));
            } else {
                low[u] = Math.min(low[u], dist[v]);   //let low value of u be the earliest visited node it connects to
            }

        }
    }


    public static void main(String[] args) {
    }
}