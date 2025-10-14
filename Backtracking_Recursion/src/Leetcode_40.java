import java.util.*;

public class Leetcode_40 {
    public static void main(String[] args) {
        Leetcode_40 app = new Leetcode_40();
        int[] candidates = {10,1,2,7,6,1,5}; int target = 8;
//        int[] candidates = {2,5,2,1,2}; int target = 5;
        System.out.println("target sum combinations : "+app.combinationSum2(candidates,target));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combination = new ArrayList<>();    combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,target,candidates);
        return combinations;
    }
    List<Integer> combination   ; List<List<Integer>> combinations;
    private void backtrack(int index, int target, int[] candidates ){
        if (target==0){
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i <candidates.length ; i++) {
            if (candidates[i] > target) continue; //overed,search next iterations
            if (i>index && candidates[i]==candidates[i-1]) continue;//repeatation check

            combination.add(candidates[i]);
            backtrack(i+1,target-candidates[i],candidates);
            combination.removeLast();
        }
    }
}

