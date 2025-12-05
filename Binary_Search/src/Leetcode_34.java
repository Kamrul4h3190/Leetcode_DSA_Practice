import java.util.Arrays;

public class Leetcode_34 {
    public static void main(String[] args) {
        Leetcode_34 app = new Leetcode_34();
        int[] nums = {5,7,7,8,8,10}; int target = 8;
        System.out.println("first and last index of target : "+ Arrays.toString(app.searchRange(nums, target)));
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0) return new int[]{-1,-1};// size 0
        if (target<nums[0] || target>nums[nums.length-1]) return new int[]{-1,-1}; //beyond range

        int leftBoundary = lowerBound(nums,target);
        int rightBoundary = upperBound(nums,target) - 1;
        if (nums[leftBoundary]!=target) return new int[]{-1,-1};//not found

        return new int[]{leftBoundary,rightBoundary};
    }
    public int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int left=0; int right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]>=target) //first occurrence >= target . left boundary of a range
                right = mid-1;
            else left = mid+1;
        }
        return left;
    }
    public int upperBound(int[] nums, int target) {
        int n = nums.length;
        int left=0; int right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]>target)//first occurrence > target . right+1 boundary of a range
                right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}