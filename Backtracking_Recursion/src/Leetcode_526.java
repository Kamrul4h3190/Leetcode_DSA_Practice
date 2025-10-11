public class Leetcode_526 {
    public static void main(String[] args) {
        Leetcode_526 app = new Leetcode_526();
//        int n = 10;
//        int n = 11;
        int n = 3;
        System.out.println("beautiful arrangements : "+app.countArrangement(n));
    }
    int result = 0;
    public int countArrangement(int n) {
        currPerm = new int[n+1];
        permutation(1,n);
        return result;
    }
    int[] currPerm;

    void permutation(int k, int n) {//generating all permutations will overflow, generate only valid permutations
        if(k > n){// n number of valid number has formed a permutation
            result++;
            return;
        }

        for(int i = 1; i <= n; i++) {
            if (currPerm[i] != 0) continue;
            if(k%i==0 || i%k==0){//entry valid numbers only.
                currPerm[i] = k;
                permutation(k+1, n);
                currPerm[i] = 0;
            }
        }
    }
}

