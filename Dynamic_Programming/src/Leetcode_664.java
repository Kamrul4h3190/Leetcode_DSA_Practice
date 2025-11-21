public class Leetcode_664 {
    public static void main(String[] args) {
        Leetcode_664 app = new Leetcode_664();
        String s = "aba";
        System.out.println("minimum turns : " + app.strangePrinter(s));
    }

    public int strangePrinter(String s) {
        n = s.length(); memPartitions = new int[n][n];
        return explorePartition(0,n-1,s);
    }
    int[][] memPartitions; int n;
    private int explorePartition(int i, int j, String s){
        if(i==j) return 1; //1 character ,need 1 printing turn
        if (memPartitions[i][j]!=0) return memPartitions[i][j];

        int minTurns = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){ //n^2 calls through memoization.although the loop, but memoization reduces recomputation for loops. so O(n^2) , not O(n^3)
            int leftPartition = explorePartition(i,k,s);
            int rightPartition = explorePartition(k+1,j,s);
            int turns = leftPartition+rightPartition;

            minTurns = Math.min(minTurns,turns);
        } //in memoization if s[i]==s[j] , then reduce the 1 previously taken turn.
        return memPartitions[i][j] = (s.charAt(i)==s.charAt(j)) ? minTurns-1:minTurns;
    }
}