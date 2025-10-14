import java.util.ArrayList;
import java.util.List;

public class Leetcode_216 {
    public static void main(String[] args) {
        Leetcode_216 app = new Leetcode_216();
        int k=3 ,n=9;
//        int k=3 ,n=7;
        System.out.println("valid combinations : "+app.combinationSum3(k,n));
    }
    public List<List<Integer>> combinationSum3(int k, int target) {
        allCombination = new ArrayList<>();     combination = new ArrayList<>();
        generateCombinations(1,target,k);
        return allCombination;
    }
    List<List<Integer>> allCombination;     List<Integer> combination;
    private void generateCombinations(int start,int target, int k){
        if (target==0 && k==0){
            allCombination.add(new ArrayList<>(combination));
            return;
        }

        for (int num = start; num <= 9; num++) {
            if (num > target) break;

            combination.add(num);
            generateCombinations(num+1 ,target-num, k-1);
            combination.removeLast();
        }

    }
}

