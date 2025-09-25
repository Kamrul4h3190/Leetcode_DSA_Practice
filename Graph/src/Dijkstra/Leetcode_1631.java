package Dijkstra;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode_1631 {
    public static void main(String[] args) {
        Leetcode_1631 app = new Leetcode_1631();
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println("min hiking effort : " + app.minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length,n=heights[0].length;
        int[][] efforts = new int[m][n];
        for (int i = 0; i <m; i++) Arrays.fill(efforts[i],Integer.MAX_VALUE);


        int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};//R L D U
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);//sort points based on lowest effort
        efforts[0][0] = 0;    queue.offer(new int[]{0,0,0}); //i,j,cost

        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int i = point[0],j=point[1],cellCost = point[2];
            if (cellCost>efforts[i][j]) continue;// dont process , already found a lesser cost

            for (int d = 0; d < dirs.length; d++) {
                int x = i+dirs[d][0],y = j+dirs[d][1];
                if (x<0 || x>=m || y<0 || y>=n) continue;//range out

                int moveCost = Math.max(cellCost, Math.abs(heights[i][j]-heights[x][y]));//optimization rule according to question

                if (moveCost < efforts[x][y]){//if cost reduces via this path, update and push queue with updated cost
                    efforts[x][y] = moveCost;
                    queue.offer(new int[]{x,y,efforts[x][y]});
                }
            }
        }

        return efforts[m-1][n-1];
    }
}