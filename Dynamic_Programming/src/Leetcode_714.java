import java.util.Arrays;

public class Leetcode_714 {
    public static void main(String[] args) {
        Leetcode_714 app = new Leetcode_714();
//        int[] prices = {7,6,4,3,1};
        int[] prices = {1,3,2,8,4,9}; int fee = 2;
        System.out.println("maximum stock profit : "+app.maxProfit(prices,fee));
    }

    public int maxProfit(int[] prices,int fee) {
        n=prices.length;    memProfit = new int[2][n]; //2 row,n col
        for (int[] row : memProfit) Arrays.fill(row, -1);
        return dynamicTrade(0,1,fee,prices); //at day 0, only allowed to buy
    }
    int[][] memProfit;  int n;
    private int dynamicTrade(int day,int allowed,int fee,int[] prices){ // , allowed to sell:0
        if (day>=n) return 0;
        if (memProfit[allowed][day] !=-1 ) return memProfit[allowed][day];

        //state machine dp, Calls will be done based on states
        if (allowed==1){ //allowed to buy:1
            int buy = -prices[day] + dynamicTrade(day+1, 0, fee,prices); //need to invest ,profit will reduce.after buy allowed to sell(0)
            int skip = dynamicTrade(day+1, allowed,fee, prices); //do not buy today
            return memProfit[allowed][day] = Math.max(buy,skip);
        }
        else { //allowed to sell:0
            int sell = prices[day] + dynamicTrade(day+1, 1, fee,prices) - fee ; //sells ,profit will increase.fees applicable after selling/buying a stock.after sell allowed to buy(1)
            int skip = dynamicTrade(day+1, allowed, fee,prices); //do not buy today
            return memProfit[allowed][day] = Math.max(sell,skip);
        }
    }

//    private int dynamicTrade(int day,int allowed,int fee,int[] prices){ //using single skip call
//        if (day>=n) return 0;
//        if (memProfit[allowed][day] !=-1 ) return memProfit[allowed][day];
//
//        int buy=0,sell=0;
//        if (allowed==1) //allowed to buy:1
//            buy = -prices[day] + dynamicTrade(day+1, 0, fee,prices); //need to invest ,profit will reduce.after buy allowed to sell(0)
//        else  //allowed to sell:0
//            sell = prices[day] + dynamicTrade(day+1, 1, fee,prices) - fee ; //sells ,profit will increase.fees applicable after selling/buying a stock.after sell allowed to buy(1)
//        int skip = dynamicTrade(day+1, allowed,fee, prices); //do not buy today
//
//        return memProfit[allowed][day] = Math.max(skip,Math.max(buy,sell));
//    }
}