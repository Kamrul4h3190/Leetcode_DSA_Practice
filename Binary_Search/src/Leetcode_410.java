public class Leetcode_410 {
    public static void main(String[] args) {
        Leetcode_410 app = new Leetcode_410();
        int[] nums = {7,2,5,10,8}; int k = 2;
//        int[] nums = {1,2,3,4,5}; int k = 2;
        System.out.println("minimized maxSum of split : "+ app.splitArray(nums,k));
    }
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int w : nums){
            left = Math.max(left,w);
            right += w;
        }

        while (left<right){
            int mid = left+(right-left)/2;
            if (canSplit(mid,k,nums))
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }
    private boolean canSplit(int maxSum,int k,int[] nums){
        int sum=0,groups=1;
        for (int n : nums) {
            sum+=n;
            if (sum>maxSum){
                sum = n;//reset sum for new group
                groups++;
                if (groups>k) return false;
            }
        }
        return true;
    }
}