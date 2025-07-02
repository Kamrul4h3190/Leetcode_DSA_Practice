import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Leetcode_746 {
    public static void main(String[] args) {
        Leetcode_746 app = new Leetcode_746();
//        int[] nums = {2,2,3,3,4,3};
//        int[] nums = {2,2,3,3,3,4};
//        int[] nums = {3,4,2};
        int[] nums = {1,1,1,2,4,5,5,5,6};
        System.out.println("max earn : "+app.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer> countingMap = new HashMap<>();
        for (int num :nums) countingMap.put(num, countingMap.getOrDefault(num,0)+1);

        int earning = 0;
        for (int i = 5; i < nums.length; i++) {
            int localEarning = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                if (!set.contains(nums[j])){
                    if( nums[j]!=nums[i]+1 &&  nums[j]!=nums[i]-1){
                        localEarning +=  nums[j]*countingMap.get(nums[j]);
//                        earning = Math.max(localEarning , earning);
                    }
                    set.add(nums[j]);
                }
            }
            earning = Math.max(localEarning , earning);
        }

        return earning;
    }
}