import java.util.*;

public class Leetcode_2597 {
    public static void main(String[] args) {
        Leetcode_2597 app = new Leetcode_2597();
        int[] nums = {1,1,2,3};   int k = 1;
//        int[] nums = {2,4,6};   int k = 2;
        System.out.println("Beautiful subsets : "+ app.beautifulSubsets(nums,k));
    }
    int beautifulSubsets(int[] nums,int k) {
        allSubset = new ArrayList<>();  subset = new ArrayList<>();     usedIndex = new boolean[nums.length];
        generateSubsets(0,nums,k);
        return allSubset.size();
    }

//    List<List<Integer>> beautifulSubsets(int[] nums,int k) { //display all the targeted subsets
//        allSubset = new ArrayList<>();  subset = new ArrayList<>();     usedIndex = new boolean[nums.length];
//        generateSubsets(0,nums,k);
//        return allSubset;
//    }
    List<List<Integer>> allSubset;  List<Integer> subset;  boolean[] usedIndex;
    private void generateSubsets(int index, int[] nums,int k){
        if (!subset.isEmpty()) allSubset.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            if (usedIndex[i]) continue;
            if (subset.contains(nums[i]+k) || subset.contains(nums[i]-k) ) continue;

            subset.add(nums[i]);    usedIndex[i] = true;
            generateSubsets(i+1,nums,k);
            subset.removeLast();     usedIndex[i] = false;
        }
    }
}

