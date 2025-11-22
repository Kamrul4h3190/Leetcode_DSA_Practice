public class Leetcode_53 {
    public static void main(String[] args) {
        Leetcode_53 app = new Leetcode_53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("max rectangle : "+ app.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        n = nums.length; memLocalMax = new Integer[n];
        globalMax = nums[0];
        findGlobalMaxSum(0,nums);
        return globalMax;
    }
    int globalMax;
    Integer[] memLocalMax; int n;
    private int findGlobalMaxSum(int i, int[] nums){
        if (i==n) return 0;
        if (memLocalMax[i]!=null) return memLocalMax[i];

        int localMax = Math.max(nums[i] , nums[i]+ findGlobalMaxSum(i+1,nums) ); //update globalMax during backtracking. Starting from here calculate what is local maxSum

        globalMax = Math.max(globalMax,localMax);//just update this, no need to memoize

        return memLocalMax[i] = localMax;
    }
}