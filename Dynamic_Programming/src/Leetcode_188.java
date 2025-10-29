import java.util.Arrays;

public class Leetcode_188 {
    public static void main(String[] args) {
        Leetcode_188 app = new Leetcode_188();
//        int[] prices = {7,6,4,3,1};
        int[] prices = {3,2,6,5,0,3}; int k = 2;
        System.out.println("maximum stock profit : "+app.maxProfit(k,prices));
    }

    public int maxProfit(int k,int[] prices) {
        n=prices.length;    memProfit = new Integer[2][n][k]; //2 row,n col,k transactions
        return dynamicTrade(0,1,0,k,prices); //at day 0, only allowed to buy
    }
    Integer[][][] memProfit;  int n;
    private int dynamicTrade(int day,int allowed,int trxNo,int k,int[] prices){ // , allowed to sell:0
        if (day>=n || trxNo >= k) return 0;
        if (memProfit[allowed][day][trxNo] != null ) return memProfit[allowed][day][trxNo];

        //state machine dp, Calls will be done based on states
        if (allowed==1){ //allowed to buy:1
            int buy = -prices[day] + dynamicTrade(day+1, 0, trxNo,k,prices); //need to invest ,profit will reduce.after buy allowed to sell(0)
            int skip = dynamicTrade(day+1, allowed,trxNo,k, prices); //do not buy today
            return memProfit[allowed][day][trxNo] = Math.max(buy,skip);
        }
        else { //allowed to sell:0
            int sell = prices[day] + dynamicTrade(day+1, 1, trxNo+1,k,prices) ; //sells ,profit will increase.fees applicable after selling/buying a stock.after sell allowed to buy(1)
            int skip = dynamicTrade(day+1, allowed, trxNo,k,prices); //do not buy today
            return memProfit[allowed][day][trxNo] = Math.max(sell,skip);
        }
    }
}