class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length==0 || maze[0].length==0) return false;

        if(start[0]==destination[0] && start[1]==destination[1]) return true;

        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs_findpath(maze, start, destination, visited);
    }
    int m,n;
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    private boolean not_wall(int x, int y){
        if(x>=0 && x<m && y>=0 && y<n) return true;
        else return false;
    }

    private boolean dfs_findpath(int[][] maze, int[] current, int[] destination, boolean[][] visited){
        if(visited[current[0]][current[1]]) return false;

        if(Arrays.equals(current,destination)) return true;

        visited[current[0]][current[1]] = true;
        for(int[] dir:directions){
            int cx = current[0];
            int cy = current[1];
            while(not_wall(cx+dir[0],cy+dir[1]) && maze[cx+dir[0]][cy+dir[1]]!=1){
                cx += dir[0];
                cy += dir[1];
            }
            if (dfs_findpath(maze,new int[] {cx,cy},destination,visited)) return true;
        }
        return false;
    }
}
