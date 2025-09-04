package BFS_Multisource;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_542 {
    public static void main(String[] args) {
        Leetcode_542 app = new Leetcode_542();
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        System.out.println("distance matrix : " + Arrays.deepToString(app.updateMatrix(matrix)));
    }

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;  int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = 1;
                }
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            for (int[] dir: dirs){
                int x = point[0]+dir[0], y = point[1]+dir[1];
                if (x<0 || x>=m || y<0 || y>=n || visited[x][y]==1) continue;

                matrix[x][y] = matrix[point[0]][point[1]] + 1;
                visited[x][y] = 1;
                queue.offer(new int[]{x,y});
            }
        }
        return matrix;
    }
}