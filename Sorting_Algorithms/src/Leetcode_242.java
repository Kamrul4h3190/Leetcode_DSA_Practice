import java.util.Arrays;

public class Leetcode_242 {
    public static void main(String[] args) {
        Leetcode_242 sort = new Leetcode_242();
        String s = "anagram",t="nagaram";
        System.out.println(sort.isAnagram(s,t));
    }
    public boolean isAnagram(String s, String t) {
        int m = s.length(),n=t.length();
        if (m!=n) return false;
        char[] sletters = s.toCharArray();
        char[] tletters = t.toCharArray();
        Arrays.sort(sletters);      Arrays.sort(tletters);
        for (int i = 0; i < m; i++) {
            if (sletters[i]!=tletters[i]) return false;
        }
        return true;
    }
}