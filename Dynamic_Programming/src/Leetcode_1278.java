public class Leetcode_1278 {
    public static void main(String[] args) {
        Leetcode_1278 app = new Leetcode_1278();
//        String s = "mepekjkpgihfcg"; int k = 12;
        String s = "leetcode"; int k = 8;
//        String s = "aabbc"; int k = 3;
//        String s = "mepekjkpgihfcg"; int k = 12;
//        String s = "abc"; int k = 1;
        System.out.println("minimum change for palindrome partitioning : " + app.palindromePartition(s,k));
    }

    public int palindromePartition(String s, int k) {
        n = s.length(); memPartitions = new Integer[n][n+1]; //k 1 based
        return findMin(0,k,s);
    }
    Integer[][] memPartitions; int n;
    private int findMin(int start,int k,String s){
        if(k==0) return start<n ? n:0; //n-not possible, 0-possible to partition successfully in k substrings
        if (memPartitions[start][k]!=null) return memPartitions[start][k];

        int minChanges = s.length();
        for(int middle=start; middle<=n-k; middle++){//early stop , before k letters
            int changes = palindromeCost(s, start, middle) + findMin(middle+1, k-1,s);
            minChanges = Math.min(minChanges,changes);
        }
        return memPartitions[start][k] = minChanges;
    }
    private int palindromeCost(String s, int l, int r){
        int changes = 0;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) changes++;
            l++; r--;
        }
        return changes;
    }

}