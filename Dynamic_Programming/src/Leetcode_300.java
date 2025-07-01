import java.util.Arrays;

public class Leetcode_300 {
    public static void main(String[] args) {
        Leetcode_300 app = new Leetcode_300();
        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
//        int[] nums = {1,2,4,3};
//        int[] nums = {0,1,0,3,2,3};
//        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("LIS length : "+app.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[][]memIndexLIS = new int[nums.length][nums.length];
        for(int[]arr:memIndexLIS) Arrays.fill(arr, -1);
        return getLIS(nums, -1, memIndexLIS, 0);
    }
    public int getLIS(int[]arr, int prev, int[][]memIndexLIS, int i){
        if(i == arr.length) return 0;
        if(prev != -1 && memIndexLIS[prev][i] != -1) return memIndexLIS[prev][i];

        int include = Integer.MIN_VALUE;
        if(prev == -1 || arr[i] > arr[prev]) include = 1 + getLIS(arr, i, memIndexLIS, i+1);
        int exclude = getLIS(arr, prev, memIndexLIS, i+1);

        if(prev == -1)return Math.max(include, exclude);

        return memIndexLIS[prev][i] = Math.max(include, exclude);
    }
}