package Dijkstra;


import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_1091 {
    public static void main(String[] args) {
        Leetcode_1091 app = new Leetcode_1091();
        int[][] grid = {{0,0,0}, {1,1,0}, {1,1,0}};
        System.out.println("shortest clear path : " + app.shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};//8 direction level bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});    grid[0][0] = 1;
        int level = 0;
        while (!queue.isEmpty()){
            level++;// level will not increase after execution of last level, just return level
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] point = queue.poll();
                if (point[0]==n-1 && point[1]==n-1) return level;

                for (int[] dir : dirs) {
                    int x = point[0]+dir[0], y = point[1]+dir[1];
                    if (x<0 || x>=n || y<0 || y>=n || grid[x][y]==1) continue;

                    grid[x][y] = 1;//mark visited . no need extra visited array
                    queue.offer(new int[]{x,y});
                }
            }
        }

        return -1;
    }
}