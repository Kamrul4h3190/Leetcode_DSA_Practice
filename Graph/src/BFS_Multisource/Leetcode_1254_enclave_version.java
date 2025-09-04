package BFS_Multisource;


import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_1254_enclave_version {
    public static void main(String[] args) {
        Leetcode_1254_enclave_version app = new Leetcode_1254_enclave_version();
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
//        int[][] grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        System.out.println("closed islands : " + app.closedIsland(grid));
    }

    public int closedIsland(int[][] grid) {
        m = grid.length;    n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < m ; i++) {//collect all the boundary exits,and push in queue
            for(int j = 0 ; j < n ; j++) {
                if (i==0 || i == m-1 || j==0 || j==n-1){
                    if(grid[i][j] == 0) {//if land in boundary
                        grid[i][j] = 1;
                        queue.offer(new int[]{i , j});
                    }
                }
            }
        }

        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //from boundary exits to inside mark 0
        while(!queue.isEmpty()) {
            int[] currPoint = queue.poll();
            for (int[] dir : dirs) {
                int x = currPoint[0]+dir[0],    y = currPoint[1]+dir[1];
                if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 1) continue;
                grid[x][y] = 1;
                queue.offer(new int[]{x,y});
            }
        }

        int closedIslands = 0;// count closed enclaves, after boundary exit paths marking
        for (int i=0 ; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0){//if land
                    dfs(i,j,grid);
                    closedIslands++;
                }
            }
        }
        return closedIslands;
    }
    int[][] dirs;
    int m,n;
    private void dfs(int i,int j,int[][] grid){
        if (grid[i][j]==1) return;

        grid[i][j] = 1;
        for (int[] dir: dirs){
            int x = i+dir[0],    y = j+dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 1) continue;
            dfs(x,y,grid);
        }
    }
}