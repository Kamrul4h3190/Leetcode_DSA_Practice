import java.util.HashMap;
import java.util.Map;

public class Leetcode_1074 {
    public static void main(String[] args) {
        Leetcode_1074 app = new Leetcode_1074();
//        int[][] matrix = {{1,-1},{-1,1}}; int target = 0;
        int[][] matrix = {{0,1,0},{1,1,1},{0,1,0}}; int target = 2;
        System.out.println("target sum sub matrices : "+app.numSubmatrixSumTarget(matrix,target));
    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length; int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) { //calculate row-wise horizontal prefix Sum
            for (int j = 1; j <cols; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        int targetMatrices = 0;//column wise window sliding
        for (int col_i = 0; col_i < cols; col_i++) {
            for (int col_j = col_i; col_j < cols; col_j++) {
                Map<Integer,Integer> prefixSumFreq = new HashMap<>();
                prefixSumFreq.put(0,1);     int prefixSum = 0;//vertical prefix sum. horizontal has been calculated row-wise

                for (int row = 0; row < rows; row++) {//explore all rows of column
                    prefixSum+= matrix[row][col_j] - (col_i > 0 ? matrix[row][col_i - 1] : 0); //bracket important here

                    int required = prefixSum-target;
                    if (prefixSumFreq.containsKey(required))
                        targetMatrices+=prefixSumFreq.get(required);

                    prefixSumFreq.put(prefixSum,prefixSumFreq.getOrDefault(prefixSum,0)+1);
                }
            }
        }
        return targetMatrices;
    }
}