public class Leetcode_123 {
    public static void main(String[] args) {
        Leetcode_123 app = new Leetcode_123();
//        int[] prices = {7,6,4,3,1};
        int[] prices = {3,3,5,0,0,3,1,4}; int k = 2;//k hardcoded
        System.out.println("maximum stock profit : "+app.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        n=prices.length;    memProfit = new Integer[2][n][2]; //2 row,n col,2 transactions
        return dynamicTrade(0,1,0,prices); //at day 0, only allowed to buy
    }
    Integer[][][] memProfit;  int n;
    private int dynamicTrade(int day,int allowed,int trxNo,int[] prices){ // , allowed to sell:0
        if (day>=n || trxNo >= 2) return 0;
        if (memProfit[allowed][day][trxNo] != null ) return memProfit[allowed][day][trxNo];

        //state machine dp, Calls will be done based on states
        if (allowed==1){ //allowed to buy:1
            int buy = -prices[day] + dynamicTrade(day+1, 0, trxNo,prices); //need to invest ,profit will reduce.after buy allowed to sell(0)
            int skip = dynamicTrade(day+1, allowed,trxNo, prices); //do not buy today
            return memProfit[allowed][day][trxNo] = Math.max(buy,skip);
        }
        else { //allowed to sell:0
            int sell = prices[day] + dynamicTrade(day+1, 1, trxNo+1,prices) ; //sells ,profit will increase.fees applicable after selling/buying a stock.after sell allowed to buy(1)
            int skip = dynamicTrade(day+1, allowed, trxNo,prices); //do not buy today
            return memProfit[allowed][day][trxNo] = Math.max(sell,skip);
        }
    }
}