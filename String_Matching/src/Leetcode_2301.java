import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leetcode_2301 {
    public static void main(String[] args) {
        Leetcode_2301 app = new Leetcode_2301();
        String s = "aki1r", sub = "ki1j";char[][] mappings = {{'k','a'},{'i','k'},{'j','r'}};
//        String s = "fool3e7bar", sub = "leet";char[][] mappings = {{'e','3'},{'t','7'},{'t','8'}};
        System.out.println("pattern found after replacement: "+app.matchReplacement(s,sub,mappings));
    }
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        int n = s.length(),m = sub.length();
        Map<Character, HashSet<Character>> map = new HashMap<>();
        for (char[] relation : mappings) {
            char key = relation[1];
            char val = relation[0];
            if (!map.containsKey(key))
                map.put(key,new HashSet<>());
            map.get(key).add(val);
        }

        int[] lps = fillLPS(sub);
        for (int p = 0; p < n; p++) { // O(n*(n+m))

            int i=p,j=0;
            while(i < n){
                if(s.charAt(i) == sub.charAt(j) || map.containsKey(s.charAt(i)) && map.get(s.charAt(i)).contains(sub.charAt(j))){
                    i++;    j++;
                }else {//Not matched
                    if (j != 0)
                        j = lps[j - 1];
                    else i++;
                }

                if (j==m) return true;
            }
        }

        return false;
    }

    private int[] fillLPS(String pattern){
        int[] lps = new int[pattern.length()];
        int m = pattern.length();
        int len=0;
        int i = 1;
        while (i<m){
            if (pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i] = len;
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