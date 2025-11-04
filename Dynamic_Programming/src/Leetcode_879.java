public class Leetcode_879 {
    public static void main(String[] args) {
        Leetcode_879 app = new Leetcode_879();
//        int[] group = {2,3,5},profit ={6,7,8};  int n=10,minProfit=5;
        int[] group = {2,2},profit ={2,3};  int n=5,minProfit=3;
        System.out.println("profitable schemes : "+app.profitableSchemes(n,minProfit,group,profit));
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        crimes = profit.length;     memProfits = new Integer[crimes][n+1][minProfit+1];
        return knapSack(0,0,0,n,minProfit,group,profit);
    }
    Integer[][][] memProfits;   int crimes;  int mod = (int)1e9+7;
    private int knapSack(int idx,int people,int schemeProfit,int n,int minProfit,int[] group,int[] profit){
        if (people>n) return 0; //cant take more than n people,no way
        if (idx==crimes) return schemeProfit>=minProfit ? 1:0;  //crimes exhausted alogn this path , if minprofit achieved 1 way found,else 0
        if (memProfits[idx][people][schemeProfit]!=null) return memProfits[idx][people][schemeProfit];

        int take = knapSack(idx+1, people+group[idx], Math.min(minProfit,schemeProfit+profit[idx]), n, minProfit, group, profit);
        int skip = knapSack(idx+1, people, schemeProfit, n, minProfit, group, profit);
        return memProfits[idx][people][schemeProfit] = (take+skip)%mod;
    }
}