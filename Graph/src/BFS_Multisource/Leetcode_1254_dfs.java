package BFS_Multisource;


import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_1254_dfs {
    public static void main(String[] args) {
        Leetcode_1254_dfs app = new Leetcode_1254_dfs();
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
//        int[][] grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        System.out.println("closed islands : " + app.closedIsland(grid));
    }

    public int closedIsland(int[][] grid) {
        m = grid.length;    n = grid[0].length; int closedIslands = 0;
        for(int i = 0 ; i < m ; i++) {//collect all the boundary exits,and push in queue
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 0) //if land in boundary
                    if (dfs(i,j,grid)) closedIslands++;
            }
        }
        return closedIslands;
    }
    int m,n;    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean dfs(int i,int j,int[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n) return false;//boundary
        if (grid[i][j]==1) return true;//surrounded by water(1) ok

        grid[i][j] = 1;//mark visited
        boolean closedIsland = true;
        for (int[] dir: dirs){
            int x = i+dir[0],    y = j+dir[1];
            closedIsland &= dfs(x,y,grid); //if any side is not surrounded by water, answer becomes false
        }
        return closedIsland;
    }
}