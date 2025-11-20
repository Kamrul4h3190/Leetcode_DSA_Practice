public class Leetcode_2472 {
    public static void main(String[] args) {
        Leetcode_2472 app = new Leetcode_2472();
        String s = "abaccdbbd"; int k = 3;
//        String s = "abaccdbbd"; int k = 3;
//        String s = "adbcda"; int k = 2;
//        String s = "abacc"; int k = 2;
//        String s = "aabbc"; int k = 3;
//        String s = "mepekjkpgihfcg"; int k = 12;
//        String s = "abc"; int k = 1;
        System.out.println("maximum palindromes : " + app.maxPalindromes(s,k));
    }

    public int maxPalindromes(String s, int k) {
        n = s.length(); memPartitions = new Integer[n];
        markPalindromes = new boolean[n][n];
        detectPalindromes(s);
        return partition(0,k,s);
    }
    Integer[] memPartitions; int n;
    boolean[][] markPalindromes;
    private int partition(int start, int k, String s){
        if(start>=n) return 0;
        if (memPartitions[start]!=null) return memPartitions[start];

        int maxPalindromes = 0;
        for(int middle=start+k-1; middle<n; middle++){
            int palindromes = 0;
            if (markPalindromes[start][middle])
                palindromes = 1+ partition(middle+1,k,s);
            else
                palindromes = partition(start+1,k,s);//not palindrome from here,slide window

            maxPalindromes = Math.max(maxPalindromes,palindromes);
        }
        return memPartitions[start] = maxPalindromes;
    }
    private void detectPalindromes(String s){ //build constant time palindrome lookup table
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n-l; i++) {
                int j = i + l - 1;
                markPalindromes[i][j] = (s.charAt(i) == s.charAt(j) && (l <= 2 || markPalindromes[i + 1][j - 1]));
            }
        }
    }
}