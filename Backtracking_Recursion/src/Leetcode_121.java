public class Leetcode_121 {
    public static void main(String[] args) {
        Leetcode_121 app = new Leetcode_121();
//        int[] nums = {1,2,3};
        int[] prices = {7,1,5,3,6,4};
        System.out.println("maximum stock profit : "+ app.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        maxProfit = 0;
        findMaxProfits(0,Integer.MAX_VALUE,0,prices);
        return maxProfit;
    }
    int maxProfit;
    private void findMaxProfits(int day,int buyPrice, int buyDay,int[] prices){
        if (day==prices.length) return;

        if (prices[day] < buyPrice){
            buyPrice = prices[day];
            buyDay = day;
        }
        findMaxProfits(day+1,buyPrice,buyDay,prices); //in the growing phase : update minimum buying price

        if (day>buyDay) maxProfit = Math.max( maxProfit, prices[day]-buyPrice ); //in the backtracking phase: maximize profit
    }
}

