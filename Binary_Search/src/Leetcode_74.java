public class Leetcode_74 {
    public static void main(String[] args) {
        Leetcode_74 app = new Leetcode_74();
        int[][] matrix = {{1,3}}; int target = 3;
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}}; int target = 3;
//        int[] matrix = {1,3,5,6}; int target = 5;
        System.out.println("target found in matrix : "+ app.searchMatrix(matrix,target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;  int n = matrix[0].length;
        if (target<matrix[0][0] || target>matrix[m-1][n-1]) return false; //out range
        int row = lowerBound(matrix,target); //detect which row to search
        return binarySearch(matrix[row],target ); //search in the specific row
    }
    private boolean binarySearch(int[] nums, int target){
        int left = 0;   int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target) return true;

            if (nums[mid]>target) right = mid-1;
            else left = mid+1;
        }
        return false;
    }
    private int lowerBound(int[][] matrix, int target) {
        int m = matrix.length; int n = matrix[0].length;
        int left=0; int right = m-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (matrix[mid][n-1]>=target) //occurrence >= target . left boundary of a range
                right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}