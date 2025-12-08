public class Leetcode_540 {
    public static void main(String[] args) {
        Leetcode_540 app = new Leetcode_540();
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println("single element : "+app.singleNonDuplicate(nums));
    }
    public int singleNonDuplicate(int[] nums) {
        int position = singlePosition(nums);
        return nums[position];
    }
    private int singlePosition(int[] nums){//converge to single existing element
        int left = 0;   int right = nums.length-1;
        while (left<right){
            int mid = left+(right-left)/2;
            if (mid%2==1) mid--; //keep mid even

            if (nums[mid]!=nums[mid+1])
                right = mid;
            else left = mid+2;
        }
        return left;
    }
}