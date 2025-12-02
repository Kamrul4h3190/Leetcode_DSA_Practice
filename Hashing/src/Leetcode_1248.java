import java.util.HashMap;
import java.util.Map;

public class Leetcode_1248 {
    public static void main(String[] args) {
        Leetcode_1248 app = new Leetcode_1248();
        int[] nums = {1,1,2,1,1}; int k = 3;
        System.out.println("nice sub arrays : "+app.numberOfSubarrays(nums,k));
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int oddCount = 0;  int niceCount = 0;
        Map<Integer,Integer> prefixSumFreq = new HashMap<>();
        for (int num : nums) {
            if (num%2==1) oddCount++; //count odds
            if (oddCount==k) niceCount++;//first occurrence of finding k odd elements

            int required = oddCount-k; //find how much additional odd elements needed to form k odd elements
            if (prefixSumFreq.containsKey(required))//if an existing prefix sum of value oddCount-k, there is must a new Sub array of sum equals k
                niceCount += prefixSumFreq.get(required);

            //update current prefix sums frequency
            prefixSumFreq.put(oddCount,prefixSumFreq.getOrDefault(oddCount,0)+1);
        }
        return niceCount;
    }
}