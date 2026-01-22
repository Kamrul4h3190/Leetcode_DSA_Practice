public class Leetcode_33_V2 {
    public static void main(String[] args) {
        Leetcode_33_V2 app = new Leetcode_33_V2();
        int[] nums = {5,1,3}; int target = 1;
//        int[] nums = {8,9,2,3,4}; int target = 9;
//        int[] nums = {4,5,6,7,8,1,2,3}; int target = 4;
//        int[] nums = {8,9,2,3,4}; int target = 9;
//        int[] nums = {5,1,2,3,4}; int target = 1;
//        int[] nums = {4,5,6,7,0,1,2}; int target = 9;
//        int[] nums = {4,5,6,7,0,1,2}; int target = 3;
//        int[] nums = {4,5,6,7,0,1,2}; int target = 2;
//        System.out.println("max : "+ app.findMin(nums));
        System.out.println("target found at : "+ app.search(nums,target));
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n==1) return nums[0]==target ? 0 : -1;

        int left = 0,right = n-1;
        while (left<right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target) return mid;

            if (target<nums[mid]){
                if (nums[left]<=nums[mid] && target<nums[left])//abnormal case
                    left = mid+1;
                else right = mid;//normal case. find a target at leftHalf
            }
            else if (target>nums[mid]){
                if (nums[mid]<=nums[right] && target>nums[right])//abnormal case
                    right = mid;
                else left = mid+1;//normal case,find a target at rightHalf
            }
        }
        return nums[left]==target ? left : -1 ;
    }
}