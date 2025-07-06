import java.util.HashMap;

public class Leetcode_494 {
    public static void main(String[] args) {
        Leetcode_494 app = new Leetcode_494();
        int[] nums = {1,1,1,1,1};   int target = 3;
        System.out.println("number of target sum expressions : "+app.findTargetSumWays(nums,target));
    }
    public int findTargetSumWays(int[] nums, int target) {
        memTargetWays = new HashMap<>();
        return ExploreWays(0,0,target,nums);
    }

    HashMap<String,Integer> memTargetWays;
    private int ExploreWays(int i, int sum, int target, int[] nums){
        if (i>= nums.length && sum==target) return 1;//found 1 expression
        if (i>= nums.length) return 0;//nums exhaused, target not matched

        String key = i+"-"+sum;
        if (memTargetWays.containsKey(key)) return memTargetWays.get(key);

        int plus = ExploreWays(i+1, sum+nums[i], target, nums);
        int minus = ExploreWays(i+1, sum-nums[i], target, nums);

        int ways = plus+minus;  memTargetWays.put(key,ways);
        return ways;
    }
}
