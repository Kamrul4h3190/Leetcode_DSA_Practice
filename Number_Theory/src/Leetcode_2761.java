import java.util.ArrayList;
import java.util.List;

public class Leetcode_2761 {
    public static void main(String[] args) {
        Leetcode_2761 app = new Leetcode_2761();
        int n = 10;
        System.out.println("target sum prime pairs : "+app.findPrimePairs(n));
//        System.out.println("count primes : "+app.findPrimes(n,new ArrayList<>()));
    }
    public List<List<Integer>> findPrimePairs(int n) {
        List<Integer> primes = findPrimes(n,new ArrayList<>());

        List<List<Integer>> targetSumPairs = new ArrayList<>();
        int i = 0, j = primes.size()-1;
        while (i<=j){
            if (primes.get(i)+primes.get(j)==n){
                List<Integer> pair = new ArrayList<>();
                pair.add(primes.get(i));    pair.add(primes.get(j));
                targetSumPairs.add(pair);
                i++; j--;
            }
            else if (primes.get(i)+primes.get(j)<n) i++;
            else j--;
        }

        return targetSumPairs;
    }
    private List<Integer> findPrimes(int n, ArrayList<Integer> primes) {
        if(n==1) return primes;
        boolean[] composite = new boolean[n+1];//all false initially
        for (int i = 2; i*i <= n; i++) {//no need to check upto n-1. sqrt(n) is enough
            if (!composite[i]){//this is a non composite, mark multiples of this.
                for (int j = i*i; j <= n; j+= i) {
                    composite[j] = true;
                }
            }
        } //after marking all the  composites, all non composites are primes
        for (int i = 2; i < n; i++) if (!composite[i]) primes.add(i);
        return primes;
    }
}
