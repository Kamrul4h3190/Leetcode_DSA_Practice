import java.util.Arrays;

public class Leetcode_486 {
    public static void main(String[] args) {
        Leetcode_486 app = new Leetcode_486();
        int[] nums = {1,5,50,7};
//        int[] nums = {1,5,2};
        System.out.println("winner : "+app.predictTheWinner(nums));
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;    memScores = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(memScores[i],-1);

        return playerOneScore(nums,0,n-1) >= 0;
    }
    int[][] memScores;

    private int playerOneScore(int[] nums, int i, int j) {
        if (i==j) return nums[i];
        if (memScores[i][j]!=-1) return memScores[i][j];

        int takeFirst = nums[i] - playerOneScore(nums,i+1,j);// player 1 scoores nums[i], then p2 turn player1's score will reduce
        int takeLast =  nums[j] - playerOneScore(nums,i,j-1);

        return memScores[i][j] = Math.max(takeFirst,takeLast);
    }
}
