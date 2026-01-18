import java.util.Arrays;

public class Leetcode_747 {
    public static void main(String[] args) {
        Leetcode_747 app = new Leetcode_747();
        int[] nums = {3,6,1,0};
        System.out.println("twice large max : "+app.dominantIndex(nums));
    }
    public int dominantIndex(int[] nums) {
        int index=-1,max=-1,prevMax=-1;//keep track of firstMax and second max
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max){
                prevMax = max;
                max = nums[i];
                index = i;
            }else if (nums[i]>prevMax)
                prevMax = nums[i];
        }
        return max >= 2*prevMax ? index : -1;
    }
}