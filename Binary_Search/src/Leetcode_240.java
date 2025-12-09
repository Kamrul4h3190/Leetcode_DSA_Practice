public class Leetcode_240 {
    public static void main(String[] args) {
        Leetcode_240 app = new Leetcode_240();
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int target = 19;
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int target = 5;
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int target = 20;
        System.out.println("target found in matrix : "+ app.searchMatrix(matrix,target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;  int n = matrix[0].length;
        if (target<matrix[0][0] || target>matrix[m-1][n-1]) return false; //out range
        return binarySearch(matrix,target ); //search in the specific row
    }
    private boolean binarySearch(int[][] matrix, int target){
        int row = 0;   int col = matrix[0].length-1;
        while (col>=0 && row<matrix.length){
            if (matrix[row][col]==target) return true;//found

            if (matrix[row][col]<target) row++;// target is greater, next row
            else col--; //target is smaller, prev col of this row
        }
        return false;
    }
}