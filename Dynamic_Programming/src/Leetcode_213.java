import java.util.Arrays;

public class Leetcode_213 {
    public static void main(String[] args) {
        Leetcode_213 app = new Leetcode_213();
        int[] nums = {1,2};
//        int[] nums = {2,3,2};
        System.out.println("maximum looting amount : "+app.rob(nums));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        memHouseMoney = new int[n];

        Arrays.fill(memHouseMoney,-1);
        int robHouse1 = houseRobber1(0,n-2,nums);//end inclusive

        Arrays.fill(memHouseMoney,-1);
        int robHouse2 = houseRobber1(1,n-1,nums);

        return Math.max(robHouse1,robHouse2);
    }

    int[] memHouseMoney;
    int houseRobber1(int start, int end, int[] nums) {
        if(start > end) return 0;

        if (memHouseMoney[start]!=-1)return memHouseMoney[start];

        int loot = nums[start] + houseRobber1(start+2,end,nums) ;
        int skip = houseRobber1(start+1,end,nums);

        return memHouseMoney[start] = Math.max(loot,skip);
    }
}