package BFS_Multisource;


import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_1020 {
    public static void main(String[] args) {
        Leetcode_1020 app = new Leetcode_1020();
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println("enclaves : " + app.numEnclaves(grid));
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;    int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        for(int i = 0 ; i < m ; i++) {//collect all the boundary exits,and push in queue
            for(int j = 0 ; j < n ; j++) {
                if (i==0 || i == m-1 || j==0 || j==n-1){
                    if(grid[i][j] == 1) {
                        grid[i][j] = 0;
                        queue.offer(new int[]{i , j});
                    }
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; //from boundary exits to inside mark 0
        while(!queue.isEmpty()) {
            int[] currPoint = queue.poll();
            for (int[] dir : dirs) {
                int x = currPoint[0]+dir[0],    y = currPoint[1]+dir[1];
                if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 || grid[x][y] == 2) continue;
                grid[x][y] = 0;
                queue.offer(new int[]{x,y});
            }
        }

        int enclaves = 0;// count closed enclaves, after boundary exit paths marking
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) enclaves++;
            }
        }
        return enclaves;
    }
}