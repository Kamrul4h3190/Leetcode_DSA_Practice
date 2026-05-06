import java.util.ArrayList;
import java.util.List;

public class Leetcode_3008 {
    public static void main(String[] args) {
        Leetcode_3008 app = new Leetcode_3008();
        String s = "onwawarwa", a = "wa", b = "r";int k = 2;
//        String s = "abcd", a = "a", b = "b";int k = 4;
//        String s = "isawsquirrelnearmysquirrelhouseohmy", a = "my", b = "squirrel";int k = 15;
        System.out.println("Beautiful indices :"+app.beautifulIndices(s,a,b,k));
    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> AIndices = searchPattern(s,a);
        List<Integer> BIndices = searchPattern(s,b);

        List<Integer> beautifuls = new ArrayList<>();
        int sizeA=AIndices.size(),sizeB = BIndices.size();
        for (int i = 0, j=0; i < sizeA ; i++) {
            while (j<sizeB && AIndices.get(i)>BIndices.get(j) && Math.abs( AIndices.get(i)-BIndices.get(j) ) > k) j++;
            if (j<sizeB && Math.abs( AIndices.get(i)-BIndices.get(j))<= k )beautifuls.add(AIndices.get(i));
        }

        return beautifuls;
    }
    private List<Integer> searchPattern(String s, String pattern){
        List<Integer> foundIndices = new ArrayList<>();
        int[] lps = fillLPS(pattern);

        int i = 0, j = 0, m = pattern.length();
        //KMP
        while (i < s.length()) {
            if (s.charAt(i) == pattern.charAt(j)) {//matched
                i++;    j++;

                if (j == m) { // pattern matched
                    foundIndices.add(i-m);
                    j = lps[j - 1];//reset j for finding next occurrences of pattern
                }
            } else {//Not matched
                if (j != 0)
                    j = lps[j - 1];
                else i++;
            }
        }

        return foundIndices;
    }
    private int[] fillLPS(String pattern){
        int m = pattern.length();
        int[] lps = new int[m];
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