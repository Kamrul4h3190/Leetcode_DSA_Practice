public class Leetcode_2540 {
    public static void main(String[] args) {
        Leetcode_2540 app = new Leetcode_2540();
        int[] nums1 = {1,2,3}; int[] nums2 = {2,4};
        System.out.println("minimum common value : "+ app.getCommon(nums1,nums2));
    }
    public int getCommon(int[] nums1, int[] nums2) {
        for (int num : nums1) //search each value of nums1 in nums2 .O(NlogM)
            if (binarySearch(nums2,num)) return num;
        return -1;
    }
    private boolean binarySearch(int[] nums, int target){
        int left = 0;   int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target) return true;

            if (nums[mid]>target) right = mid-1;
            else left = mid+1;
        }
        return false;
    }
}