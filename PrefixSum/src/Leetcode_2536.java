import java.util.Arrays;

public class Leetcode_2536 {
    public static void main(String[] args) {
        Leetcode_2536 app = new Leetcode_2536();
        int[][] queries= {{1,1,2,2},{0,0,1,1}}; int n=3;
        System.out.println(Arrays.deepToString(app.rangeAddQueries(n, queries)));
    }
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diffMatrix = new int[n][n];
        for (int[] query : queries) { //mark the boundaries
            int r1 = query[0],c1=query[1];
            int r2 = query[2],c2=query[3];

            diffMatrix[r1][c1] ++;
            if (c2+1<n) diffMatrix[r1][c2+1]--;//right corner after boundary
            if (r2+1<n) diffMatrix[r2+1][c1]--;//down corner below boundary
            if (r2+1<n && c2+1<n) diffMatrix[r2+1][c2+1]++;//diagonal down out boundary
        }

        for (int i = 0; i < n; i++) {//do the prefix sum
            for (int j = 0; j < n; j++) {
                int above = (i>0) ? diffMatrix[i-1][j] : 0;
                int left = (j>0) ? diffMatrix[i][j-1] : 0;
                int common =(i>0 && j>0) ? diffMatrix[i-1][j-1] : 0;

                diffMatrix[i][j] += above + left - common;
            }
        }
        return diffMatrix;
    }
}