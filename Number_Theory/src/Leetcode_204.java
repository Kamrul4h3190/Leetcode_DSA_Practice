public class Leetcode_204 {
    public static void main(String[] args) {
        Leetcode_204 app = new Leetcode_204();
        int n = 10;
        System.out.println("count primes : "+app.countPrimes(n));
    }
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] composite = new boolean[n];
        for (int i = 2; i <= Math.sqrt(n); i++) { //no need to check upto n-1. sqrt(n) is enough
            if (composite[i]==false){ //mark multiples of composites.
                for (int j = i*i; j < n; j+=i)
                    composite[j] = true;
            }
        }

        int primes = 0; //non composites are primes. count them
        for (int i = 2; i < n; i++) if (composite[i]==false) primes++;
        return primes;
    }
}
