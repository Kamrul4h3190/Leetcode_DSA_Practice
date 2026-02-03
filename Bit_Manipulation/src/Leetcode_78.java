import java.util.ArrayList;
import java.util.List;

public class Leetcode_78 {
    public static void main(String[] args) {
        Leetcode_78 app = new Leetcode_78();
        int[] nums = {6,2,3};
        System.out.println("all subsets : "+app.subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int bits = nums.length;
        int maxMask = 1<<bits; //2^bits
        for (int mask = 0; mask < maxMask; mask++) {//O(N*2^N)
            List<Integer> subset = new ArrayList<>();
            for (int bit = 0; bit < bits; bit++) {
                if ((mask>>bit & 1)==1)
                    subset.add(nums[bit]);
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
