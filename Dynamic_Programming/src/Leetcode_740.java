public class Leetcode_740 {
    public static void main(String[] args) {
        Leetcode_740 app = new Leetcode_740();
        int[] nums = {2,2,3,3,3,4};
        System.out.println("maximum points : "+app.deleteAndEarn(nums));
    }
    public int deleteAndEarn(int[] nums) {
        int max = 0;    for (int num : nums) max = Math.max(max,num);
        int[] numberPoints = new int[max+1];    memHouseMoney = new int[max+1];//1 indexed

        for (int num : nums) numberPoints[num] += num; //accumulate number wise point sums
        return houseRobber(1,numberPoints);
    }
    //transfer the problem to a house robber problem. It will take care of the rest
    int[] memHouseMoney;
    int houseRobber(int index, int[] numberPoints) {
        if(index >= numberPoints.length) return 0;

        if (memHouseMoney[index]!=0)return memHouseMoney[index];

        int loot = numberPoints[index] + houseRobber(index+2,numberPoints) ;
        int skip = houseRobber(index+1,numberPoints);

        return memHouseMoney[index] = Math.max(loot,skip);
    }
}