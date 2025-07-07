import java.util.Arrays;

public class Leetcode_518 {
    public static void main(String[] args) {
        Leetcode_518 app = new Leetcode_518();
        int[] coins = {1,2,5};int amount = 5;
        System.out.println("number of ways to change target : "+app.change(amount,coins));
    }
    public int change(int amount, int[] coins) {
        memAmount = new int[coins.length][amount+1];//target may achieve in intermediate positions also.Not always after exhaustion
        for(int[] rows : memAmount) Arrays.fill(rows,-1);
        return countCombinations(0,amount,coins);
    }
    int[][] memAmount;

    int countCombinations(int i,int amount,int[] coins) {
        if(amount == 0) return 1;
        if(i >= coins.length ) return 0;

        if (memAmount[i][amount]!=-1)return memAmount[i][amount];

        int take = coins[i]<=amount?  countCombinations(i,amount-coins[i],coins) : 0;//conditional take, do not proceed.explore further possibilities
        int skip = countCombinations(i+1,amount,coins);//skip . proceed i to exclude current coin from future attempts.

        return memAmount[i][amount] = take+skip;
    }
}