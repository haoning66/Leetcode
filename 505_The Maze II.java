
import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int m, n;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        //have to use BFS for this problem, our old DFS solution won't work, not sure why

        if (maze.length == 0 || maze[0].length == 0) return -1;

        if (start[0] == destination[0] && start[1] == destination[1]) return 0;

        m = maze.length;
        n = maze[0].length;
        Queue<Pos> queue = new LinkedList<>();
        int[][] distance = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        queue.offer(new Pos(start[0],start[1],0));

        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            if (current.x == destination[0] && current.y == destination[1]) {
                if (current.dis < distance[destination[0]][destination[1]])
                    distance[destination[0]][destination[1]] = current.dis;
                continue;
            }

            if (current.dis >= distance[destination[0]][destination[1]])
                continue;

            for (int[] dir : directions) {
                int cx = current.x;
                int cy = current.y;
                int curdis = current.dis;
                while (cx + dir[0] >= 0 && cx + dir[0] < m && cy + dir[1] >= 0 && cy + dir[1] < n && maze[cx + dir[0]][cy + dir[1]] == 0) {
                    cx += dir[0];
                    cy += dir[1];
                    curdis += 1;
                }
                if (curdis < distance[cx][cy]) {
                    distance[cx][cy] = curdis;
                    queue.offer(new Pos(cx,cy,curdis));
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}

class Pos{
    public int x;
    public int y;
    public int dis;
    Pos(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
