import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_560 {
    public static void main(String[] args) {
        Leetcode_560 app = new Leetcode_560();
        int[] nums = {1,2,3}; int k = 3;
        System.out.println("majority element : "+app.subarraySum(nums,k));
    }
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;  int count = 0;
        Map<Integer,Integer> prefixSumFreq = new HashMap<>();
        for (int num : nums) {
            prefixSum+=num;
            if (prefixSum==k)
                count++;
            if (prefixSumFreq.containsKey(prefixSum-k)){//if an existing prefix sum of value prefixSum-k, there is must a new Sub array of sum equals k
                count += prefixSumFreq.get(prefixSum-k);
            }
            //update current prefix sums frequency
            prefixSumFreq.put(prefixSum,prefixSumFreq.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}