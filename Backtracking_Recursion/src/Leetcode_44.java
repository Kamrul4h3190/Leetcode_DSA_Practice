public class Leetcode_44 {
    public static void main(String[] args) {
        Leetcode_44 app = new Leetcode_44();
//        String s = "abb",p = ".b";
//        String s = "a",p = "ab*";
//        String s = "abcd",p = "ay*bcd";
//        String s = "aab",p = "c*a*b";
//        String s = "ab",p = "?*";
        String s = "cb",p = "*";
//        String s = "acdcb",p = "a*c?b";
        System.out.println("wildcard match : "+app.isMatch(s,p));
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

        if (i >= m){ //string finished. if remaining pattern is all * then true, else false
            for (int a = j; a < n; a++) if (p.charAt(a)!='*') return false;
            return true;
        }

        if (memMatch[i][j]!=null) return memMatch[i][j];

        if (p.charAt(j) == '*'){//if current char is *, we can take/skip *;
            boolean skip_star = dynamicMatch(i,j+1,s,p);
            boolean take_star = dynamicMatch(i+1, j, s, p);
            return memMatch[i][j] = skip_star || take_star;// pattern may match/not match by any decision
        }

        boolean match = s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'; //match/?
        if (match) return memMatch[i][j] = dynamicMatch(i+1, j+1, s, p);//if current char is not * , i have no choice , just match current char match or not
        return memMatch[i][j] = false;// not match, return false
    }
}
