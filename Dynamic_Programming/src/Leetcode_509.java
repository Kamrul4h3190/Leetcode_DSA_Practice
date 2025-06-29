import java.util.Arrays;

public class Leetcode_509 {
    public static void main(String[] args) {
        Leetcode_509 app = new Leetcode_509();
        int n = 4;
        System.out.println("N th fib : "+app.fib(n));
    }

    public int fib(int n) {
        memFib = new int[n+1];
        Arrays.fill(memFib,-1);
        return dynamicFib(n);
    }
    int[] memFib;
    private int dynamicFib(int n){
        if (n<=1) return n;
        if (memFib[n]!=-1) return memFib[n];

        return memFib[n]=dynamicFib(n-1)+dynamicFib(n-2);
    }
}