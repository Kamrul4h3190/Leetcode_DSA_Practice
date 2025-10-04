import java.util.ArrayList;

public class Leetcode_60 {
    public static void main(String[] args) {
        Leetcode_60 app = new Leetcode_60();
//        int n = 4,k=9;
        int n = 3,k=6;
        System.out.println("winner : "+app.getPermutation(n,k));
    }
    public String getPermutation(int n, int k) {
        sequence = "";  nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i); //initiate numbers 1 based

        k--;//transfer k to 0 based
        return buildSequence(n,k);
    }
    String sequence;    ArrayList<Integer> nums;
    private String buildSequence(int n,int k){
        if (n==0) return sequence;

        int permutations = factorial(n); //number of permutations for digits 1-n
        int groupSize = permutations / n;//each digit will form a group of permutaions
        int group = k/groupSize; //find to which group k is mapped
        sequence += nums.remove(group); // add nums[group] to result

        n--;
        k = k % groupSize; //new mapping of K within reduced gropuSize
        return buildSequence(n,k);//solve the subproblem
    }
    private int factorial(int n){
        if (n<2) return 1;
        return n*factorial(n-1);
    }
}
