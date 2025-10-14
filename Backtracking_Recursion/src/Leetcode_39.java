import java.util.ArrayList;
import java.util.List;

public class Leetcode_39 {
    public static void main(String[] args) {
        Leetcode_39 app = new Leetcode_39();
        int[] candidates = {2,3,6,7}; int target = 7;
        System.out.println("target sum combinations : "+app.combinationSum2(candidates,target));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(0,target,candidates,new ArrayList<>(),combinations);
        return combinations;
    }
    private void backtrack(int index, int target, int[] candidates, List<Integer> combination, List<List<Integer>> combinations){
        if (target==0){
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i <candidates.length ; i++) {
            if (candidates[i] > target) continue; //adding the current element will over the target, skip it ,and check for the next element i++(through loop)
            combination.add(candidates[i]);
            backtrack(i,target-candidates[i],candidates,combination,combinations);
            combination.removeLast();
        }
    }
}

