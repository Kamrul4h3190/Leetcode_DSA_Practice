import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_132_2 {
    public static void main(String[] args) {
        Leetcode_132_2 app = new Leetcode_132_2();
        String s = "aab";
//        String s = "aab";
        System.out.println("minimum cuts : " + app.minCut(s));
    }

    public int minCut(String s) {
        n = s.length();
        memPartitions = new int[s.length()][s.length()];
        for (int[] row:memPartitions) Arrays.fill(row,-1);
        markPalindromes = new boolean[n][n];
        findPalindromes(s);
        return dynamicCut(0,n-1,s);
    }
    int[][] memPartitions;  boolean[][] markPalindromes; int n;
    private int dynamicCut(int start, int end,String s) {
        if (start>=n || markPalindromes[start][end]) return 0;
        if (memPartitions[start][end]!=-1) return memPartitions[start][end];

        int minCuts = Integer.MAX_VALUE;
        for (int mid = start; mid <end ; mid++) {
            if (markPalindromes[start][mid]){
                int cuts = 1 + dynamicCut(mid+1,end,s);
                minCuts = Math.min(minCuts,cuts);
            }
        }
        return memPartitions[start][end] = minCuts;
    }

    private void findPalindromes(String s) {
        int n = s.length();
        for (int len = 1; len <= n; len++) {
            for (int i = 0, j; i <= n - len; i++) {
                j = i + len - 1;
                markPalindromes[i][j] = (s.charAt(i) == s.charAt(j) && (len <= 2 || markPalindromes[i + 1][j - 1]));
            }
        }
    }

}