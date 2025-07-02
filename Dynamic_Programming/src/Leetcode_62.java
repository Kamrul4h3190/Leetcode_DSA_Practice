import java.util.Arrays;

public class Leetcode_62 {
    public static void main(String[] args) {
        Leetcode_62 app = new Leetcode_62();
        int m=3,n=7;
        System.out.println("number of unique paths : "+app.uniquePaths(m,n));
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(memo[i], -1);

        return uniquePathsRecursive(0, 0, m, n, memo);
    }

    public int uniquePathsRecursive(int x, int y, int m, int n, int[][] memo) {
        if (x == m - 1 && y == n - 1) return 1;
        if (x >= m  || y >= n ) return 0;

        if (memo[x][y] != -1) return memo[x][y];

        int rightPaths = uniquePathsRecursive(x + 1, y, m, n, memo);
        int downPaths = uniquePathsRecursive(x, y + 1, m, n, memo);

        return memo[x][y]= rightPaths + downPaths;
    }
}