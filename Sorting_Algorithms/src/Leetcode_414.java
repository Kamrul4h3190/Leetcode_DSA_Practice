import java.util.Arrays;

public class Leetcode_414 {
    public static void main(String[] args) {
        Leetcode_414 app = new Leetcode_414();
        int[] nums = {1,1,2};
//        int[] nums = {1,2,2,5,3,5};
//        int[] nums = {2,2,2,1};
//        int[] nums = {1,2,3};
//        int[] nums = {2,2,3,1};
        System.out.println("Third max : "+app.thirdMax(nums));
    }
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int k = 3;
        int n = nums.length;    int i = n;
        while (i-->0){
            while (i>0 && nums[i]==nums[i-1])//skip repeating nums
                i--;
            if(i==0) break;//exhausted before finding k max distinct number
            k--;//discarding first k-1 maxes
            if (k==1) return nums[i-1];//found kth max. in the i th position now is 2nd max. so third max is just previous
        }
        return nums[n-1];
    }
}