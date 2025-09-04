package BFS_Multisource;


import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_994 {
    public static void main(String[] args) {
        Leetcode_994 app = new Leetcode_994();
        int[][] grid = {{2,1,0,2},{1,0,1,2},{1,0,0,1}};
//        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println("orange rotting time : " + app.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        if(count_fresh == 0) return 0;
        int level = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0 ; i < levelSize ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;//2 is rotten+visited
                    grid[x][y] = 2;
                    queue.offer(new int[]{x , y});
                    count_fresh--;
                }
            }
            if (!queue.isEmpty()) level++; //do not level++,after the bfs has been completed
        }
        return count_fresh == 0 ? level : -1;
    }
}