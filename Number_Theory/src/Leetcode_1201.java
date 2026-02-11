public class Leetcode_1201 {
    public static void main(String[] args) {
        Leetcode_1201 app = new Leetcode_1201();
//        int[] coins = {6,1,2,4};int k=4;
        int n = 3, a = 2, b = 3, c = 5;
//        int n = 4, a = 2, b = 3, c = 4;
//        int n = 5, a = 2, b = 11, c = 13;
        System.out.println("K th ugly number: "+app.nthUglyNumber(n,a,b,c));
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] coins = new int[]{a,b,c};
        return findKthSmallest(coins,n);//leetcode 3116
    }

    public int findKthSmallest(int[] coins, int k) {
        int left = 1,right= (int) 2e9;    int N = coins.length;
        int prevNums = (int) right;
        while(left <= right)//minimize the answer through binary search
        {
            int mid = left + (right - left)/2;
            int times = getKPrevNums(coins, N, mid, k);
            if(times == k)
                prevNums = mid;//we can not return an intermediate match. we should search the minimum match that's why do not stop after a match
            if(times < k)
                left = mid + 1;
            else
                right = mid -1;
        }
        return prevNums;
    }
    private int getKPrevNums(int[] coins, int N, int tar, int k)
    {
        int prevNums = 0;
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
                prevNums += (int) (tar/lcm);
            else
                prevNums -= (int) (tar/lcm);//subtract for even number of elements
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