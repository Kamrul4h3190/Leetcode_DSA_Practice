public class Leetcode_300 {
    public static void main(String[] args) {
        Leetcode_300 app = new Leetcode_300();
//        int[] group = {2,3,5},profit ={6,7,8};  int n=10,minProfit=5;
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("length of LIS : "+app.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        n = nums.length;    memLISLength = new Integer[n][n+1];
        return findLength(0,-1,nums);
    }
    Integer[][] memLISLength;   int n;
    private int findLength(int curr,int prev,int[] nums){
        if (curr==n) return 0;
        if (memLISLength[curr][prev+1]!=null) return memLISLength[curr][prev+1]; //-1 will be memoized in index -1+1=0

        int takeInLIS = (prev==-1 || nums[curr]>nums[prev]) ? 1+findLength(curr+1, curr, nums) : 0;
        int skip = findLength(curr+1, prev, nums);

        return memLISLength[curr][prev+1] = Math.max(takeInLIS,skip);
    }
}