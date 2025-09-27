public class Leetcode_866 {
    public static void main(String[] args) {
        Leetcode_866 app = new Leetcode_866();
        int n = 1;
//        System.out.println("isPrime : "+app.isPrime(n));
//        System.out.println("isPalindrome : "+app.isPalindrome(n));

        System.out.println("min Prime Palindrome : "+app.primePalindrome(n));
    }
    public int primePalindrome(int n) {
        while (true){
            if (isPrime(n) && isPalindrome(n)) return n;
            n++;
            if (10_000_000 < n && n < 100_000_000) n = 100_000_000; //number gets big, reduce it
        }
    }
    private boolean isPrime(int n){
        if(n<2) return false;
        for (int i = 2; i*i <= n ; i++) {
            if (n%i==0) return false;
        }
        return true;
    }
    private boolean isPalindrome(int n){
        String numString = new String(String.valueOf(n));
        int i=0,j=numString.length()-1;
        while (i<j){
            if (numString.charAt(i)!=numString.charAt(j)) return false;
            i++;    j--;
        }
        return true;
    }
}
