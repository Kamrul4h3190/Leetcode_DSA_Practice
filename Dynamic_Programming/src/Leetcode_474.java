import java.util.Arrays;
import java.util.HashMap;

public class Leetcode_474 {
    public static void main(String[] args) {
        Leetcode_474 app = new Leetcode_474();
        String[] strs = {"0","1101","01","00111","1","10010","0","0","00","1","11","0011"};int m = 63,n=36;
//        String[] strs = {"10","0001","111001","1","0"};int m = 5,n=3;
        System.out.println("length of largest with at most(m+n) subset : "+app.findMaxForm(strs,m,n));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        memoization = new HashMap<>();
        return exploreSubsets(0,m,n,strs);
    }

    HashMap<String,Integer> memoization;
    private int exploreSubsets(int index,int needM,int needN,String[] strs){
        if(index>=strs.length) return 0;//all explored,0 more sequence to add.

        String key = index+"-"+needM+"-"+needN;
        if (memoization.containsKey(key)) return memoization.get(key);

        int[] counts = countBits(strs[index]);

        int takeString = (counts[0]<=needM && counts[1]<=needN) ?//at most m,n occurrences of 0,1
                1+exploreSubsets(index+1, needM-counts[0], needN-counts[1], strs):0;
        int skipString = exploreSubsets(index+1, needM, needN, strs);

        int maxSubsetLen = Math.max(takeString,skipString);   memoization.put(key,maxSubsetLen);
        return maxSubsetLen;
    }

    private int[] countBits(String str){
        int[] freq = new int[2];//for 0,1
        for (char c : str.toCharArray())
            freq[c - '0']++;

        return freq;
    }
}