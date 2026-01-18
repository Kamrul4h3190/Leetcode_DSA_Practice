import java.util.Arrays;

public class Leetcode_462 {
    public static void main(String[] args) {
        Leetcode_462 app = new Leetcode_462();
        int[] nums = {1,10,2,9};
        System.out.println("minimum moves : "+app.minMoves2(nums));
    }
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        int median = nums[nums.length/2];//all equalizing to median minimizes difference
        for (int n : nums) moves += Math.abs(n-median);
        return moves;
    }
}