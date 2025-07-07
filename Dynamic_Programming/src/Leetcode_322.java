import java.util.Arrays;

public class Leetcode_322 {
    public static void main(String[] args) {
        Leetcode_322 app = new Leetcode_322();
        int[] coins = {1,2,5};int amount = 11;
        System.out.println("minimum coins to change amount : "+app.coinChange(coins,amount));
    }
    public int coinChange(int[] coins, int amount) {
        memAmount = new int[coins.length][amount+1];//amount may achieve in intermediate positions also.Not always after exhaustion
        for(int[] rows : memAmount) Arrays.fill(rows,-1);

        int minCoins = dynamicChange(0,amount,coins);
        return minCoins==Integer.MAX_VALUE-1 ? -1:minCoins;
    }
    int[][] memAmount;

    int dynamicChange(int i, int amount, int[] coins) {
        if(amount == 0) return 0;
        if(i >= coins.length ) return Integer.MAX_VALUE-1;//-1 to check overflow.

        if (memAmount[i][amount]!=-1)return memAmount[i][amount];

        int take = coins[i]<=amount?  1+ dynamicChange(i,amount-coins[i],coins) : Integer.MAX_VALUE;//conditional take, do not proceed.explore further possibilities
        int skip = dynamicChange(i+1,amount,coins);//skip . proceed i to exclude current coin from future attempts.

        return memAmount[i][amount] = Math.min(take,skip);
    }
}