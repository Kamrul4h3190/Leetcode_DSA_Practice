public class Leetcode_1539 {
    public static void main(String[] args) {
        Leetcode_1539 app = new Leetcode_1539();
        int[] arr = {2,3,4,7,11}; int k = 5;
        System.out.println("kth missing number : "+app.findKthPositive(arr,k));
    }
    int findKthPositive(int[] nums, int k) {
        int left = 0;   int right = nums.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (nums[mid] - mid -1>=k) // # of missing numbers.-1 , numbers 1 based
                right = mid-1;
            else left = mid+1;
        }
        return left+k;
    }
}