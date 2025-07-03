import java.util.Arrays;

public class Leetcode_115 {
    public static void main(String[] args) {
        Leetcode_115 app = new Leetcode_115();
        String s = "babgbag", t = "bag";
//        String s = "rabbbit", t = "rabbit";
        System.out.println("number of distinct sequence : "+app.numDistinct(s,t));
    }
    public int numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        memSeq = new int[m][n];
        for (int[] row : memSeq) Arrays.fill(row,-1);

        return dynamicExplore(0,0,m,n,s,t);
    }
    int[][] memSeq;
    private int dynamicExplore(int i, int j, int m, int n, String s, String t){
        if (j>=n) return 1;
        if (i>=m) return 0;

        if (memSeq[i][j]!=-1) return memSeq[i][j];

        int take = s.charAt(i)==t.charAt(j) ? dynamicExplore(i+1, j+1, m, n, s, t): 0;
        int skip = dynamicExplore(i+1, j, m, n, s, t);

        return memSeq[i][j] = take+skip;
    }
}