import java.util.Arrays;

public class Leetcode_312 {
    public static void main(String[] args) {
        Leetcode_312 app = new Leetcode_312();
        int[] nums = {3,1,5,8};
        System.out.println("maximum balloon coins : "+app.maxCoins(nums));
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;    memLastBalloonCoin = new Integer[n+2][n+2];//+2,just for position mapping memoization
        int[] coins = new int[n+2];     coins[0]=1; coins[coins.length-1]=1; //first and last trivial 1
        for (int i = 1; i <=n; i++) coins[i] = nums[i-1]; //copy nums at coins[1-N]
        return balloonBurstCoin(1,n,coins);
    }
    Integer[][] memLastBalloonCoin; int n; // Time O(n^3)
    private int balloonBurstCoin(int start,int end,int[] coins){ // explore each balloon to burst at last, Before that burst all previous balloons and add their points
        if (start>end) return 0;
        if (memLastBalloonCoin[start][end]!=null) return memLastBalloonCoin[start][end];

        int maxCoin=0;
        for (int middle = start; middle <= end; middle++) {
            maxCoin = Math.max(maxCoin,
                    coins[start-1]*coins[middle]*coins[end+1] +
                    balloonBurstCoin(start,middle-1,coins) + balloonBurstCoin(middle+1,end,coins) );
        }

        return memLastBalloonCoin[start][end] = maxCoin;
    }
}