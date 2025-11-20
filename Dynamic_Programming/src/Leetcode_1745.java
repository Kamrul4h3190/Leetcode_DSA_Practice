public class Leetcode_1745 {
    public static void main(String[] args) {
        Leetcode_1745 app = new Leetcode_1745();
        String s = "bcddxy";
//        String s = "abcbdd";
        System.out.println("palindrome 3 partition : " + app.checkPartitioning(s));
    }

    public boolean checkPartitioning(String s) {
        n = s.length(); memPartitions = new Boolean[n][n+1]; //k 1 based
        markPalindromes = new boolean[n][n];
        int k = 3;
        detectPalindromes(s);
        return partitionPossible(0,k,s);
    }
    Boolean[][] memPartitions; int n;
    boolean[][] markPalindromes;
    boolean partitionPossible(int start, int k, String s){
        if(k==0) return start >= n;
        if (memPartitions[start][k]!=null) return memPartitions[start][k];

        boolean partition = false;
        for(int middle=start; middle<=n-k; middle++){//stop before k remaining letters
            boolean currPartition = markPalindromes[start][middle] && partitionPossible(middle+1, k-1,s); //explore from current position, with reduced k, and updated index
            partition = partition || currPartition; //if any way can partition into 3 parts
        }
        return memPartitions[start][k] = partition;
    }
    private void detectPalindromes(String s){ //build constant time palindrome lookup table
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n-l; i++) {
                int j = i + l - 1;
                if (i==j) markPalindromes[i][j] = true;
                else markPalindromes[i][j] = (s.charAt(i) == s.charAt(j) && (l <= 2 || markPalindromes[i + 1][j - 1]));
            }
        }
    }

}