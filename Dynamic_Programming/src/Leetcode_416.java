import java.util.HashMap;

public class Leetcode_416 {
    public static void main(String[] args) {
        Leetcode_416 app = new Leetcode_416();
        int[] nums = {3,3,6,8,16,16,16,18,20};
//        int[] nums = {1,5,11,5};
        System.out.println("subset sum partition : "+app.canPartition(nums));
    }
    public boolean canPartition(int[] nums) {
        int sum=0;  for (int num : nums) sum+=num;
        memPartition = new Boolean[nums.length][sum];
        if (sum%2!=0) return false;

        int halfSum = sum/2;
        return dynamicPartition(0,0,halfSum,nums);
    }

    Boolean[][] memPartition;
    private boolean dynamicPartition(int i,int sum,int halfSum,int[] nums){
        if(i>= nums.length) return false;
        if(sum>halfSum) return false;
        if(sum==halfSum) return true;

        if (memPartition[i][sum]!=null) return memPartition[i][sum];

        boolean take = dynamicPartition(i+1, sum+nums[i], halfSum, nums);
        boolean skip = dynamicPartition(i+1, sum, halfSum, nums);

        return memPartition[i][sum] = take||skip;
    }
}
