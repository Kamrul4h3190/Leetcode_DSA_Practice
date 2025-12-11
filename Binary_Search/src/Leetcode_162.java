public class Leetcode_162 {
    public static void main(String[] args) {
        Leetcode_162 app = new Leetcode_162();
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println("Peak Element : "+ app.findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        return binarySearch(nums);
    }
    private int binarySearch(int[] nums) {
        int n = nums.length;
        int left = 0; int right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            int prevNum = mid-1>=0 ? nums[mid-1] : Integer.MIN_VALUE;//boundary out cases
            int nextNum = mid+1<n ? nums[mid+1] : Integer.MIN_VALUE;

            if (nums[mid]>prevNum && nums[mid]>nextNum) return mid;//peak element found at mid

            if (nums[mid]<prevNum)//nums[mid] is less than prevNum means, there is a peak at leftHalf
                right = mid-1;
            else left = mid+1;//else peak is at right half
        }
        return -1;//syntactical return
    }
}