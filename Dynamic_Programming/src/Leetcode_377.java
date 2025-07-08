import java.util.Arrays;

public class Leetcode_377 {
    public static void main(String[] args) {
        Leetcode_377 app = new Leetcode_377();
        int[] nums = {1,2,3};int target = 4;
        System.out.println("number of ways to change target : "+app.combinationSum4(nums,target));
    }

    public int combinationSum4(int[] nums, int target) {
        memPermutation = new int[nums.length][target+1];
        for(int[] rows : memPermutation) Arrays.fill(rows,-1);
        return countPermutations(0,target,nums);
    }
    int[][] memPermutation;

    int countPermutations(int i, int target, int[] nums) {
        if(target == 0) return 1;
        if(i>= nums.length || target<0 ) return 0;

        if (memPermutation[i][target]!=-1)return memPermutation[i][target];

        int take = countPermutations(0,target-nums[i],nums);//for all combine all, select i, then again select all from 0 .
        int skip = countPermutations(i+1,target,nums);//skip . proceed i to exclude current number from future attempts.

        return memPermutation[i][target] = take+skip;
    }
}