package Dijkstra;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode_1368 {
    public static void main(String[] args) {
        Leetcode_1368 app = new Leetcode_1368();
        int[][] grid = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
        System.out.println("min cost for a valid path : " + app.minCost(grid));
    }

    public int minCost(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i <m; i++) Arrays.fill(cost[i],Integer.MAX_VALUE);


        int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};//R L D U
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);//sort points based on lowest cost
        cost[0][0] = 0;    queue.offer(new int[]{0,0,0}); //i,j,cost

        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int i = point[0],j=point[1],cellCost = point[2];
            if (cellCost>cost[i][j]) continue;// dont process , already found a lesser cost

            for (int d = 0; d < dirs.length; d++) {
                int x = i+dirs[d][0],y = j+dirs[d][1];
                if (x<0 || x>=m || y<0 || y>=n) continue;//range out

                int moveCost = grid[i][j] == d+1 ? 0 : 1;//if direction match cost is 0, else 1

                if (cellCost+moveCost < cost[x][y]){//if cost reduces via this path, update and push queue with updated cost
                    cost[x][y] = cellCost+moveCost;
                    queue.offer(new int[]{x,y,cost[x][y]});
                }
            }
        }

        return cost[m-1][n-1];
    }
}