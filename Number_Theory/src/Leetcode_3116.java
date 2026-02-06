public class Leetcode_3116 {
    public static void main(String[] args) {
        Leetcode_3116 app = new Leetcode_3116();
//        int[] coins = {6,1,2,4};int k=4;
        int[] coins = {7,2};int k=2;
//        int[] coins = {3,6,9};int k=3;
//        int[] coins = {3,6,9};int k=3;
        System.out.println("K th smallest amount with single coin: "+app.findKthSmallest(coins,k));
    }

    public long findKthSmallest(int[] coins, int k) {
        long left = 1,right=0;    int N = coins.length;
        for (long coin : coins)
            right = Math.max(right,coin);
        right *= k;
        long prevNums = right;
        while(left <= right)//minimize the answer through binary search
        {
            long mid = left + (right - left)/2L;
            long times = getKPrevNums(coins, N, mid, k);
            if(times == k)
                prevNums = mid;//we can not return an intermediate match. we should search the minimum match that's why do not stop after a match
            if(times < k)
                left = mid + 1;
            else
                right = mid -1;
        }
        return prevNums;
    }
    private long getKPrevNums(int[] coins, int N, long tar, int k)
    {
        long prevNums = 0;
        // inclusion exclusion on coins subsets
        int num_subsets = (1<<N) - 1;//2^n-1 subsets
        for(int mask = 1; mask <= num_subsets; mask++)//generate subsets by bitmasking
        {
            int subsetLen = 0;
            long lcm = 1;
            for(int bit = 0; bit < N; bit++)
            {
                if( (mask>>bit&1) == 1 )//checking if the i th coin taken
                {
                    subsetLen ++;
                    lcm = lcm(lcm, coins[bit]);
                }
            }
            if((subsetLen &1)  == 1)//add for odd number of elements
                prevNums += tar/lcm;
            else
                prevNums -= tar/lcm;//subtract for even number of elements
        }
        return prevNums;
    }
    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    long lcm(long a, long b) {
        return a * (b/ gcd(a, b));//product may overflow, make a division first
    }
}