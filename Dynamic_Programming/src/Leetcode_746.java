import java.util.Arrays;

public class Leetcode_746 {
    public static void main(String[] args) {
        Leetcode_746 app = new Leetcode_746();
        int[] cost = {10,15,20};
        System.out.println("min cost : "+app.minCostClimbingStairs(cost));
    }

    int[] memCost;
    public int minCostClimbingStairs(int[] cost) {
        memCost = new int[cost.length]; // Memoization array
        Arrays.fill(memCost,-1);
        return Math.min(minCost(0, cost), minCost(1, cost));
    }

    private int minCost(int i,int[] cost) {
        if(i>=cost.length) return 0;
        if (memCost[i]!=-1) return memCost[i];

        int oneJump = cost[i] + minCost(i+1,cost);
        int twoJump = cost[i] + minCost(i+2,cost);

        return memCost[i] = Math.min(oneJump,twoJump);
    }
}