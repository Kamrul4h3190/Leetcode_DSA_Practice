import java.util.HashSet;

public class Leetcode_214 {
    public static void main(String[] args) {
        Leetcode_214 app = new Leetcode_214();
        String s = "abcd";
        System.out.println("shortest palindrome : "+app. shortestPalindrome(s));
    }
    long base = 29;
    long mod = (long) 1e9+7;
    public String shortestPalindrome(String s) {
        long forwardHash=0,backwardHash=0;
        long power=1;
        int index=-1;
        for (int i = 0; i < s.length(); i++) {//find the longest palindrome prefix from S
            char ch = s.charAt(i);
            forwardHash = (forwardHash*base + ch)%mod;// Simply generate the forward and
            backwardHash = (backwardHash + ch*power)%mod;// backward number
            power = (power*base)%mod;

            if (forwardHash==backwardHash)  index = i;
        }
        String remaining = s.substring(index+1);
        StringBuilder reversed = new StringBuilder(remaining).reverse();

        return reversed.append(s).toString();
    }
}