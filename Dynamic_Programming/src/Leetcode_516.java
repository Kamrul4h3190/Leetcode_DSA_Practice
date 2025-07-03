import java.util.Arrays;

public class Leetcode_516 {
    public static void main(String[] args) {
        Leetcode_516 app = new Leetcode_516();
        String s = "a";
//        String s = "cbbd";
//        String s = "bbbab";
        System.out.println("longest palindromic sub.sequence len : "+app.longestPalindromeSubseq(s));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        memLen = new int[n][n];
        for(int [] row:memLen) Arrays.fill(row, -1);
        return recursion(0,n-1,s);
    }

    int[][] memLen;
    private int recursion(int left,int right,String s){
        if(left>right) return 0;
        if(left==right) return 1;

        if(memLen[left][right]!=-1) return memLen[left][right];

        if(s.charAt(left)==s.charAt(right)) return memLen[left][right] = 2+recursion(left+1,right-1,s);
        return memLen[left][right] = Math.max(recursion(left+1,right,s),recursion(left,right-1,s));
    }
}