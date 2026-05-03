import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leetcode_3031 {
    public static void main(String[] args) {
        Leetcode_3031 app = new Leetcode_3031();
        String word = "abacaba";int k = 3;
        System.out.println("minimum revert time : "+app.minimumTimeToInitialState(word,k));
    }
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int[] lps = fillLPS(word);
        int maxSuffix = lps[n-1];

        while ( maxSuffix>0 && (n-maxSuffix)%k!=0 )
            maxSuffix = lps[maxSuffix-1];//reduce maxsuffix within k

        if ((n-maxSuffix)%k==0)//properly chunk match
            return (n-maxSuffix)/k;

        return Math.ceilDiv(n,k);//no match ,slide all chunks
    }

    private int[] fillLPS(String pattern){
        int[] lps = new int[pattern.length()];
        int m = pattern.length();
        int len=0;
        int i = 1;
        while (i<m){
            if (pattern.charAt(i)==pattern.charAt(len)){
                lps[i] = ++len;
                i++;
            }else {
                if (len!=0)
                    len = lps[len-1];
                else i++;
            }
        }
        return lps;
    }
}