import java.util.HashMap;
import java.util.Map;

public class Leetcode_974 {
    public static void main(String[] args) {
        Leetcode_974 app = new Leetcode_974();
        int[] nums = {4,5,0,-2,-3,1}; int k = 5;
//        int[] nums = {1,2,3}; int k = 3;
        System.out.println("sub arrays divisible by k : "+app.subarraysDivByK(nums,k));
    }
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;  int count = 0;
        Map<Integer,Integer> prefixSumFreq = new HashMap<>();
        for (int num : nums) {
            prefixSum+=num;
            if(prefixSum%k==0) count ++;//first divisible occurrence

            int mod = prefixSum%k;
            if (mod<0) mod+=k;//transform negative mods
            if (prefixSumFreq.containsKey(mod))//if an existing prefix sum of value prefixSum%k, there is must a new Sub array of sum equals divisible by k
                count += prefixSumFreq.get(mod);

            //update current prefix sums mods frequency
            prefixSumFreq.put(mod,prefixSumFreq.getOrDefault(mod,0)+1);
        }
        return count;
    }
}