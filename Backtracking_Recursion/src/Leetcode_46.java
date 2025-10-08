import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_46 {
    public static void main(String[] args) {
        Leetcode_46 app = new Leetcode_46();
        int[] nums = {1,2,3};
        System.out.println("permutations : "+app.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        allPermutation = new ArrayList<>();   taken = new HashSet<>();
        permutation = new ArrayList<>();
        explore(nums);      return allPermutation;
    }
    List<List<Integer>> allPermutation;     List<Integer> permutation;
    Set<Integer> taken;
    private void explore(int[] nums){
        if (permutation.size()== nums.length){
            allPermutation.add(new ArrayList<>(permutation));
            return;
        }
        for (int n : nums) {
            if (taken.contains(n)) continue;
            taken.add(n);   permutation.add(n);
            explore(nums);
            taken.remove(n);    permutation.removeLast();//backtrack. undo changes for this step to explore next permutations
        }
    }
}
