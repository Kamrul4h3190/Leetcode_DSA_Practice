import java.util.Arrays;

public class Leetcode_132 {
    public static void main(String[] args) {
        Leetcode_132 app = new Leetcode_132();
        String s = "aaabaa";
//        String s = "aab";
        System.out.println("min cuts : "+app.minCut(s));
    }
    public int minCut(String s) {
        memPartitions = new int[s.length()][s.length()];
        for (int[] row:memPartitions) Arrays.fill(row,-1);
        return dynamicCut(0,s.length()-1,s);
    }
    int[][] memPartitions;
    private int dynamicCut(int i, int j, String s){
        if (i>=j || isPalindrome(i,j,s)) return 0;//palindrome, 0 partition required
        if (memPartitions[i][j]!=-1) return memPartitions[i][j];

        int minCut = Integer.MAX_VALUE;
        for (int k = i; k <j ; k++) {
            if (isPalindrome(i,k,s))//if left part is palindrome, check after wards and update min;
                minCut =Math.min(minCut, 1 + dynamicCut(k+1,j,s) );
        }
        return memPartitions[i][j] = minCut;
    }

    private boolean isPalindrome(int i,int j,String s){
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}