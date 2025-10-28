import java.util.*;

public class Leetcode_309 {
    public static void main(String[] args) {
        Leetcode_309 app = new Leetcode_309();
        int[] prices = {1,2,3,0,2};
        System.out.println("maximum stock profit : "+app.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        n=prices.length;    memProfit = new int[2][n]; //2 row,n col
        for (int[] row : memProfit) Arrays.fill(row, -1);
        return dynamicTrade(0,1,prices); //at day 0, only allowed to buy
    }
    int[][] memProfit;  int n;
    private int dynamicTrade(int day,int allowed,int[] prices){
        if (day>=n) return 0;
        if (memProfit[allowed][day] !=-1 ) return memProfit[allowed][day];

        //state machine dp, Calls will be done based on states
        if (allowed==1){ //allowed to buy:1
            int buy = -prices[day] + dynamicTrade(day+1, 0, prices); //need to invest ,profit will reduce.after buy allowed to sell(0)
            int skip = dynamicTrade(day+1, allowed, prices); //do not buy today
            return memProfit[allowed][day] = Math.max(buy,skip);
        }
        else { //allowed to sell:0
            int sell = prices[day] + dynamicTrade(day+2, 1, prices); //sells ,profit will increase.+2 cooldown.after sell allowed to buy(1)
            int skip = dynamicTrade(day+1, allowed, prices); //do not sell today
            return memProfit[allowed][day] = Math.max(sell,skip);
        }
    }
}