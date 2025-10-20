import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_90 {
    public static void main(String[] args) {
        Leetcode_90 app = new Leetcode_90();
//        int[] nums = {1,2,3};
        int[] nums = {1,2,2};
        System.out.println("subsets : "+ app.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        allSubset = new ArrayList<>();  subset = new ArrayList<>();
        Arrays.sort(nums);//sort to gather duplicates
        generateSubsets(0,nums);
        return allSubset;
    }
    List<List<Integer>> allSubset;  List<Integer> subset;
    private void generateSubsets(int index, int[] nums){
        allSubset.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            if (i>index && nums[i]==nums[i-1] ) continue; //avoid repeats
            subset.add(nums[i]);
            generateSubsets(i+1,nums);
            subset.removeLast();
        }
    }
}

