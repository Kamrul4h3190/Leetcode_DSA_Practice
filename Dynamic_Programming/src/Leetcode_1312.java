import java.util.Arrays;

public class Leetcode_1312 {
    public static void main(String[] args) {
        Leetcode_1312 app = new Leetcode_1312();
        String s = "leetcode";
//        String s = "mbadm";
        System.out.println("min insertions: "+app.minInsertions(s));
    }
    public int minInsertions(String s) {
        int n=s.length();
        memInsert = new int[n][n];
        for (int[] row : memInsert) Arrays.fill(row,-1);

        return matchAndInsert(0,n-1,s);
    }
    int[][] memInsert;
    private int matchAndInsert(int i, int j, String s){
        if(i>=j) return 0;

        if (memInsert[i][j]!=-1) return memInsert[i][j];

        if (s.charAt(i)==s.charAt(j))
            return memInsert[i][j] = matchAndInsert(i+1, j-1, s);

        int match_i = 1 + matchAndInsert(i+1, j,s);
        int match_j = 1 + matchAndInsert(i, j-1,s);

        return memInsert[i][j] = Math.min(match_j,match_i);
    }
}