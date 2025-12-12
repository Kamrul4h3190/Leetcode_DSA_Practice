public class Leetcode_153 {
    public static void main(String[] args) {
        Leetcode_153 app = new Leetcode_153();
        int[] nums = {3,4,5,1,2};
        System.out.println("minimum Element : "+ app.findMin(nums));
    }
    public int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
        int mid=0;
        while (left<=right){
            mid = (left+right)/2;
            if (nums[mid]<nums[right]) //if mid is less,minimum is in leftHalf(including mid)
                right = mid;
            else left=mid+1;
        }
        return nums[mid];
    }
}