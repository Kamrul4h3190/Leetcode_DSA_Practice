import java.util.ArrayList;
import java.util.List;

public class Leetcode_78 {
    public static void main(String[] args) {
        Leetcode_78 app = new Leetcode_78();
        int[] nums = {1,2,3};
        System.out.println("subsets : "+ app.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        allSubset = new ArrayList<>();  subset = new ArrayList<>();
        generateSubsets(0,nums);
        return allSubset;
    }
    List<List<Integer>> allSubset;  List<Integer> subset;
    private void generateSubsets(int index, int[] nums){
        allSubset.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]); //take current and explore next elements
            generateSubsets(i+1,nums);
            subset.removeLast();
        }
    }
}

