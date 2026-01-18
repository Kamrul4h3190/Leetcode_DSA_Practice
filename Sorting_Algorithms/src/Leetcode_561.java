import java.util.Arrays;

public class Leetcode_561 {
    public static void main(String[] args) {
        Leetcode_561 app = new Leetcode_561();
        int[] nums = {1,4,3,2};
        System.out.println("maximized sum : "+app.arrayPairSum(nums));
    }
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for (int i = 0; i < nums.length; i+=2)//skipped 1 positions will contain min number for pairs.add these all
            maxSum += nums[i];
        return maxSum;
    }
}