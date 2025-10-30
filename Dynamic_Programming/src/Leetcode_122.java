public class Leetcode_122 {
    public static void main(String[] args) {
        Leetcode_122 app = new Leetcode_122();
        int[] prices = {7,1,5,3,6,4}; int k = 1;
        System.out.println("maximum stock profit : "+app.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        n=prices.length;    memProfit = new Integer[2][n]; //2 row,n col
        return dynamicTrade(0,1,prices); //at day 0, only allowed to buy
    }
    Integer[][] memProfit;  int n;
    private int dynamicTrade(int day,int allowed,int[] prices){ // , allowed to sell:0
        if (day>=n) return 0; // only 1 transaction allowed
        if (memProfit[allowed][day] != null ) return memProfit[allowed][day];

        //state machine dp, Calls will be done based on states
        if (allowed==1){ //allowed to buy:1
            int buy = -prices[day] + dynamicTrade(day+1, 0,prices); //need to invest ,profit will reduce.after buy allowed to sell(0)
            int skip = dynamicTrade(day+1, allowed, prices); //do not buy today
            return memProfit[allowed][day] = Math.max(buy,skip);
        }
        else { //allowed to sell:0
            int sell = prices[day] + dynamicTrade(day+1, 1,prices) ; //sells ,profit will increase.after sell allowed to buy(1)
            int skip = dynamicTrade(day+1, allowed,prices); //do not buy today
            return memProfit[allowed][day] = Math.max(sell,skip);
        }
    }
}