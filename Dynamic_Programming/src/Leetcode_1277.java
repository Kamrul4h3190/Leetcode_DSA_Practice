import java.util.Arrays;
import java.util.Vector;

public class Leetcode_1277 {
    public static void main(String[] args) {
        Leetcode_1277 app = new Leetcode_1277();
        int[][] matrix = {{0,1,1,1}, {1,1,1,1}, {0,1,1,1}};
        System.out.println("number 0f sub matrices : "+ app.countSquares(matrix));
    }
    public int countSquares(int[][] matrix) {
        m= matrix.length;   n= matrix[0].length;   memSquares = new int[m][n];
        for (int[] row:memSquares) Arrays.fill(row,-1);

        int subMetrices = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                subMetrices += countSubMatrices(i,j,matrix);
            }
        }
        return subMetrices;
    }
    int[][] memSquares; int m,n;
    private int countSubMatrices(int i,int j,int[][] matrix){
        if (i>=m || j>=n) return 0;     if (matrix[i][j]==0) return 0;
        if (memSquares[i][j]!=-1) return memSquares[i][j];

        int right = countSubMatrices(i,j+1,matrix);
        int diagonal = countSubMatrices(i+1, j+1, matrix);
        int down = countSubMatrices(i+1, j, matrix);

        return memSquares[i][j] = 1+Math.min(right,Math.min(diagonal,down));
    }
}