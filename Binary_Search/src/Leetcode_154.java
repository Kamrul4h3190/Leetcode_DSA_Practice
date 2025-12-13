public class Leetcode_154 {
    public static void main(String[] args) {
        Leetcode_154 app = new Leetcode_154();
        int[] nums = {1,1};
//        int[] nums = {3,3,3,3,3,3,3,3,1,3};
//        int[] nums = {3,3,1,3};
//        int[] nums = {0,1,2,2,2};
//        int[] nums = {1,3,5};
//        int[] nums = {2,2,2,0,1};
        System.out.println("minimum Element : "+ app.findMin(nums));
    }
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0,right = n-1;
        while (left<right){
            int mid = left+(right-left)/2;

            if (nums[mid]<nums[right])
                right = mid;
            else if (nums[mid]>nums[right])
                left = mid+1;
            else //skip repeating mids
                right--;
        }
        return nums[left];
    }
//    public int findMin(int[] nums) { //my version passed 100%
//        int n = nums.length;
//        int left = 0,right = n-1;
//        while (left<right){
//            int mid = (left+right)/2;
//
//            int proceed = mid+1; //skipping the repeating mid numbers
//            while (proceed<right && nums[proceed]==nums[mid])
//                proceed++;
//
//            if (nums[mid]<=nums[right] && nums[mid]<=nums[proceed]) //if mid is less,minimum is in leftHalf(including mid)
//                right = mid;
//            else left=mid+1;
//        }
//        return nums[left];
//    }
}