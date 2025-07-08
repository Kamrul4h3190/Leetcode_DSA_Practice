import java.util.Arrays;

public class Leetcode_279 {
    public static void main(String[] args) {
        Leetcode_279 app = new Leetcode_279();
        int n = 9;
//        int n = 12;
        System.out.println("minimum perfect squares : "+app.numSquares(n));
    }
    public int numSquares(int n)  {
        int i=1;    while (i*i<n) i= (i+1)*(i+1);//optimized i for memoization array
        memTarget = new int[i+1][n+1];
        for(int[] rows : memTarget) Arrays.fill(rows,-1);

        return minSquares(1,n);
    }
    int[][] memTarget;

    int minSquares(int i, int target) {
        if(target == 0) return 0;
        if(target<i*i) return Integer.MAX_VALUE-1;//-1 to check overflow.

        if (memTarget[i][target]!=-1)return memTarget[i][target];

        int take = i*i <=target ?  1+ minSquares(i,target-i*i) : Integer.MAX_VALUE;//conditional take, do not proceed.explore further possibilities
        int skip = minSquares(i+1,target);//skip . proceed i to exclude from future attempts.

        return memTarget[i][target] = Math.min(take,skip);
    }
}