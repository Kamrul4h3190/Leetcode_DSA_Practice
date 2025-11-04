import java.util.*;

public class Leetcode_1049 {
    public static void main(String[] args) {
        Leetcode_1049 app = new Leetcode_1049();
//        int[] stones = {2,7,4,1,8,1};
        int[] stones = {31,26,33,21,40};
        System.out.println("last stone weight : "+app.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        totalSum = 0;   for (int w : stones) totalSum+=w;
        int halfSum = (int) Math.ceil(totalSum/2.0);
        n=stones.length;    memWeights = new Integer[n][halfSum];
        return knapSack(0,0,halfSum,stones);
    }
    Integer[][] memWeights;  int n; int totalSum;
    private int knapSack(int i,int halfSum,int halfTarget,int[] stones){
        if (halfSum>=halfTarget || i>=n) return Math.abs(halfSum-(totalSum-halfSum));
        if (memWeights[i][halfSum]!=null) return memWeights[i][halfSum];

        int take = knapSack(i+1, halfSum+stones[i], halfTarget,stones);
        int skip = knapSack(i+1, halfSum, halfTarget, stones);
        return memWeights[i][halfSum] = Math.min(take,skip);
    }
}