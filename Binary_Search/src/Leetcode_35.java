import java.util.Arrays;

public class Leetcode_35 {
    public static void main(String[] args) {
        Leetcode_35 app = new Leetcode_35();
        int[] nums = {1,3,5,6}; int target = 7;
//        int[] nums = {1,3,5,6}; int target = 5;
        System.out.println("nums[lowerBound] : "+ app.searchInsert(nums,target));
    }
    public int searchInsert(int[] nums, int target) {
        return lowerBound(nums,target);
    }
    public int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int left=0; int right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]>=target) //occurrence >= target . left boundary of a range
                right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}