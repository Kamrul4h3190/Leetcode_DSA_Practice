package Dijkstra;


import java.util.PriorityQueue;

public class Leetcode_778_v2 {
    public static void main(String[] args) {
        Leetcode_778_v2 app = new Leetcode_778_v2();
//        int[][] grid = {{3,2},{0,1}};
        int[][] grid = {{10, 12, 4, 6}, {9, 11, 3, 5}, {1, 7, 13, 8}, {2, 0, 15, 14}};
//        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
//        int[][] grid = {{0,2},{1,3}};
        System.out.println("min swimming time : " + app.swimInWater(grid));
    }
    public int swimInWater(int[][] heights) {
        int n = heights.length;     int[][] visited = new int[n][n];
        int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};//R L D U
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);//sort based on height
        queue.offer(new int[]{0,0,heights[0][0]});    visited[0][0] = 1;

        while (!queue.isEmpty()){
            int[] cell = queue.poll();//pop minimum of the maximums
            int i = cell[0],j=cell[1], h = cell[2];
            if (i==n-1 && j==n-1) return h;//reached

            for (int[] dir : dirs) {
                int x = i+dir[0], y = j+dir[1];
                if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y]==1) continue;
                visited[i][j] = 1;
                queue.offer(new int[]{x,y,Math.max(h,heights[x][y] )});
            }
        }
        return 0;//syntactical return
    }
}
