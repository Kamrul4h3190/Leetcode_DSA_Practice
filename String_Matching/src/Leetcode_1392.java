import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leetcode_1392 {
    public static void main(String[] args) {
        Leetcode_1392 app = new Leetcode_1392();
        String s = "ababab";
        System.out.println("lps : "+app.longestPrefix(s));
    }
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i<n){
            if (s.charAt(i)==s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else {
                if (len!=0)
                    len = lps[len-1];
                else {
                    i++;
                }
            }
        }
        return s.substring(0, lps[n-1]);
    }
}