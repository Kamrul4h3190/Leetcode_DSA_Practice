import java.util.Arrays;

public class Leetcode_1143 {
    public static void main(String[] args) {
        Leetcode_1143 app = new Leetcode_1143();
        String text1 = "abcde", text2 = "ace";
//        String text1 = "sea",text2 = "eat";
        System.out.println("length of LCS: "+app.longestCommonSubsequence(text1,text2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length();
        memDelete = new int[m][n];
        for (int[] row : memDelete) Arrays.fill(row,-1);

        return dynamicExplore(0,0,m,n,text1,text2);
    }
    int[][] memDelete;
    private int dynamicExplore(int i, int j, int m, int n, String s1, String s2){
        if(i>=m || j>=n) return 0;

        if (memDelete[i][j]!=-1) return memDelete[i][j];

        if (s1.charAt(i)==s2.charAt(j))
            return memDelete[i][j] = 1 + dynamicExplore(i+1, j+1, m, n, s1, s2);

        int select_s1 = dynamicExplore(i, j+1, m, n, s1, s2);
        int select_s2 = dynamicExplore(i+1, j, m, n, s1, s2);

        return memDelete[i][j] = Math.max(select_s1,select_s2);
    }
}