import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_459 {
    public static void main(String[] args) {
        Leetcode_459 app = new Leetcode_459();
//        String s = "cbac", p = "abc";
        String s = "abcabcabcabc";
        System.out.println("build from substring repeat : "+app.repeatedSubstringPattern(s));
    }
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int l = n/2; l >=1 ; l--) {//O(2 sqrt(n))
            if (n%l==0){
                int times = n/l;
                String sub = s.substring(0,l);
                StringBuilder s2 = new StringBuilder();
                while (times-->0)//O(n)
                    s2.append(sub);
                if (s2.toString().equals(s))//O(n)
                    return true;
            }
        }
        return false;
    }
}