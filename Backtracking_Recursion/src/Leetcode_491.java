import java.util.*;

public class Leetcode_491 {
    public static void main(String[] args) {
        Leetcode_491 app = new Leetcode_491();
        int[] nums = {4,4,3,2,1};
//        int[] nums = {4,6,7,7};
        System.out.println("subsets : "+ app.findSubsequences(nums));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        allSubset = new ArrayList<>();  subset = new ArrayList<>();
        generateSubsequences(0,nums);
        return allSubset;
    }
    List<List<Integer>> allSubset;  List<Integer> subset;
    private void generateSubsequences(int index, int[] nums){
        if (subset.size()>=2) allSubset.add(new ArrayList<>(subset));

        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) continue; //repeat check, number used in current sequence
            if (subset.isEmpty() || nums[i] >= subset.getLast()){
                subset.add(nums[i]);    used.add(nums[i]);
                generateSubsequences(i+1,nums);
                subset.removeLast();
            }
        }
    }
}

