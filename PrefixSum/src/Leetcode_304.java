public class Leetcode_304 {
    public static void main(String[] args) {
        int[][] matrix = {{3,0,1},{5,6,3},{1,2,0}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println("range sum 2d : "+ numMatrix.sumRegion(1,1,2,2));
    }
    static class NumMatrix {
        int m,n;
        int[][] sumMatrix;
        public NumMatrix(int[][] matrix) {
            m = matrix.length; n = matrix[0].length;
            sumMatrix = new int[m+1][n+1];

            for (int i = 1; i <= m; i++) {//build prefix sumMatrix
                for (int j = 1; j <=n; j++) {
                    sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + matrix[i-1][j-1];//add twice , deduct once + cell value
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) { //parameters 0 based
            row1++; col1++;row2++;col2++;//transforming to 1 based
            return sumMatrix[row2][col2] - sumMatrix[row1-1][col2] - sumMatrix[row2][col1-1] + sumMatrix[row1-1][col1-1];//from the whole, deduct twice, add once
        }
    }
}