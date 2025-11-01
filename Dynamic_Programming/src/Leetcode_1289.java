import java.util.*;

public class Leetcode_1289 {
    public static void main(String[] args) {
        Leetcode_1289 app = new Leetcode_1289();
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("min falling path sum : "+ app.minFallingPathSum(grid));
    }
    public int minFallingPathSum(int[][] grid) {
        int minSum = Integer.MAX_VALUE;
        n = grid.length;    if(n==1) return grid[0][0];
        memSum = new Integer[n][n];
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum,findMinSum(0,col,grid));
        }
        return minSum;
    }
    Integer[][] memSum; int n;
    private int findMinSum(int row,int col,int[][] grid){
        if (row>=n) return 0;
        if (memSum[row][col]!=null) return memSum[row][col];

        int minSum = Integer.MAX_VALUE;
        for (int downColumn = 0; downColumn < n; downColumn++) {
            if (downColumn==col) continue;
            minSum = Math.min(minSum,findMinSum(row+1, downColumn, grid));
        }
        return memSum[row][col] = grid[row][col] + minSum; //(minSum is minimum of all row calls)
    }
}