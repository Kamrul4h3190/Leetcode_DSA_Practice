package Dijkstra;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode_778 {
    public static void main(String[] args) {
        Leetcode_778 app = new Leetcode_778();
//        int[][] grid = {{3,2},{0,1}};
        int[][] grid = {{10,12,4,6},{9,11,3,5},{1,7,13,8},{2,0,15,14}};
//        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
//        int[][] grid = {{0,2},{1,3}};
        System.out.println("min swimming time : " + app.swimInWater(grid));
    }

    public int swimInWater(int[][] grid) {// simple BFS , but with priority queue instead of normal queue
        int n = grid.length;     int[][] time = new int[n][n];

        int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}}, visited = new int[n][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);//sort points based on lowest effort
        time[0][0] = grid[0][0];    queue.offer(new int[]{0,0,time[0][0]}); //i,j,cost

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int i = cell[0],j=cell[1];

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y]==1) continue;

                int nextTime = Math.max(time[i][j],grid[x][y]);
                time[x][y] = nextTime;      visited[x][y] = 1;
                queue.offer(new int[]{x, y, nextTime});

            }
        }
        return time[n-1][n-1];
    }
}