public class Leetcode_378 {
    public static void main(String[] args) {
        Leetcode_378 app = new Leetcode_378();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};   int k = 8;
        System.out.println("Kth smallest in matrix : "+ app.kthSmallest(matrix,k));
    }

    public int kthSmallest(int[][] matrix, int k) {//find first occurrence(lower bound) such that count<=(x) is greater or equal to k.
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n -1][n-1];
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (countLessOrEqual(matrix, mid) >= k) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return left;
    }
    int countLessOrEqual(int[][] matrix, int mid) {
        int count = 0;
        int n = matrix.length;
        int col = n-1;//for each row reduce columns if greater elements found
        for (int row = 0; row < n; row++) {
            while (col>=0 && matrix[row][col]>mid) col--;
            count+=(col+1);
        }
        return count;
    }
}