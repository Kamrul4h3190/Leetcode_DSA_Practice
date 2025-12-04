import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode_704 {
    public static void main(String[] args) {
        Leetcode_704 app = new Leetcode_704();
        int[] nums = {-1,0,3,5,9,12}; int target = 13;
        System.out.println("target found at index : "+app.search(nums,target));
    }
    public int search(int[] nums, int target) {
        int l=0; int r = nums.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid]==target) return mid;

            if (nums[mid] < target) l=mid+1;
            else r = mid-1;
        }
        return -1;// not found
    }
}