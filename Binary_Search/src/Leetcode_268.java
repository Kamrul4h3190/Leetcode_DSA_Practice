import java.util.Arrays;

public class Leetcode_268 {
    public static void main(String[] args) {
        Leetcode_268 app = new Leetcode_268();
        int[] nums = {3,0,1};
        System.out.println("missing number : "+app.missingNumber(nums));
    }
    int missingNumber(int[] nums) {
        Arrays.sort(nums); //sort to perform binary search
        int left = 0;   int right = nums.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (nums[mid]>mid)
                right = mid-1;
            else left = mid+1; //if (nums[mid]==mid) that means missing number is in right half
        }
        return left;//left is the missing number
    }
}