import java.util.ArrayList;
import java.util.List;

public class Leetcode_77 {
    public static void main(String[] args) {
        Leetcode_77 app = new Leetcode_77();
//        int n = 10;
//        int n = 11;
        int n = 4,k=2;
        System.out.println("combinations : "+app.combine(n,k));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(1,n,k,new ArrayList<>(),combinations);
        return combinations;
    }
    private void backtrack(int start,int n,int k,ArrayList<Integer> combination,List<List<Integer>> combinations) {
        if (k==0) //a combination containing k numbers has been formed, include it
            {combinations.add(new ArrayList<>(combination)); return;}

        for (int i = start; i <= n; i++) {//starting from start so no need to care repeating combinations like (1,3),(3,1)
            combination.add(i);
            backtrack(i+1, n, k-1, combination, combinations);
            combination.remove(combination.size()-1);
        }
    }
}

