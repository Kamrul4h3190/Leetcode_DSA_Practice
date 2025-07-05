public class Leetcode_44 {
    public static void main(String[] args) {
        Leetcode_44 app = new Leetcode_44();
        String s = "aa", p = "?a";
        System.out.println("wildcard match : "+app.isMatch(s,p));
    }
    public boolean isMatch(String s, String p) {
        memMatches = new Boolean[s.length()][p.length()];
        return dynamicMatch(0,0,s,p);
    }
    Boolean[][] memMatches;
    private boolean dynamicMatch(int i, int j, String s, String p){
        if (i>=s.length() && j>=p.length()) return true;//s,p both exhausted, Matched fully.
        if (j>=p.length()) return false;//p exhausted
        if (i>=s.length()){//s exhausted. true if all remaining in p is '*'.else false
            for (int k = j; k < p.length(); k++) if (p.charAt(k) != '*') return false;
            return true;
        }

        if (memMatches[i][j]!=null) return memMatches[i][j];

        if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
            return memMatches[i][j] = dynamicMatch(i+1,j+1,s,p);
        if (p.charAt(j)=='*')
            return memMatches[i][j] = dynamicMatch(i,j+1,s,p) || dynamicMatch(i+1,j,s,p);
        return memMatches[i][j] = false;
    }
}