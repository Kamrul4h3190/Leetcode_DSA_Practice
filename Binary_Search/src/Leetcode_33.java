public class Leetcode_33 {
    public static void main(String[] args) {
        Leetcode_33 app = new Leetcode_33();
        int[] nums = {4,5,6,7,0,1,2}; int target = 1;
//        int[] nums = {4,5,6,7,0,1,2}; int target = 3;
//        int[] nums = {4,5,6,7,0,1,2}; int target = 0;
//        System.out.println("max : "+ app.findMin(nums));
        System.out.println("target found at : "+ app.search(nums,target));
    }
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        int n = nums.length;
        int left = 0,right = n-1;
        if (target>nums[minIndex] && target>nums[right])//detect the search space
            right = minIndex-1;
        else left = minIndex;

        return binarySearch(left,right,target,nums);//search in the specified space
    }
    private int binarySearch(int start,int end,int target, int[] nums){
        int left = start; int right = end;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]==target) return mid;

            if (nums[mid]>target)
                right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
    private int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid]<nums[right]) //if mid is less,minimum is in leftHalf(including mid)
                right = mid;
            else left=mid+1;
        }
        return left;
    }
}