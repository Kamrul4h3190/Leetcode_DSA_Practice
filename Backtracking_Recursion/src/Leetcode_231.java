public class Leetcode_231 {
    public static void main(String[] args) {
        Leetcode_231 app = new Leetcode_231();
//        int n = 3;
        int n = 16;
        System.out.println("power of : "+app.isPowerOfTwo(n));
    }
    public boolean isPowerOfTwo(int n) {
        if (n==1) return true;
        if (n%2 != 0 || n<=0) return false; //non negatives are not powers of +2

        return isPowerOfTwo(n/2); //power of any number (k) is possible , instead of 2
    }
//    public boolean isPowerOfTwo(int n) { bit manipulation
//        if (n<=0) return false;
//        return (n&(n-1))==0;
//    }
}
