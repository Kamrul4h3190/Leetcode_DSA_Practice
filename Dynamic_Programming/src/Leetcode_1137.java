import java.util.Arrays;

public class Leetcode_1137 {
    public static void main(String[] args) {
        Leetcode_1137 app = new Leetcode_1137();
        int n = 4;
        System.out.println("N th fib : "+app.tribonacci(n));
    }

    public int tribonacci(int n) {
        memTrib = new int[n+1];
        Arrays.fill(memTrib,-1);
        return dynamicTribonacci(n);
    }
    int[] memTrib;
    private int dynamicTribonacci(int n){
        if (n==0) return 0;
        if (n<=2) return 1;
        if (memTrib[n]!=-1) return memTrib[n];

        return  memTrib[n] = dynamicTribonacci(n-1) + dynamicTribonacci(n-2)+ dynamicTribonacci(n-3);
    }
}