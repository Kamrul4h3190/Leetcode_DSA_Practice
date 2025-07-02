import java.util.Arrays;

public class Leetcode_931 {
    public static void main(String[] args) {
        Leetcode_931 app = new Leetcode_931();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println("min falling path : "+app.minFallingPathSum(matrix));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memFallSum = new int[n][n];
        for (int[] row:memFallSum) Arrays.fill(row,-101); //-1 interfere ,-100 <= matrix[i][j] <= 100/ .mem = Integer[][] works fine
        int min = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            min = Math.min(min, dynamicFall(0,j,n,matrix));
        }
        return min;
    }
    int[][] memFallSum;
    private int dynamicFall(int i, int j, int n, int[][]matrix){
        if (j < 0 || j >= n) return Integer.MAX_VALUE;
        if(i==n-1) return matrix[i][j];
        if (memFallSum[i][j] != -101) return memFallSum[i][j];

        int down = dynamicFall(i + 1, j,n, matrix); // Do not add distinctly matrix[i][j], may cause overflow, Add at the end
        int downLeft = dynamicFall(i + 1, j - 1,n, matrix);
        int downRight = dynamicFall(i + 1, j + 1,n, matrix);

        return memFallSum[i][j] = matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));
    }
}