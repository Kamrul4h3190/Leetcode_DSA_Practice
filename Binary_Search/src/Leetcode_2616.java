import java.util.Arrays;

public class Leetcode_2616 {
    public static void main(String[] args) {
        Leetcode_2616 app = new Leetcode_2616();
        int[] nums = {1,1,2,4,9,10}; int p = 2;
//        int[] nums = {4,2,1,2}; int p = 1;
        System.out.println("minimized max : "+app.minimizeMax(nums,p));
    }
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n-1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (pairsFound(mid,p,nums))
                right = mid;
            else left = mid + 1;
        }
        return left;
    }
    private boolean pairsFound(int mid, int p,int[] nums){
        int pairs = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] <= mid) {
                pairs++;
                if (pairs==p) return true;//early stop
                i++;
            }
        }
        return pairs>=p;
    }
//    private boolean pairsFound(int mid, int p,int[] nums){
//        int found = 0;
//        for (int i = 1; i < nums.length && found<p; i++) { //early stop , exactly after found p pairs
//            if (nums[i] - nums[i-1] <= mid) {
//                found++;
//                i++;
//            }
//        }
//        return found==p;
//    }
}