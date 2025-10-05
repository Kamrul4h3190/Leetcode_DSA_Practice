import java.util.ArrayList;

public class Leetcode_10 {
    public static void main(String[] args) {
        Leetcode_10 app = new Leetcode_10();
//        String s = "abb",p = ".b";
//        String s = "a",p = "ab*";
//        String s = "abcd",p = "ay*bcd";
//        String s = "aab",p = "c*a*b";
        String s = "ab",p = ".*";
        System.out.println("regex match : "+app.isMatch(s,p));
    }
    public boolean isMatch(String s, String p) {
        m = s.length(); n = p.length();
        memMatch = new Boolean[m+1][n+1];//+1,memoize finishing cases.
        return dynamicMatch(0,0,s,p);
    }
    Boolean[][] memMatch;   int m,n;
    private boolean dynamicMatch(int i,int j,String s, String p){
        if (i >= m && j >= n) return true;//both string and pattern finished successfully
        if (j>=n) return false;//only pattern finished, String left

        if (memMatch[i][j]!=null) return memMatch[i][j];

        boolean match = i<m && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'); //if i left and match/dot
        if (j+1<n && p.charAt(j+1)=='*'){//if just next to current char is *, we can take/skip *;
            boolean skip_star = dynamicMatch(i,j+2,s,p);
            boolean take_star =  match && dynamicMatch(i+1, j, s, p);
            return memMatch[i][j] = skip_star || take_star;// pattern may match/not match by any decision
        }

        if (match) return memMatch[i][j] = dynamicMatch(i+1, j+1, s, p);//if next is not * , i have no choice , just match current char match or not
        return memMatch[i][j] = false;
    }
}
